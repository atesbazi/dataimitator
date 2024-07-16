(ns dataimitator.word.conjuction.core)

(def conjunctions-data
  {:ar ["لكن" "ولكن" "بل" "أو" "إذا" "إذ" "أو" "لذلك" "ثم" "بينما" "في حين" "ومع ذلك" "بينما" "حتى"
        "إذن" "إذا" "من أجل أن" "بحيث" "عندما" "ما دام"]
   :de ["aber" "sondern" "oder" "wenn" "wenn auch" "denn" "da" "weil" "damit" "obwohl"
        "solange" "bis" "während" "indem" "seit" "seitdem" "sobald" "sofern" "sowie" "doch"]
   :en ["and" "but" "or" "although" "since" "because" "while" "if" "unless" "until"
        "when" "whereas" "whether" "whether or not" "as much as" "as soon as" "now that" "even if"
        "even though" "in case"]
   :es ["y" "pero" "o" "aunque" "porque" "mientras" "si" "como" "hasta que" "antes de que"
        "después de que" "siempre que" "puesto que" "en vez de" "a pesar de" "aun cuando" "a condición de que"
        "a medida que" "así como" "ya que"]
   :fr ["et" "mais" "ou" "quoique" "parce que" "pendant que" "si" "comme" "jusqu'à ce que" "avant que"
        "après que" "chaque fois que" "tandis que" "puisque" "plutôt que" "malgré que" "bien que" "pourvu que"
        "dès que" "aussi longtemps que"]
   :tr ["ve" "ama" "veya" "fakat" "ancak" "çünkü" "önceden" "sonra" "eğer" "rağmen"
        "karşın" "ise" "çünkü" "nedeniyle" "dolayı" "şayet" "ki" "hem" "hatta" "olduğu gibi"]})

(defn random-conjunction
  "Generates a random conjunction in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr.
   Defaults to :en if no language is specified."
  ([] (random-conjunction :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         conjunctions (get conjunctions-data (keyword lang))]
     (if conjunctions
       (rand-nth conjunctions)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))
