(ns dataimitator.animal.cats)

(def cat-species
  {:ar ["السيامي" "الفارسي" "الراغدول" "البنغالي" "البيرمان" "القط الروسي الأزرق" "القط الشرقي" "الشيرازي" "القط الشيرازي طويل الشعر" "السافانا" "القط الشيرازي قصير الشعر" "القط البريطاني قصير الشعر" "الماين كون" "القط السيبيري" "القط البالي" "القط السيبيري طويل الشعر" "القط التايلندي" "القط البورمي" "القط التركي فان" "القط الحبشي"]
   :de ["Siamkatze" "Perserkatze" "Ragdoll" "Bengalkatze" "Birma" "Russisch Blau" "Orientalisch Kurzhaar" "Exotic Shorthair" "Langhaarkatze" "Savannah" "Britisch Kurzhaar" "Maine Coon" "Sibirische Katze" "Balinesenkatze" "Thai" "Burma" "Türkisch Van" "Abessinier" "Scottish Fold" "Ragamuffin"]
   :en ["Siamese" "Persian" "Ragdoll" "Bengal" "Birman" "Russian Blue" "Oriental" "Exotic Shorthair" "Longhair" "Savannah" "British Shorthair" "Maine Coon" "Siberian" "Balinese" "Thai" "Burmese" "Turkish Van" "Abyssinian" "Scottish Fold" "Ragamuffin"]
   :es ["Siamés" "Persa" "Ragdoll" "Bengalí" "Birmano" "Azul Ruso" "Oriental de Pelo Corto" "Exótico de Pelo Corto" "Pelo Largo" "Savannah" "Británico de Pelo Corto" "Maine Coon" "Siberiano" "Balinés" "Tailandés" "Burmés" "Van Turco" "Abisinio" "Fold Escocés" "Ragamuffin"]
   :fr ["Siamois" "Persan" "Ragdoll" "Bengal" "Birman" "Bleu Russe" "Oriental" "Exotic Shorthair" "Chat à poil long" "Savannah" "British Shorthair" "Maine Coon" "Sibérien" "Balinais" "Thaï" "Burmese" "Van Turc" "Abyssin" "Scottish Fold" "Ragamuffin"]
   :tr ["Siyam Kedisi" "İran Kedisi" "Ragdoll" "Bengal Kedisi" "Birman" "Rus Mavisi" "Oriental" "Egzotik Shorthair" "Uzun Tüylü" "Savannah" "British Shorthair" "Maine Coon" "Sibirya Kedisi" "Balinez" "Tayland Kedisi" "Burma Kedisi" "Van Kedisi" "Habeş Kedisi" "Scottish Fold" "Ragamuffin"]})

(defn random-cat
  "Generates a random cat species in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr
   Defaults to :en if no language is specified."
  ([] (random-cat :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         names (get cat-species (keyword lang))]
     (if names
       (rand-nth names)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))
