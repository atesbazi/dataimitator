(ns dataimitator.shopping.categories)

(def shopping-categories
  {:ar ["أجهزة الكمبيوتر واللابتوبات" "الهواتف والأجهزة اللوحية" "الإلكترونيات الاستهلاكية"
        "الأزياء والملابس" "الصحة والجمال" "المنزل والمطبخ" "الرياضة واللياقة البدنية"
        "الكتب والأدب" "الألعاب والألعاب التعليمية" "السيارات والدراجات" "الأطفال والرضع"
        "الحيوانات الأليفة والحيوانات" "المجوهرات والساعات" "المعدات الصناعية" "الموسيقى والأفلام"
        "الأثاث والديكور" "الهدايا والمناسبات" "الطعام والمشروبات" "الأدوات والمعدات اليدوية"
        "التخييم والرحلات" "الخدمات والاشتراكات" "التعليم والتدريب"]
   :de ["Computer und Laptops" "Telefone und Tablets" "Consumer Electronics" "Mode und Kleidung"
        "Gesundheit und Schönheit" "Haus und Küche" "Sport und Fitness" "Bücher und Literatur"
        "Spiele und Lernspielzeug" "Autos und Fahrräder" "Kinder und Babys" "Haustiere und Tiere"
        "Schmuck und Uhren" "Industrielle Ausrüstung" "Musik und Filme" "Möbel und Dekor"
        "Geschenke und Anlässe" "Lebensmittel und Getränke" "Werkzeuge und Handgeräte"
        "Camping und Ausflüge" "Dienstleistungen und Abonnements" "Bildung und Training"]
   :en ["Computers and Laptops" "Phones and Tablets" "Consumer Electronics" "Fashion and Clothing"
        "Health and Beauty" "Home and Kitchen" "Sports and Fitness" "Books and Literature"
        "Toys and Educational Games" "Cars and Bikes" "Kids and Babies" "Pets and Animals"
        "Jewelry and Watches" "Industrial Equipment" "Music and Movies" "Furniture and Decor"
        "Gifts and Occasions" "Food and Beverages" "Tools and Handheld Equipment"
        "Camping and Excursions" "Services and Subscriptions" "Education and Training"]
   :es ["Computadoras y Portátiles" "Teléfonos y Tabletas" "Electrónica de Consumo" "Moda y Ropa"
        "Salud y Belleza" "Hogar y Cocina" "Deportes y Fitness" "Libros y Literatura"
        "Juguetes y Juegos Educativos" "Coches y Bicicletas" "Niños y Bebés" "Mascotas y Animales"
        "Joyería y Relojes" "Equipos Industriales" "Música y Películas" "Muebles y Decoración"
        "Regalos y Ocasiones" "Comida y Bebidas" "Herramientas y Equipos Manuales"
        "Camping y Excursiones" "Servicios y Suscripciones" "Educación y Formación"]
   :fr ["Ordinateurs et Ordinateurs Portables" "Téléphones et Tablettes" "Électronique Grand Public"
        "Mode et Vêtements" "Santé et Beauté" "Maison et Cuisine" "Sports et Fitness" "Livres et Littérature"
        "Jouets et Jeux Éducatifs" "Voitures et Vélos" "Enfants et Bébés" "Animaux et Animaux Domestiques"
        "Bijoux et Montres" "Équipement Industriel" "Musique et Films" "Meubles et Décoration"
        "Cadeaux et Occasions" "Nourriture et Boissons" "Outils et Équipements à Main"
        "Camping et Excursions" "Services et Abonnements" "Éducation et Formation"]
   :tr ["Bilgisayarlar ve Dizüstü Bilgisayarlar" "Telefonlar ve Tabletler" "Tüketici Elektroniği" "Moda ve Giyim"
        "Sağlık ve Güzellik" "Ev ve Mutfak" "Spor" "Kitaplar ve Edebiyat"
        "Oyuncaklar ve Eğitici Oyunlar" "Araçlar ve Bisikletler" "Çocuklar ve Bebekler" "Evcil Hayvanlar"
        "Mücevherler ve Saatler" "Endüstriyel Ekipman" "Müzik ve Filmler" "Mobilya ve Dekor"
        "Hediyeler ve Özel Günler" "Yiyecek ve İçecekler" "Araçlar ve El Ekipmanları"
        "Kamp ve Geziler" "Hizmetler ve Abonelikler" "Eğitim"]})

(defn random-shopping-category
  "Generates a random shopping category in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr.
   Defaults to :en if no language is specified."
  ([] (random-shopping-category :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         categories (get shopping-categories (keyword lang))]
     (if categories
       (rand-nth categories)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))
