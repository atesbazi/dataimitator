(ns dataimitator.animal.dogs)

(def dog-species
  {:ar ["لابرادور ريتريفر" "الراعي الألماني" "الريتريفر الذهبي" "البولدوغ الفرنسي"
        "البولدوغ" "البودل" "البيغل" "الروتوايلر" "تيرير يوركشاير" "الملاكم"]
   :de ["Labrador Retriever" "Deutscher Schäferhund" "Golden Retriever" "Französische Bulldogge"
        "Bulldogge" "Pudel" "Beagle" "Rottweiler" "Yorkshire Terrier" "Boxer"]
   :en ["Labrador Retriever" "German Shepherd" "Golden Retriever" "French Bulldog"
        "Bulldog" "Poodle" "Beagle" "Rottweiler" "Yorkshire Terrier" "Boxer"]
   :es ["Labrador Retriever" "Pastor Alemán" "Golden Retriever" "Bulldog Francés"
        "Bulldog" "Caniche" "Beagle" "Rottweiler" "Yorkshire Terrier" "Boxer"]
   :fr ["Labrador Retriever" "Berger Allemand" "Golden Retriever" "Bouledogue Français"
        "Bulldog" "Caniche" "Beagle" "Rottweiler" "Yorkshire Terrier" "Boxer"]
   :tr ["Labrador Retriever" "Alman Çoban Köpeği" "Altın Retriever" "Fransız Bulldog"
        "Bulldog" "Kaniş" "Beagle" "Rottweiler" "Yorkshire Terrier" "Boksör"]})

(defn random-dog
  "Generates a random dog species name in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr
   Defaults to :en if no language is specified."
  ([] (random-dog :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         names (get dog-species (keyword lang))]
     (if names
       (rand-nth names)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))