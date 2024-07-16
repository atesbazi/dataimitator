(ns dataimitator.word.adverb.core)

(def adverbs-data
  {:ar ["بسرعة" "ببطء" "جيدًا" "سرا" "علنا" "كما ينبغي" "بعناية" "بإهمال" "بشكل جيد" "بشكل سيء"
        "بشكل سهل" "بشكل صعب" "بشكل مرح" "بشكل حزين" "بشكل عميق" "بشكل ضحل" "بشكل نقي" "بشكل قذر"
        "بشكل ساخن" "بشكل بارد" "بشكل ناعم" "بشكل خشن" "بشكل جديد" "بشكل قديم" "بسعادة" "بحزن"
        "بارتفاع" "بانخفاض" "بشكل صحيح" "بشكل خاطئ" "بشكل شاب" "بشكل مسن" "في الأمام" "في الخلف"
        "من الأعلى" "من الأسفل" "بعرض" "بضيق" "في المنتصف" "على الجانب" "بشكل قصير" "بشكل طويل"
        "بنجاح" "بفشل" "بتواضع" "بغرور" "بحرية" "بأسر"]
   :de ["schnell" "langsam" "gut" "heimlich" "öffentlich" "wie es sein sollte" "vorsichtig" "leichtfertig"
        "gut" "schlecht" "einfach" "schwierig" "lustig" "traurig" "tief" "flach" "sauber" "schmutzig"
        "heiß" "kalt" "weich" "hart" "neu" "alt" "glücklich" "traurig" "hoch" "tief" "richtig" "falsch"
        "jung" "alt" "vorne" "hinten" "oben" "unten" "breit" "eng" "mittig" "seitlich" "kurz" "lang"
        "erfolgreich" "gescheitert" "bescheiden" "eingebildet" "frei" "gefangen"]
   :en ["quickly" "slowly" "well" "secretly" "publicly" "properly" "carefully" "carelessly" "easily"
        "difficultly" "fun" "sadly" "deeply" "shallowly" "cleanly" "dirtily" "hotly" "coldly"
        "softly" "harshly" "newly" "oldly" "happily" "sadly" "highly" "lowly" "rightly" "wrongly"
        "youthfully" "elderly" "frontally" "rearwardly" "upwardly" "downwardly" "widely" "narrowly"
        "middlingly" "sideways" "shortly" "longly" "successfully" "unsuccessfully" "humbly" "arrogantly"
        "freely" "captively"]
   :es ["rápidamente" "lentamente" "bien" "secretamente" "públicamente" "como debería ser" "cuidadosamente"
        "descuidadamente" "fácilmente" "difícilmente" "divertido" "tristemente" "profundamente"
        "superficialmente" "limpiamente" "sucio" "caliente" "fríamente" "suavemente" "duro"
        "nuevamente" "viejo" "felizmente" "tristemente" "alto" "bajo" "correctamente" "incorrectamente"
        "joven" "viejo" "delanteramente" "hacia atrás" "hacia arriba" "hacia abajo" "ampliamente"
        "estrechamente" "en el medio" "lateralmente" "cortamente" "largamente" "exitosamente"
        "fallidamente" "humildemente" "arrogantemente" "libremente" "atrapado"]
   :fr ["rapidement" "lentement" "bien" "secrètement" "publiquement" "comme il se doit" " soigneusement"
        "négligemment" "facilement" "difficilement" "amusant" "tristement" "profondément"
        "superficiellement" "proprement" "sale" "chaudement" "froidement" "doucement" "durement"
        "nouvellement" "anciennement" "heureusement" "tristement" " hautement" "bas" "correctement"
        "incorrectement" "jeunesse" "vieillesse" "devant" "derrière" "en haut" "en bas"
        "largement" "étroitement" "au milieu" "latéralement" "court" "longtemps" "avec succès"
        "échec" "humble" "arrogant" "libre" "captif"]
   :tr ["hızlıca" "yavaşça" "iyi" "gizlice" "açıkça" "olması gerektiği gibi" "dikkatlice" "dikkatsizce"
        "kolayca" "zor" "eğlenceli" "üzgün" "derin" "sığ" "temiz" "kirli" "sıcak" "soğuk" "yumuşak"
        "sert" "yeni" "eski" "mutlu" "üzgün" "yüksek" "düşük" "doğru" "yanlış" "genç" "yaşlı" "ön"
        "arka" "yukarı" "aşağı" "geniş" "dar" "orta" "yan" "kısa" "uzun" "başarılı" "başarısız"
        "alçakgönüllü" "kibirli" "özgür" "esir"]})

(defn random-adverb
  "Generates a random adverb in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr.
   Defaults to :en if no language is specified."
  ([] (random-adverb :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         adverbs (get adverbs-data (keyword lang))]
     (if adverbs
       (rand-nth adverbs)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))
