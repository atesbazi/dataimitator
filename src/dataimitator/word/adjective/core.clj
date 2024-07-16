(ns dataimitator.word.adjective.core)

(def adjectives-data
  {:ar ["جميل" "ذكي" "سريع" "متأخر" "صغير" "كبير" "جيد" "سيء" "سهل" "صعب" "ممتع"
        "محزن" "عميق" "ضحل" "نقي" "قذر" "ساخن" "بارد" "ناعم" "خشن" "جديد" "قديم"
        "سعيد" "حزين" "عالي" "منخفض" "صحيح" "خطأ" "شاب" "مسن" "أمامي" "خلفي"
        "أعلى" "أسفل" "عريض" "ضيق" "وسط" "جانبي" "قصير" "طويل" "ناجح" "فاشل"
        "صاحب" "متواضع" "مغرور" "حر" "مأسور"]
   :de ["schön" "intelligent" "schnell" "spät" "klein" "groß" "gut" "schlecht" "einfach"
        "schwierig" "spaßig" "traurig" "tief" "flach" "rein" "schmutzig" "heiß"
        "kalt" "weich" "hart" "neu" "alt" "glücklich" "traurig" "hoch" "niedrig"
        "richtig" "falsch" "jung" "alt" "vorder" "hinten" "oben" "unten" "breit"
        "eng" "mittler" "seitlich" "kurz" "lang" "erfolgreich" "gescheitert" "bescheiden"
        "eingebildet" "frei" "gefangen"]
   :en ["beautiful" "intelligent" "fast" "late" "small" "large" "good" "bad" "easy"
        "difficult" "fun" "sad" "deep" "shallow" "clean" "dirty" "hot" "cold"
        "soft" "hard" "new" "old" "happy" "sad" "high" "low" "true" "false"
        "young" "old" "front" "back" "top" "bottom" "wide" "narrow" "middle"
        "side" "short" "long" "successful" "failed" "humble" "arrogant" "free"
        "captive"]
   :es ["hermoso" "inteligente" "rápido" "tarde" "pequeño" "grande" "bueno" "malo" "fácil"
        "difícil" "divertido" "triste" "profundo" "superficial" "limpio" "sucio" "caliente"
        "frío" "suave" "duro" "nuevo" "viejo" "feliz" "triste" "alto" "bajo" "cierto"
        "falso" "joven" "viejo" "delantero" "trasero" "arriba" "abajo" "ancho" "estrecho"
        "medio" "lateral" "corto" "largo" "exitoso" "fallido" "humilde" "arrogante" "libre"
        "cautivo"]
   :fr ["beau" "intelligent" "rapide" "tard" "petit" "grand" "bon" "mauvais" "facile"
        "difficile" "amusant" "triste" "profond" "superficiel" "propre" "sale" "chaud"
        "froid" "doux" "dur" "nouveau" "vieux" "heureux" "triste" "haut" "bas" "vrai"
        "faux" "jeune" "vieux" "avant" "arrière" "dessus" "dessous" "large" "étroit"
        "milieu" "latéral" "court" "long" "réussi" "échoué" "modeste" "arrogant" "libre"
        "captif"]
   :tr ["güzel" "zeki" "hızlı" "geç" "küçük" "büyük" "iyi" "kötü" "kolay" "zor" "eğlenceli"
        "üzgün" "derin" "sığ" "temiz" "kirli" "sıcak" "soğuk" "yumuşak" "sert" "yeni"
        "eski" "mutlu" "üzgün" "yüksek" "düşük" "doğru" "yanlış" "genç" "yaşlı" "ön"
        "arka" "üst" "alt" "geniş" "dar" "orta" "yan" "kısa" "uzun" "başarılı" "başarısız"
        "alçakgönüllü" "kibirli" "özgür" "esir"]})

(defn random-adjective
  "Generates a random adjective in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr.
   Defaults to :en if no language is specified."
  ([] (random-adjective :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         adjectives (get adjectives-data (keyword lang))]
     (if adjectives
       (rand-nth adjectives)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))
