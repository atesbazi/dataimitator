(ns dataimitator.word.verb.core)

(def verbs-data
  {:ar ["يعمل" "يدرس" "يكتب" "يسافر" "يتحدث" "يأكل" "يشرب" "يفهم" "يحب" "يفوز"
        "يقرأ" "ينام" "يجلس" "يذهب" "يأتي" "يصل" "يستمع" "يشاهد" "يستخدم" "يبدأ"
        "ينهي" "يكتشف" "يعرف" "يصمم" "يستعد" "يحاول" "يساعد" "يعلم" "يعمل"
        "يحضر" "يستخدم" "يزرع" "يمشي" "يجري" "يقف" "يفوز" "يخسر" "يحلم" "يرقص"
        "يسافر" "يتسوق" "يتعلم" "يعود" "يبتسم" "يغني" "يحب" "يكتب" "يتكلم" "يضحك"]
   :de ["arbeiten" "studieren" "schreiben" "reisen" "sprechen" "essen" "trinken" "verstehen" "lieben" "gewinnen"
        "lesen" "schlafen" "sitzen" "gehen" "kommen" "ankommen" "hören" "sehen" "benutzen" "beginnen"
        "enden" "entdecken" "wissen" "entwerfen" "vorbereiten" "versuchen" "helfen" "lernen" "arbeiten"
        "teilnehmen" "verwenden" "pflanzen" "gehen" "laufen" "stehen" "gewinnen" "verlieren" "träumen"
        "tanzen" "reisen" "einkaufen" "lernen" "zurückkehren" "lächeln" "singen" "lieben" "schreiben"
        "sprechen" "lachen"]
   :en ["work" "study" "write" "travel" "speak" "eat" "drink" "understand" "love" "win"
        "read" "sleep" "sit" "go" "come" "arrive" "listen" "watch" "use" "begin"
        "finish" "discover" "know" "design" "prepare" "try" "help" "learn" "work"
        "attend" "use" "plant" "walk" "run" "stand" "win" "lose" "dream" "dance"
        "travel" "shop" "learn" "return" "smile" "sing" "love" "write" "talk" "laugh"]
   :es ["trabajar" "estudiar" "escribir" "viajar" "hablar" "comer" "beber" "entender" "amar" "ganar"
        "leer" "dormir" "sentarse" "ir" "venir" "llegar" "escuchar" "mirar" "usar" "empezar"
        "terminar" "descubrir" "saber" "diseñar" "preparar" "intentar" "ayudar" "aprender" "trabajar"
        "asistir" "utilizar" "plantar" "caminar" "correr" "estar de pie" "ganar" "perder" "soñar"
        "bailar" "viajar" "comprar" "aprender" "regresar" "sonreír" "cantar" "amar" "escribir" "hablar"
        "reír"]
   :fr ["travailler" "étudier" "écrire" "voyager" "parler" "manger" "boire" "comprendre" "aimer" "gagner"
        "lire" "dormir" "s'asseoir" "aller" "venir" "arriver" "écouter" "regarder" "utiliser" "commencer"
        "finir" "découvrir" "savoir" "concevoir" "préparer" "essayer" "aider" "apprendre" "travailler"
        "assister" "utiliser" "planter" "marcher" "courir" "être debout" "gagner" "perdre" "rêver"
        "danser" "voyager" "faire les courses" "apprendre" "retourner" "sourire" "chanter" "aimer" "écrire"
        "parler" "rire"]
   :tr ["çalışmak" "öğrenmek" "yazmak" "seyahat etmek" "konuşmak" "yemek" "içmek" "anlamak" "sevmek" "kazanmak"
        "okumak" "uyumak" "oturmak" "gitmek" "gelmek" "varmak" "dinlemek" "izlemek" "kullanmak" "başlamak"
        "bitirmek" "keşfetmek" "bilmek" "tasarlamak" "hazırlamak" "denemek" "yardım etmek" "öğrenmek" "çalışmak"
        "katılmak" "kullanmak" "dikmek" "yürümek" "koşmak" "ayakta durmak" "kazanmak" "kaybetmek" "rüya görmek"
        "dans etmek" "seyahat etmek" "alışveriş yapmak" "öğrenmek" "dönmek" "gülümsemek" "şarkı söylemek"
        "sevmek" "yazmak" "konuşmak" "gülmek"]})

(defn random-verb
  "Generates a random verb in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr.
   Defaults to :en if no language is specified."
  ([] (random-verb :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         verbs (get verbs-data (keyword lang))]
     (if verbs
       (rand-nth verbs)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))
