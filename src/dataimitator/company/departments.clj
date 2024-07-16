(ns dataimitator.company.departments)

(def department-names
  {:ar ["الإدارة" "المبيعات" "التسويق" "الموارد البشرية" "التكنولوجيا"
        "التطوير" "الإنتاج" "المالية" "الدعم الفني" "الجودة"
        "البحث والتطوير" "العلاقات العامة" "التصميم" "اللوجستيات" "العمليات"
        "المشتريات" "التخطيط الاستراتيجي" "الأمن والسلامة" "التعليم والتدريب" "الابتكار"]
   :de ["Management" "Vertrieb" "Marketing" "Personalwesen" "Technologie"
        "Entwicklung" "Produktion" "Finanzen" "Technischer Support" "Qualität"
        "Forschung und Entwicklung" "Öffentlichkeitsarbeit" "Design" "Logistik" "Betrieb"
        "Einkauf" "Strategische Planung" "Sicherheit" "Bildung und Training" "Innovation"]
   :en ["Management" "Sales" "Marketing" "Human Resources" "Technology"
        "Development" "Production" "Finance" "Technical Support" "Quality"
        "Research and Development" "Public Relations" "Design" "Logistics" "Operations"
        "Purchasing" "Strategic Planning" "Security" "Education and Training" "Innovation"]
   :es ["Dirección" "Ventas" "Marketing" "Recursos Humanos" "Tecnología"
        "Desarrollo" "Producción" "Finanzas" "Soporte Técnico" "Calidad"
        "Investigación y Desarrollo" "Relaciones Públicas" "Diseño" "Logística" "Operaciones"
        "Compras" "Planificación Estratégica" "Seguridad" "Educación y Formación" "Innovación"]
   :fr ["Direction" "Ventes" "Marketing" "Ressources Humaines" "Technologie"
        "Développement" "Production" "Finance" "Support Technique" "Qualité"
        "Recherche et Développement" "Relations Publiques" "Design" "Logistique" "Opérations"
        "Achats" "Planification Stratégique" "Sécurité" "Éducation et Formation" "Innovation"]
   :tr ["Yönetim" "Satış" "Pazarlama" "İnsan Kaynakları" "Teknoloji"
        "Geliştirme" "Üretim" "Finans" "Teknik Destek" "Kalite"
        "Araştırma ve Geliştirme" "Halkla İlişkiler" "Tasarım" "Lojistik" "Operasyonlar"
        "Satın Alma" "Stratejik Planlama" "Güvenlik" "Eğitim ve Eğitim" "İnovasyon"]})

(defn random-department-name
  "Generates a random department name in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr.
   Defaults to :en if no language is specified."
  ([] (random-department-name :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         names (get department-names (keyword lang))]
     (if names
       (rand-nth names)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))
