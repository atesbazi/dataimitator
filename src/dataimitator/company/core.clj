(ns dataimitator.company.core)

(def company-names
  {:ar ["شركة التقنية العالمية" "المؤسسة التجارية الكبرى" "الشركة الوطنية للتصنيع" "شركة خدمات الأعمال" "المجموعة العربية للاستثمارات"]
   :de ["TechGlobal GmbH" "Handelsgesellschaft AG" "Nationale Fertigung GmbH" "Business Services GmbH" "Deutsche Investitionsgruppe"]
   :en ["TechGlobal Inc." "BigTrade Corp." "National Manufacturing Co." "Business Services Ltd." "Global Investments Group"]
   :es ["TechGlobal S.A." "GranComercio S.L." "Fábrica Nacional S.A." "Servicios Empresariales S.L." "Grupo de Inversiones Globales"]
   :fr ["TechGlobal SARL" "GrandeCommerce SA" "Manufacture Nationale SARL" "Services aux Entreprises SARL" "Groupe d'Investissements Mondiaux"]
   :tr ["TechGlobal A.Ş." "BüyükTicaret Ltd. Şti." "Milli Üretim A.Ş." "İş Hizmetleri A.Ş." "Küresel Yatırım Grubu"]})

(defn random-company-name
  "Generates a random company name in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr.
   Defaults to :en if no language is specified."
  ([] (random-company-name :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         names (get company-names (keyword lang))]
     (if names
       (rand-nth names)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))
