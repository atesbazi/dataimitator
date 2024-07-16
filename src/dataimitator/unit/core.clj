(ns dataimitator.unit.core)

(def length-units
  {:ar ["متر" "سنتيمتر" "كيلومتر" "ملليمتر" "قدم" "بوصة" "ميل" "ياردة" "فرسخ" "مكعب"]
   :de ["Meter" "Zentimeter" "Kilometer" "Millimeter" "Fuß" "Zoll" "Meile" "Yard" "Parsec" "Kubik"]
   :en ["Meter" "Centimeter" "Kilometer" "Millimeter" "Foot" "Inch" "Mile" "Yard" "Parsec" "Cubic"]
   :es ["Metro" "Centímetro" "Kilómetro" "Milímetro" "Pie" "Pulgada" "Milla" "Yarda" "Pársec" "Cúbico"]
   :fr ["Mètre" "Centimètre" "Kilomètre" "Millimètre" "Pied" "Pouce" "Mille" "Yard" "Parsec" "Cubic"]
   :tr ["Metre" "Santimetre" "Kilometre" "Milimetre" "Ayak" "İnç" "Mil" "Yarda" "Parsek" "Kübik"]})

(def volume-units
  {:ar ["لتر" "ملليلتر" "سنتي لتر" "ديسيلتر" "متر مكعب" "سنتيمتر مكعب" "ديسيمتر مكعب" "جالون"
        "باينت" "ربع جالون"]
   :de ["Liter" "Milliliter" "Zentiliter" "Deziliter" "Kubikmeter" "Kubikzentimeter"
        "Kubikdezimeter" "Gallone" "Pint" "Quart"]
   :en ["Liter" "Milliliter" "Centiliter" "Deciliter"
        "Cubic meter" "Cubic centimeter" "Cubic decimeter" "Gallon" "Pint" "Quart"]
   :es ["Litro" "Mililitro" "Centilitro" "Decilitro"
        "Metro cúbico" "Centímetro cúbico" "Decímetro cúbico" "Galón" "Pinta" "Cuarto de galón"]
   :fr ["Litre" "Millilitre" "Centilitre" "Décilitre"
        "Mètre cube" "Centimètre cube" "Décimètre cube" "Gallon" "Pinte" "Quart"]
   :tr ["Litre" "Mililitre" "Santilitre" "Desilitre"
        "Metreküp" "Santimetreküp" "Desimetreküp" "Galon" "Pint" "Çeyrek galon"]})

(def weight-units
  {:ar ["جرام" "كيلوجرام" "مليجرام" "طن" "أوقية" "رطل"]
   :de ["Gramm" "Kilogramm" "Milligramm" "Tonne" "Unze" "Pfund"]
   :en ["Gram" "Kilogram" "Milligram" "Ton" "Ounce" "Pound"]
   :es ["Gramo" "Kilogramo" "Miligramo" "Tonelada" "Onza" "Libra"]
   :fr ["Gramme" "Kilogramme" "Milligramme" "Tonne" "Once" "Livre"]
   :tr ["Gram" "Kilogram" "Miligram" "Ton" "Ons" "Pound"]})

(defn random-unit-of-length
  "Generates a random unit of length in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr.
   Defaults to :en if no language is specified."
  ([] (random-unit-of-length :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         units (get length-units (keyword lang))]
     (if units
       (rand-nth units)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))

(defn random-volume-unit
  "Generates a random volume measurement unit in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr.
   Defaults to :en if no language is specified."
  ([] (random-volume-unit :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         units (get volume-units (keyword lang))]
     (if units
       (rand-nth units)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))

(defn random-weight-unit
  "Generates a random weight measurement unit in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr.
   Defaults to :en if no language is specified."
  ([] (random-weight-unit :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         units (get weight-units (keyword lang))]
     (if units
       (rand-nth units)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))
