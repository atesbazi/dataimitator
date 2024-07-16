(ns dataimitator.animal.birds)

(def bird-species
  {:ar ["الحبارى" "النسر الأبيض الأمريكي" "بومة الألوان" "الجاسوس الأزرق" "الكناري" "الكاردينال" "الغراب" "القرقفاء"
        "الحمامة" "البطة" "الصقر" "الفلامنغو" "الحسون" "الإوز" "الصقر" "البلشون" "طائر الطنان" "الرفراف" "الهدهد" "طائر الطائر"
        "الببغاء" "الطاووس" "البجعة" "البومة" "الببغاء" "الطاووس" "البجعة" "البطريق" "الحمامة" "الغراب" "الزرزور" "النورس"
        "الدوري" "البجع" "التوكان" "الديك الرومي" "النسر النسر" "الذيول الخشبية"]
   :de ["Albatros" "Weißkopfseeadler" "Schleiereule" "Blauhäher" "Kanarienvogel" "Kardinal" "Krähe" "Kuckuck"
        "Taube" "Ente" "Falke" "Flamingo" "Stieglitz" "Gans" "Habicht" "Reiher" "Kolibri" "Eisvogel" "Drachen"
        "Elster" "Nachtigall" "Fischadler" "Strauß" "Eule" "Papagei" "Pfau" "Pelikan" "Pinguin" "Taube" "Rabe"
        "Rotkehlchen" "Möwe" "Sperling" "Schwan" "Tukan" "Truthahn" "Geier" "Specht" "Zaunkönig"]
   :en ["Albatross" "Bald Eagle" "Barn Owl" "Blue Jay" "Canary" "Cardinal" "Crow" "Cuckoo" "Dove" "Duck"
        "Falcon" "Flamingo" "Goldfinch" "Goose" "Hawk" "Heron" "Hummingbird" "Kingfisher" "Kite" "Magpie"
        "Nightingale" "Osprey" "Ostrich" "Owl" "Parrot" "Peacock" "Pelican" "Penguin" "Pigeon" "Raven"
        "Robin" "Seagull" "Sparrow" "Swan" "Toucan" "Turkey" "Vulture" "Woodpecker" "Wren"]
   :es ["Albatros" "Águila Calva" "Lechuza Común" "Arrendajo Azul" "Canario" "Cardenal" "Cuervo" "Cuco" "Paloma"
        "Pato" "Halcón" "Flamenco" "Jilguero" "Ganso" "Halcón" "Garza" "Colibrí" "Martín Pescador" "Milano" "Urraca"
        "Ruiseñor" "Águila Pescadora" "Avestruz" "Búho" "Loro" "Pavo Real" "Pelícano" "Pingüino" "Paloma" "Cuervo"
        "Petirrojo" "Gaviota" "Gorrión" "Cisne" "Tucán" "Pavo" "Buitre" "Pájaro Carpintero" "Chochín"]
   :fr ["Albatros" "Pygargue à Tête Blanche" "Chouette Effraie" "Geai Bleu" "Canari" "Cardinal" "Corbeau" "Coucou"
        "Colombe" "Canard" "Faucon" "Flamant Rose" "Chardonneret" "Oie" "Épervier" "Héron" "Colibri" "Martin-Pêcheur"
        "Milan" "Pie" "Rossignol" "Balbuzard Pêcheur" "Autruche" "Hibou" "Perroquet" "Paon" "Pélican" "Penguin"
        "Pigeon" "Corbeau" "Rougegorge" "Goéland" "Moineau" "Cygne" "Toucan" "Dinde" "Vautour" "Pic" "Troglodyte"]
   :tr ["Albatros" "Akdoğan" "Baykuş" "Mavi Ardıç Kuşu" "Kanarya" "Kardinal Kuşu" "Karga" "Kukumav" "Kumru"
        "Ördek" "Doğan" "Flamingo" "Saka Kuşu" "Kaz" "Atmaca" "Balıkçıl" "Kolibri" "Yalıçapkını" "Uçurtma"
        "Saksağan" "Bülbül" "Balık Kartalı" "Deve Kuşu" "Baykuş" "Papağan" "Tavus Kuşu" "Pelikan" "Penguen"
        "Güvercin" "Kuzgun" "Sığırcık" "Martı" "Serçe" "Kuğu" "Tukan" "Hindi" "Akbaba" "Ağaçkakan" "Civciv"]})

(defn random-bird
  "Generates a random bird species in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr
   Defaults to :en if no language is specified."
  ([] (random-bird :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         names (get bird-species (keyword lang))]
     (if names
       (rand-nth names)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))