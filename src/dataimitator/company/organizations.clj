(ns dataimitator.company.organizations)

(def organization-names
  {:ar ["مؤسسة الأفق" "شركة النجاح" "مجموعة العلم" "شركة الإبداع" "مؤسسة الفارابي"
        "مجموعة الأمل" "شركة المستقبل" "مؤسسة الأفق المشرق" "شركة البناء" "مجموعة التقدم"
        "شركة التعليم" "مؤسسة الابتكار" "شركة التكنولوجيا" "مجموعة الإنتاج" "شركة النمو"
        "مؤسسة السلام" "شركة الحياة" "مجموعة القوة" "شركة الجمال" "مؤسسة الشمس"
        "شركة الحرية" "مجموعة العمل" "شركة الصحة" "مؤسسة القلب" "شركة الحرفة" "مجموعة السعادة"
        "شركة العدل" "مؤسسة القدرة" "شركة الإبداع" "مجموعة الأفكار" "شركة الواقع"
        "مؤسسة النهضة" "شركة الجديد" "مجموعة الثقافة" "شركة السلامة" "مؤسسة الأمان"
        "شركة العلم" "مجموعة الازدهار" "شركة الفن" "مؤسسة الإعلام" "شركة العملاء"
        "مجموعة التطوير" "شركة الابتكار" "مؤسسة السعادة" "شركة النجاح"]
   :de ["Himmel GmbH" "Erfolg AG" "Wissenschaftsgruppe" "Kreativität GmbH" "Fahrabi-Stiftung"
        "Hoffnungsgruppe" "Zukunft AG" "Bright Horizon Foundation" "Bauunternehmen" "Fortschrittsgruppe"
        "Bildungsunternehmen" "Innovationsstiftung" "Technologieunternehmen" "Produktionsgruppe" "Wachstumsunternehmen"
        "Friedensstiftung" "Lebensunternehmen" "Stärkegruppe" "Schönheit GmbH" "Sonnenstiftung"
        "Freiheitsunternehmen" "Arbeitsgruppe" "Gesundheitsunternehmen" "Herzstiftung" "Handwerksunternehmen" "Glücklichgruppe"
        "Gerechtigkeitsunternehmen" "Fähigkeitsstiftung" "Kreativunternehmen" "Ideengruppe" "Realitätsunternehmen"
        "Renaissance-Stiftung" "Neue GmbH" "Kulturgruppe" "Sicherheitsunternehmen" "Sicherheitsstiftung"
        "Wissensunternehmen" "Flourishing Group" "Kunst GmbH" "Medienstiftung" "Kundendienstunternehmen"
        "Entwicklungsgruppe" "Innovationsunternehmen" "Glücklichstiftung" "Erfolgsunternehmen"]
   :en ["Horizon Foundation" "Success Company" "Science Group" "Creativity Inc." "Fahrabi Foundation"
        "Hope Group" "Future Ltd." "Bright Horizon Foundation" "Construction Company" "Progress Group"
        "Education Company" "Innovation Foundation" "Technology Inc." "Production Group" "Growth Company"
        "Peace Foundation" "Life Corporation" "Power Group" "Beauty Enterprises" "Sun Foundation"
        "Freedom Group" "Work Corporation" "Health Company" "Heart Foundation" "Craftsmanship Ltd." "Happiness Group"
        "Justice Company" "Ability Foundation" "Creative Enterprises" "Ideas Group" "Reality Corporation"
        "Renaissance Foundation" "New Ventures Ltd." "Culture Group" "Safety Company" "Safety Foundation"
        "Knowledge Inc." "Prosperity Group" "Art Ltd." "Media Foundation" "Customer Services Ltd."
        "Development Group" "Innovation Enterprises" "Happiness Foundation" "Success Enterprises"]
   :es ["Fundación Horizonte" "Compañía de Éxito" "Grupo de Ciencia" "Creatividad S.A." "Fundación Fahrabi"
        "Grupo de Esperanza" "Futuro S.L." "Fundación Horizonte Brillante" "Empresa de Construcción" "Grupo de Progreso"
        "Empresa de Educación" "Fundación de Innovación" "Tecnología S.A." "Grupo de Producción" "Empresa de Crecimiento"
        "Fundación de Paz" "Corporación de Vida" "Grupo de Poder" "Empresas de Belleza" "Fundación del Sol"
        "Grupo de Libertad" "Corporación de Trabajo" "Empresa de Salud" "Fundación del Corazón" "Ltd. de Artesanía" "Grupo de Felicidad"
        "Empresa de Justicia" "Fundación de Habilidad" "Empresas Creativas" "Grupo de Ideas" "Corporación de Realidad"
        "Fundación del Renacimiento" "Ltd. de Nuevas Aventuras" "Grupo de Cultura" "Empresa de Seguridad" "Fundación de Seguridad"
        "Inc. de Conocimiento" "Grupo de Prosperidad" "Ltd. de Arte" "Fundación de Medios" "Ltd. de Servicios al Cliente"
        "Grupo de Desarrollo" "Empresas de Innovación" "Fundación de Felicidad" "Empresas de Éxito"]
   :fr ["Fondation Horizon" "Société de Succès" "Groupe de Science" "Créativité S.A." "Fondation Fahrabi"
        "Groupe d'Espoir" "Avenir S.A." "Fondation Horizon Brillant" "Entreprise de Construction" "Groupe de Progrès"
        "Entreprise d'Éducation" "Fondation d'Innovation" "Technologie S.A." "Groupe de Production" "Entreprise de Croissance"
        "Fondation de Paix" "Corporation de Vie" "Groupe de Puissance" "Entreprises de Beauté" "Fondation du Soleil"
        "Groupe de Liberté" "Corporation de Travail" "Entreprise de Santé" "Fondation du Cœur" "Ltd. d'Artisanat" "Groupe de Bonheur"
        "Entreprise de Justice" "Fondation d'Habilité" "Entreprises Créatives" "Groupe d'Idees" "Corporation de Réalité"
        "Fondation de Renaissance" "Ltd. de Nouvelles Aventures" "Groupe de Culture" "Entreprise de Sécurité" "Fondation de Sécurité"
        "Inc. de Connaissance" "Groupe de Prospérité" "Ltd. d'Art" "Fondation de Médias" "Ltd. de Services à la Clientèle"
        "Groupe de Développement" "Entreprises d'Innovation" "Fondation de Bonheur" "Entreprises de Succès"]
   :tr ["Horizon Vakfı" "Başarı Şirketi" "Bilim Grubu" "Yaratıcılık A.Ş." "Fahrabi Vakfı"
        "Umut Grubu" "Gelecek Ltd." "Parlak Horizon Vakfı" "İnşaat Şirketi" "İlerleme Grubu"
        "Eğitim Şirketi" "İnovasyon Vakfı" "Teknoloji A.Ş." "Üretim Grubu" "Büyüme Şirketi"
        "Barış Vakfı" "Hayat Kurumu" "Güç Grubu" "Güzellik Kuruluşları" "Güneş Vakfı"
        "Özgürlük Grubu" "Çalışma Kuruluşu" "Sağlık Şirketi" "Kalp Vakfı" "Ustalık Ltd." "Mutluluk Grubu"
        "Adalet Şirketi" "Yetenek Vakfı" "Yaratıcı Kuruluşlar" "Fikirler Grubu" "Gerçeklik Kurumu"
        "Rönesans Vakfı" "Yeni Girişimler Ltd." "Kültür Grubu" "Güvenlik Şirketi" "Güvenlik Vakfı"
        "Bilgi A.Ş." "Refah Grubu" "Sanat Ltd." "Medya Vakfı" "Müşteri Hizmetleri Ltd."
        "Gelişim Grubu" "İnovasyon Kuruluşları" "Mutluluk Vakfı" "Başarı Kuruluşları"]})

(defn random-organization-name
  "Generates a random organization name in the specified language.
    Supported languages: :ar, :de, :en, :es, :fr, :tr
   Defaults to :en if no language is specified."
  ([] (random-organization-name :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         names (get organization-names (keyword lang))]
     (if names
       (rand-nth names)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))
