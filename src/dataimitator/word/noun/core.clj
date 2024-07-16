(ns dataimitator.word.noun.core)

(def nouns-data
  {:ar ["منزل" "سيارة" "كتاب" "مكتب" "قلم" "هاتف" "شجرة" "بحر" "جبل" "سماء"
        "طائر" "سمكة" "كلب" "قطة" "زهرة" "نجمة" "قمر" "شمس" "نهر" "بحيرة"
        "سيدة" "رجل" "طفل" "شخص" "مجموعة" "فريق" "مدينة" "قرية" "دولة" "قارة"
        "جزيرة" "مطار" "ميناء" "مستشفى" "مدرسة" "جامعة" "مطعم" "مقهى" "متجر" "سوق"
        "حديقة" "متنزه" "مسجد" "كنيسة" "معبد" "مكتبة" "متحف" "مسرح" "استاد" "قصر"]
   :de ["Haus" "Auto" "Buch" "Büro" "Stift" "Telefon" "Baum" "Meer" "Berg" "Himmel"
        "Vogel" "Fisch" "Hund" "Katze" "Blume" "Stern" "Mond" "Sonne" "Fluss" "See"
        "Dame" "Mann" "Kind" "Person" "Gruppe" "Team" "Stadt" "Dorf" "Land" "Kontinent"
        "Insel" "Flughafen" "Hafen" "Krankenhaus" "Schule" "Universität" "Restaurant" "Café" "Geschäft" "Markt"
        "Park" "Vergnügungspark" "Moschee" "Kirche" "Tempel" "Bibliothek" "Museum" "Theater" "Stadion" "Palast"]
   :en ["house" "car" "book" "office" "pen" "phone" "tree" "sea" "mountain" "sky"
        "bird" "fish" "dog" "cat" "flower" "star" "moon" "sun" "river" "lake"
        "lady" "man" "child" "person" "group" "team" "city" "village" "country" "continent"
        "island" "airport" "port" "hospital" "school" "university" "restaurant" "cafe" "shop" "market"
        "park" "amusement park" "mosque" "church" "temple" "library" "museum" "theater" "stadium" "palace"]
   :es ["casa" "coche" "libro" "oficina" "bolígrafo" "teléfono" "árbol" "mar" "montaña" "cielo"
        "pájaro" "pez" "perro" "gato" "flor" "estrella" "luna" "sol" "río" "lago"
        "señora" "hombre" "niño" "persona" "grupo" "equipo" "ciudad" "pueblo" "país" "continente"
        "isla" "aeropuerto" "puerto" "hospital" "escuela" "universidad" "restaurante" "cafetería" "tienda" "mercado"
        "parque" "parque de atracciones" "mezquita" "iglesia" "templo" "biblioteca" "museo" "teatro" "estadio" "palacio"]
   :fr ["maison" "voiture" "livre" "bureau" "stylo" "téléphone" "arbre" "mer" "montagne" "ciel"
        "oiseau" "poisson" "chien" "chat" "fleur" "étoile" "lune" "soleil" "rivière" "lac"
        "dame" "homme" "enfant" "personne" "groupe" "équipe" "ville" "village" "pays" "continent"
        "île" "aéroport" "port" "hôpital" "école" "université" "restaurant" "café" "magasin" "marché"
        "parc" "parc d'attractions" "mosquée" "église" "temple" "bibliothèque" "musée" "théâtre" "stade" "palais"]
   :tr ["ev" "araba" "kitap" "ofis" "kalem" "telefon" "ağaç" "deniz" "dağ" "gökyüzü"
        "kuş" "balık" "köpek" "kedi" "çiçek" "yıldız" "ay" "güneş" "nehir" "göl"
        "bayan" "adam" "çocuk" "kişi" "grup" "takım" "şehir" "köy" "ülke" "kıta"
        "ada" "havalimanı" "liman" "hastane" "okul" "üniversite" "restoran" "kafe" "mağaza" "pazar"
        "park" "eğlence parkı" "camii" "kilise" "tapınak" "kütüphane" "müze" "tiyatro" "stadyum" "saray"]})

(defn random-noun
  "Generates a random noun in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr.
   Defaults to :en if no language is specified."
  ([] (random-noun :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         nouns (get nouns-data (keyword lang))]
     (if nouns
       (rand-nth nouns)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))
