(ns dataimitator.word.preposition.core)

(def prepositions-data
  {:ar ["في" "على" "من" "إلى" "عن" "حتى" "مع" "دون" "بين" "ب" "على" "فيما" "ضد" "بفضل" "لدى" "حيال" "بينما"
        "وسط" "خلال" "حول"]
   :de ["in" "an" "auf" "unter" "über" "vor" "hinter" "zwischen" "neben" "ohne" "durch" "gegenüber" "während" "seit"
        "ab" "bis" "um" "trotz" "statt" "mit"]
   :en ["in" "on" "at" "by" "with" "to" "from" "into" "through" "during" "before" "after" "under" "over" "between"
        "among" "along" "across" "out of" "except"]
   :es ["en" "sobre" "bajo" "frente a" "tras" "junto a" "desde" "hasta" "por" "para" "durante" "ante" "contra"
        "a través de" "según" "con" "sin" "mientras" "entre" "dentro de"]
   :fr ["à" "de" "par" "pour" "avec" "sans" "sous" "sur" "dans" "devant" "derrière" "chez" "entre" "jusqu'à" "vers"
        "contre" "pendant" "depuis" "envers" "hors"]
   :tr ["için" "de" "da" "ile" "kadar" "aşağı" "yukarı" "önünde" "arkasında" "karşısında" "arasında" "üzerinde"
        "altında" "dışında" "şeklinde" "doğrultusunda" "şartıyla" "dolayı" "rağmen" "beri"]})

(defn random-preposition
  "Generates a random preposition in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr.
   Defaults to :en if no language is specified."
  ([] (random-preposition :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         prepositions (get prepositions-data (keyword lang))]
     (if prepositions
       (rand-nth prepositions)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))
