(ns dataimitator.phone.core)

(defn random-phone-number
  "Generate a random phone number with optional format.
   Supported formats: :usa, :europe, :international.
   Defaults to :usa format if none specified."
  ([] (random-phone-number :usa))
  ([format]
   (let [random-digit #(rand-int 10)
         random-digits (fn [n] (apply str (repeatedly n random-digit)))
         format-number (fn [parts]
                         (clojure.string/join "-" parts))]
     (case format
       :usa (format-number [(random-digits 3) (random-digits 3) (random-digits 4)])
       :europe (str "+" (random-digit) " " (random-digits 3) " " (random-digits 3) " " (random-digits 4))
       :international (str "+" (inc (rand-int 999)) " " (random-digits 10))
       ;; Default to the USA format if unrecognized format is provided
       (recur :usa)))))
