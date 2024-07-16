(ns dataimitator.finance.core
  (:require [dataimitator.helper.utils :refer
             [random-alphanumeric random-in-range]]))

(defn random-credit-card []
  "Generate a random credit card-like number."
  (let [prefix (rand-nth ["4" "5" "3" "6"])                 ; Example: Visa, MasterCard, Amex, Discover
        length 16                                           ; Typical length of credit card numbers
        digits (str prefix (apply str (repeatedly (- length 1) #(rand-int 10))))]
    digits))

(def currencies
  {:USD "$"                                                 ; United States Dollar
   :EUR "€"                                                 ; Euro
   :JPY "¥"                                                 ; Japanese Yen
   :GBP "£"                                                 ; British Pound Sterling
   :AUD "A$"                                                ; Australian Dollar
   :CAD "C$"                                                ; Canadian Dollar
   :CHF "CHF"                                               ; Swiss Franc
   :CNY "¥"                                                 ; Chinese Yuan Renminbi
   :TRL "₺"                                                 ; Turkish Lira
   :NZD "NZ$"})                                             ; New Zealand Dollar

(defn random-currency-symbol []
  "Generate a random currency symbol from the top 10 currencies in the world."
  (let [currency (rand-nth (keys currencies))]
    (get currencies currency)))

(def country-codes
  {"AL" 28 "AD" 24 "AT" 20 "AZ" 28 "BH" 22 "BE" 16 "BA" 20 "BR" 29 "BG" 22
   "CR" 21 "HR" 21 "CY" 28 "CZ" 24 "DK" 18 "DO" 28 "EE" 20 "FO" 18 "FI" 18
   "FR" 27 "GE" 22 "DE" 22 "GI" 23 "GR" 27 "GL" 18 "GT" 28 "HU" 28 "IS" 26
   "IE" 22 "IL" 23 "IT" 27 "KZ" 20 "KW" 30 "LV" 21 "LB" 28 "LI" 21 "LT" 20
   "LU" 20 "MK" 19 "MT" 31 "MR" 27 "MU" 30 "MC" 27 "MD" 24 "ME" 22 "NL" 18
   "NO" 15 "PK" 24 "PS" 29 "PL" 28 "PT" 25 "QA" 29 "RO" 24 "SM" 27 "SA" 24
   "RS" 22 "SK" 24 "SI" 19 "ES" 24 "SE" 24 "CH" 21 "TN" 24 "TR" 26 "AE" 23
   "GB" 22 "VG" 24})

(defn generate-check-digits []
  (format "%02d" (rand-int 100)))

(defn generate-bban [length]
  (apply str (repeatedly (- length 4) #(rand-int 10))))

(defn generate-iban [country-code]
  (let [length (get country-codes country-code)
        check-digits (generate-check-digits)
        bban (generate-bban length)]
    (when length
      (str country-code check-digits bban))))

(defn random-iban []
  (let [country-code (rand-nth (keys country-codes))]
    (generate-iban country-code)))

(defn random-pin
  "Generates a random PIN number with optional length."
  ([] (random-pin 4))
  ([length]
   (let [digits (apply str (repeatedly length #(str (rand-int 10))))]
     digits)))

(defn random-invoice
  "Generates random invoice data with optional currency symbol.
   Supported currencies: :USD, :EUR, :JPY, :GBP, :AUD, :CAD, :CHF, :CNY, :TRL, :NZD.
   Defaults to :USD if no currency symbol is provided."
  ([] (random-invoice :USD))
  ([currency]
   (let [invoice-number (str "INV-" (rand-int 10000))
         invoice-date (str (random-in-range 1 31) "/" (inc (random-in-range 1 12)) "/" (random-in-range 2020 2050))
         customer-name (rand-nth ["Company A" "Company B" "Company C"])
         item-names (repeatedly (rand-int 10) #(str "Item " (rand-int 100)))
         item-prices (repeatedly (rand-int 10) #(rand-int 1000))
         items (mapv #(hash-map :name %1 :price %2) item-names item-prices)
         currency-symbol (or (get currencies currency) "$")
         total (reduce + (map :price items))
         formatted-total (str currency-symbol total)]
     {:invoice-number invoice-number
      :invoice-date invoice-date
      :customer-name customer-name
      :items items
      :total formatted-total})))

(defn random-invoices
  "Generates n random invoices with default currency symbol ($)."
  [n]
  (repeatedly n #(random-invoice)))
