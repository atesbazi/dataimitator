(ns dataimitator.shopping.products)

(def shopping-product-names
  {:ar ["هاتف ذكي" "لابتوب" "تلفزيون ذكي" "سماعات بلوتوث" "كاميرا رقمية" "طابعة ليزر"
        "ماوس لاسلكي" "مكنسة كهربائية" "ساعة ذكية" "مكبر صوت بلوتوث" "مجفف شعر"
        "طاولة تلفزيون" "موقد غاز" "مبرد مياه" "فرن كهربائي" "مكيف هواء" "غسالة ملابس"
        "ثلاجة" "مروحة" "سخان كهربائي"]
   :de ["Smartphone" "Laptop" "Smart TV" "Bluetooth-Kopfhörer" "Digitalkamera" "Laserdrucker"
        "Wireless Maus" "Staubsauger" "Smartwatch" "Bluetooth-Lautsprecher" "Haartrockner"
        "Fernsehtisch" "Gasherd" "Wasserkühler" "Elektroofen" "Klimaanlage" "Waschmaschine"
        "Kühlschrank" "Ventilator" "Elektroheizung"]
   :en ["Smartphone" "Laptop" "Smart TV" "Bluetooth Headphones" "Digital Camera" "Laser Printer"
        "Wireless Mouse" "Vacuum Cleaner" "Smartwatch" "Bluetooth Speaker" "Hair Dryer"
        "TV Stand" "Gas Stove" "Water Cooler" "Electric Oven" "Air Conditioner" "Washing Machine"
        "Refrigerator" "Fan" "Electric Heater"]
   :es ["Teléfono inteligente" "Portátil" "Smart TV" "Auriculares Bluetooth" "Cámara digital" "Impresora láser"
        "Ratón inalámbrico" "Aspiradora" "Reloj inteligente" "Altavoz Bluetooth" "Secador de pelo"
        "Mesa de TV" "Estufa de gas" "Dispensador de agua" "Horno eléctrico" "Aire acondicionado"
        "Lavadora" "Refrigerador" "Ventilador" "Calefactor eléctrico"]
   :fr ["Smartphone" "Ordinateur portable" "Smart TV" "Écouteurs Bluetooth" "Appareil photo numérique" "Imprimante laser"
        "Souris sans fil" "Aspirateur" "Montre intelligente" "Enceinte Bluetooth" "Sèche-cheveux"
        "Table de télévision" "Cuisinière à gaz" "Refroidisseur d'eau" "Four électrique" "Climatiseur"
        "Machine à laver" "Réfrigérateur" "Ventilateur" "Chauffage électrique"]
   :tr ["Akıllı Telefon" "Dizüstü Bilgisayar" "Akıllı TV" "Bluetooth Kulaklık" "Dijital Kamera" "Lazer Yazıcı"
        "Kablosuz Fare" "Elektrikli Süpürge" "Akıllı Saat" "Bluetooth Hoparlör" "Saç Kurutma Makinesi"
        "TV Sehpası" "Gazlı Ocak" "Su Soğutucu" "Elektrikli Fırın" "Klima" "Çamaşır Makinesi"
        "Buzdolabı" "Fan" "Elektrikli Isıtıcı"]})

(defn random-shopping-product-name
  "Generates a random shopping product name in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr.
   Defaults to :en if no language is specified."
  ([] (random-shopping-product-name :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         names (get shopping-product-names (keyword lang))]
     (if names
       (rand-nth names)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))
