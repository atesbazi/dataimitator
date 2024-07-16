(ns dataimitator.shopping.prices
  (:require [clojure.string :as str]))

(def currency-formats
  {:ar {:symbol "د.إ" :position :after  :separator "," :decimal "."}
   :de {:symbol "€"   :position :after  :separator "." :decimal ","}
   :en {:symbol "$"   :position :before :separator "," :decimal "."}
   :es {:symbol "€"   :position :after  :separator "." :decimal ","}
   :fr {:symbol "€"   :position :after  :separator " " :decimal ","}
   :tr {:symbol "₺"   :position :after  :separator "." :decimal "," :prefix "tr "}
   :jp {:symbol "¥"   :position :before :separator "," :decimal "."}
   :gb {:symbol "£"   :position :before :separator "," :decimal "."}
   :kw {:symbol "د.ك" :position :after  :separator "," :decimal "."} })

(defn format-price [amount {:keys [symbol position separator decimal prefix]}]
  (let [formatted (format "%.2f" amount)
        [integer fraction] (str/split formatted #"\.")
        integer-part (str/join separator (reverse (re-seq #"\d{1,3}" (str/reverse integer))))
        price (str integer-part fraction)]
    (cond
      (= position :before) (str (or prefix "") symbol price)
      :else (str price symbol))))

(defn random-price
  "Generates a random price within the specified range (optional) in the specified currency.
   Supported currencies: :ar, :de, :en, :es, :fr, :tr, :jp, :gb, :kw.
   Defaults to :en (Dollar) if no currency is specified."
  ([] (random-price 0 1000 :en))
  ([currency] (random-price 0 1000 currency))
  ([min max] (random-price min max :en))
  ([min max currency]
   (let [amount (+ min (rand (- max min)))
         currency-format (get currency-formats currency (:en currency-formats))]
     (format-price amount currency-format))))
