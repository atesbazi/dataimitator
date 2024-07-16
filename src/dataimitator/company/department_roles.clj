(ns dataimitator.company.department_roles)

(def department-roles
  {:ar ["مدير" "موظف مبيعات" "مدير تسويق" "مدير الموارد البشرية" "مهندس"
        "مطور برامج" "فني دعم فني" "محاسب" "مسؤول جودة" "مدير مشروع"
        "مدير العلاقات العامة" "مصمم" "مدير لوجستيات" "مدير عمليات" "مدير المشتريات"
        "مدير التخطيط الاستراتيجي" "مدير الأمن والسلامة" "مدرب" "مهندس ابتكاري"]
   :de ["Manager" "Vertriebsmitarbeiter" "Marketingmanager" "Personalleiter" "Ingenieur"
        "Softwareentwickler" "Technischer Support" "Buchhalter" "Qualitätsbeauftragter" "Projektmanager"
        "PR-Manager" "Designer" "Logistikmanager" "Betriebsleiter" "Einkaufsleiter"
        "Strategieplaner" "Sicherheitsmanager" "Trainer" "Innovationsingenieur"]
   :en ["Manager" "Sales Executive" "Marketing Manager" "HR Manager" "Engineer"
        "Software Developer" "Technical Support" "Accountant" "Quality Assurance" "Project Manager"
        "PR Manager" "Designer" "Logistics Manager" "Operations Manager" "Purchasing Manager"
        "Strategic Planner" "Security Manager" "Trainer" "Innovation Engineer"]
   :es ["Gerente" "Ejecutivo de Ventas" "Gerente de Marketing" "Gerente de Recursos Humanos" "Ingeniero"
        "Desarrollador de Software" "Soporte Técnico" "Contador" "Responsable de Calidad" "Gerente de Proyecto"
        "Gerente de Relaciones Públicas" "Diseñador" "Gerente de Logística" "Gerente de Operaciones" "Gerente de Compras"
        "Planificador Estratégico" "Gerente de Seguridad" "Entrenador" "Ingeniero de Innovación"]
   :fr ["Directeur" "Commercial" "Responsable Marketing" "Directeur des Ressources Humaines" "Ingénieur"
        "Développeur Logiciel" "Support Technique" "Comptable" "Responsable Qualité" "Chef de Projet"
        "Responsable Relations Publiques" "Designer" "Responsable Logistique" "Directeur d'Opérations" "Responsable des Achats"
        "Planificateur Stratégique" "Responsable de la Sécurité" "Formateur" "Ingénieur Innovation"]
   :tr ["Müdür" "Satış Uzmanı" "Pazarlama Müdürü" "İK Müdürü" "Mühendis"
        "Yazılım Geliştirici" "Teknik Destek" "Muhasebeci" "Kalite Sorumlusu" "Proje Yöneticisi"
        "Halkla İlişkiler Müdürü" "Tasarımcı" "Lojistik Müdürü" "Operasyon Müdürü" "Satın Alma Müdürü"
        "Strateji Planlayıcı" "Güvenlik Müdürü" "Eğitmen" "İnovasyon Mühendisi"]})

(defn random-department-role
  "Generates a random department role in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr.
   Defaults to :en if no language is specified."
  ([] (random-department-role :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         roles (get department-roles (keyword lang))]
     (if roles
       (rand-nth roles)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))
