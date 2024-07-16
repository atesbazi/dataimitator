(ns dataimitator.color.core
  (:require [dataimitator.helper.core :refer [round-to-two-decimals]]))

(def color-names
  {:ar ["أحمر" "أزرق" "أخضر" "أصفر" "برتقالي" "أرجواني" "بنفسجي" "أبيض" "أسود" "رمادي" "بني" "زهري"
        "بني غامق" "أخضر فاتح" "زيتوني" "أصفر فاتح" "أزرق سماوي" "رمادي داكن" "أحمر فاتح" "برتقالي فاتح"
        "بنفسجي فاتح" "أصفر بني" "أزرق فاتح" "رمادي فاتح" "أخضر بحري" "برتقالي ساطع" "أحمر داكن"
        "أخضر داكن" "أزرق داكن" "بنفسجي داكن" "رمادي مائل للأخضر" "أصفر مائل للأخضر" "أحمر ساطع"
        "بني مائل للأصفر" "أزرق سماوي ساطع" "أخضر زيتوني" "أصفر زاهي" "أزرق سماوي داكن" "أحمر برتقالي"
        "أزرق بنفسجي" "أخضر سماوي" "أحمر زهري" "بني فاتح"]
   :de ["Rot" "Blau" "Grün" "Gelb" "Orange" "Lila" "Violett" "Weiß" "Schwarz" "Grau" "Braun" "Rosa"
        "Dunkelbraun" "Hellgrün" "Olivgrün" "Hellgelb" "Himmelblau" "Dunkelgrau" "Hellrot" "Hellorange"
        "Hellviolett" "Gelblich Braun" "Hellblau" "Hellgrau" "Meergrün" "Leuchtend Orange" "Dunkelrot"
        "Dunkelgrün" "Dunkelblau" "Dunkelviolett" "Grau-grünlich" "Gelb-grünlich" "Leuchtend Rot"
        "Braun-gelblich" "Himmelblau Leuchtend" "Olivgrün" "Lebhaftes Gelb" "Dunkelblau Himmelblau"
        "Orange Rot" "Blau Violett" "Meerblau" "Rotes Rosa" "Hellbraun"]
   :en ["Red" "Blue" "Green" "Yellow" "Orange" "Purple" "Violet" "White" "Black" "Gray" "Brown" "Pink"
        "Dark Brown" "Light Green" "Olive Green" "Light Yellow" "Sky Blue" "Dark Gray" "Light Red"
        "Light Orange" "Light Purple" "Yellowish Brown" "Light Blue" "Light Gray" "Sea Green"
        "Bright Orange" "Dark Red" "Dark Green" "Dark Blue" "Dark Purple" "Grayish Green"
        "Yellowish Green" "Bright Red" "Brownish Yellow" "Sky Blue Bright" "Olive Green" "Vivid Yellow"
        "Dark Blue Sky Blue" "Orange Red" "Blue Purple" "Sea Blue" "Reddish Pink" "Light Brown"]
   :es ["Rojo" "Azul" "Verde" "Amarillo" "Naranja" "Morado" "Violeta" "Blanco" "Negro" "Gris" "Marrón" "Rosa"
        "Marrón Oscuro" "Verde Claro" "Verde Oliva" "Amarillo Claro" "Azul Cielo" "Gris Oscuro" "Rojo Claro"
        "Naranja Claro" "Morado Claro" "Marrón Amarillento" "Azul Claro" "Gris Claro" "Verde Mar"
        "Naranja Brillante" "Rojo Oscuro" "Verde Oscuro" "Azul Oscuro" "Morado Oscuro" "Verdoso Grisáceo"
        "Verdoso Amarillento" "Rojo Brillante" "Marrón Amarillento" "Azul Cielo Brillante"
        "Verde Oliva" "Amarillo Vivo" "Azul Oscuro Azul Cielo" "Rojo Naranja" "Azul Morado" "Azul Mar"
        "Rosa Rojizo" "Marrón Claro"]
   :fr ["Rouge" "Bleu" "Vert" "Jaune" "Orange" "Violet" "Violet" "Blanc" "Noir" "Gris" "Marron" "Rose"
        "Marron Foncé" "Vert Clair" "Vert Olive" "Jaune Clair" "Bleu Ciel" "Gris Foncé" "Rouge Clair"
        "Orange Clair" "Violet Clair" "Brun jaunâtre" "Bleu Clair" "Gris Clair" "Vert Mer"
        "Orange Vif" "Rouge Foncé" "Vert Foncé" "Bleu Foncé" "Violet Foncé" "Gris Verdâtre"
        "Verdâtre Jaune" "Rouge Vif" "Brun jaunâtre" "Bleu Ciel Vif" "Vert Olive" "Jaune Vif"
        "Bleu Ciel Bleu Foncé" "Orange Rouge" "Bleu Violet" "Bleu de mer" "Rose Rougeâtre" "Brun Clair"]
   :tr ["Kırmızı" "Mavi" "Yeşil" "Sarı" "Turuncu" "Mor" "Menekşe" "Beyaz" "Siyah" "Gri" "Kahverengi" "Pembe"
        "Koyu Kahverengi" "Açık Yeşil" "Zeytin Yeşili" "Açık Sarı" "Gökyüzü Mavisi" "Koyu Gri" "Açık Kırmızı"
        "Açık Turuncu" "Açık Mor" "Sarımsı Kahverengi" "Açık Mavi" "Açık Gri" "Deniz Yeşili"
        "Parlak Turuncu" "Koyu Kırmızı" "Koyu Yeşil" "Koyu Mavi" "Koyu Mor" "Griye çalan Yeşil"
        "Yeşile çalan Sarı" "Parlak Kırmızı" "Kahverengiye çalan Sarı" "Gökyüzü Mavi Parlak"
        "Zeytin Yeşili" "Canlı Sarı" "Koyu Mavi Gökyüzü" "Turuncu Kırmızı" "Mavi Mor" "Deniz Mavisi"
        "Kırmızımsı Pembe" "Açık Kahverengi"]})

(defn random-color
  "Generates a random color name in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr
   Defaults to :en if no language is specified."
  ([] (random-color :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         names (get color-names (keyword lang))]
     (if names
       (rand-nth names)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))

(defn random-hex-color []
  (let [random-component (fn [] (rand-int 256))]
    (apply str
           (concat ["#"]
                   (map #(format "%02X" %)
                        (repeatedly 3 random-component))))))

(defn random-rgb-color []
  (let [random-component (fn [] (rand-int 256))]
    (vector (random-component) (random-component) (random-component))))

(defn random-hsl-color []
  (let [random-hue (round-to-two-decimals (rand))
        random-saturation (round-to-two-decimals (rand))
        random-lightness (round-to-two-decimals (rand))]
    [(mod random-hue 1.0)
     (min 1.0 (max 0.0 random-saturation))
     (min 1.0 (max 0.0 random-lightness))]))

(defn harmonious-color [base-color factor]
  (let [base-r (Integer/parseInt (subs base-color 1 3) 16)
        base-g (Integer/parseInt (subs base-color 3 5) 16)
        base-b (Integer/parseInt (subs base-color 5 7) 16)
        adjust (fn [c] (mod (+ c (* factor 16)) 256))]
    (format "#%02X%02X%02X"
            (adjust base-r)
            (adjust base-g)
            (adjust base-b))))

(defn random-harmonious-color-palette []
  (let [base-color (random-hex-color)
        factors [-2 -1 0 1 2]]
    (map #(harmonious-color base-color %) factors)))
