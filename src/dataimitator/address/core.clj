(ns dataimitator.address.core)

(def countries
  {:ar ["المملكة العربية السعودية" "مصر" "الإمارات العربية المتحدة" "الجزائر" "المغرب" "العراق" "اليمن" "سوريا" "السودان"]
   :de ["Deutschland" "Österreich" "Schweiz" "Belgien" "Niederlande" "Frankreich" "Italien" "Spanien" "Portugal"]
   :en ["United States" "Canada" "United Kingdom" "Australia" "New Zealand" "India" "South Africa" "Nigeria" "Kenya"]
   :es ["España" "México" "Argentina" "Colombia" "Perú" "Chile" "Ecuador" "Venezuela" "Guatemala"]
   :fr ["France" "Belgique" "Suisse" "Canada" "Maroc" "Algérie" "Tunisie" "Sénégal" "Côte d'Ivoire"]
   :tr ["Türkiye" "Almanya" "Fransa" "İngiltere" "Hollanda" "Belçika" "İspanya" "İtalya" "Yunanistan"]})

(defn random-address
  "Generates random address data in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr.
   Defaults to :en if no language is specified."
  ([] (random-address :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         streets ["Main Street" "Park Avenue" "Elm Street" "Broadway" "High Street" "Abbey Road"]
         cities ["New York" "Los Angeles" "London" "Berlin" "Paris" "Rome"]
         states ["CA" "NY" "TX" "FL" "ON" "NS"]
         postcodes ["10001" "90210" "75001" "94102" "WC1E 7HU" "75008"]
         buildings (str (rand-int 1000))
         countries-list (get countries language ["Unknown"])
         country (rand-nth countries-list)
         country-code (case lang
                        "en" "US"
                        "de" "DE"
                        "es" "ES"
                        "fr" "FR"
                        "ar" "SA"
                        "tr" "TR"
                        :else "US")
         coordinates [(str (rand-int 180) "." (rand-int 9999999)) (str (rand-int 180) "." (rand-int 9999999))]]
     {:street (rand-nth streets)
      :city (rand-nth cities)
      :state (rand-nth states)
      :postcode (rand-nth postcodes)
      :coordinates coordinates
      :building-number buildings
      :country country
      :country-code country-code})))
