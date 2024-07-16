(ns dataimitator.person.core
  (:require [clojure.string :as str])
  (:import (java.util UUID)
           (java.security MessageDigest SecureRandom)
           (java.util Base64)))

(def first-names
  {:ar ["محمد" "أحمد" "يوسف" "علي" "فاطمة" "عائشة" "زهراء" "زينب" "مريم" "خديجة"
        "عمر" "حسن" "حسين" "عبدالله" "عبدالرحمن" "سارة" "ريم" "نور" "إيمان" "لينا"]
   :de ["Hans" "Peter" "Anna" "Lena" "Michael" "Sophia" "Johannes" "Marie" "Karl" "Emma"
        "Lucas" "Julian" "Charlotte" "Mia" "Maximilian" "Lina" "Ben" "Elias" "Emilia" "Leonie"]
   :en ["John" "Jane" "Michael" "Emily" "David" "Sarah" "Chris" "Jessica" "Daniel" "Laura"
        "James" "Mary" "Robert" "Linda" "William" "Barbara" "Richard" "Susan" "Joseph" "Margaret"
        "Thomas" "Dorothy" "Charles" "Lisa" "Christopher" "Nancy" "Matthew" "Betty" "Joshua" "Sandra"
        "Andrew" "Ashley" "Ryan" "Donna" "Nicholas" "Carol" "Brian" "Michelle" "Kevin" "Patricia"]
   :es ["Juan" "Maria" "Luis" "Carmen" "Jose" "Ana" "Carlos" "Lucia" "Miguel" "Sofia"
        "Alejandro" "Isabella" "Francisco" "Martina" "Fernando" "Elena" "Diego" "Valentina" "Javier" "Gabriela"]
   :fr ["Jean" "Marie" "Pierre" "Sophie" "Paul" "Lucie" "Jacques" "Isabelle" "Louis" "Claire"
        "Philippe" "Camille" "Marc" "Julie" "Alain" "Catherine" "Henri" "Nathalie" "Gérard" "Sylvie"]
   :tr ["Ahmet" "Ayşe" "Mehmet" "Fatma" "Ali" "Emine" "Mustafa" "Zeynep" "Hüseyin" "Elif"
        "Hasan" "Hatice" "İbrahim" "Merve" "Osman" "Rabia" "Yusuf" "Kübra" "Ömer" "Gül"]})

(def last-names
  {:ar ["الأنصاري" "البغدادي" "الجوهري" "الحسيني" "الخليفة" "الدين" "الرشيدي" "السباعي" "الشريف" "الصالح"
        "الطائي" "العلي" "الفاسي" "القرشي" "المحمدي" "النابلسي" "الهاشمي" "الوزير" "الياسين" "بكري"]
   :de ["Müller" "Schmidt" "Schneider" "Fischer" "Weber" "Meyer" "Wagner" "Becker" "Schulz" "Hoffmann"
        "Schäfer" "Koch" "Bauer" "Richter" "Klein" "Wolf" "Schröder" "Neumann" "Braun" "Zimmermann"]
   :en ["Smith" "Johnson" "Williams" "Brown" "Jones" "Garcia" "Miller" "Davis" "Rodriguez" "Martinez"
        "Hernandez" "Lopez" "Gonzalez" "Wilson" "Anderson" "Thomas" "Taylor" "Moore" "Jackson" "Martin"]
   :es ["García" "Fernández" "González" "Rodríguez" "López" "Martínez" "Sánchez" "Pérez" "Gómez" "Martin"
        "Jiménez" "Ruiz" "Hernández" "Diaz" "Moreno" "Álvarez" "Muñoz" "Romero" "Alonso" "Gutiérrez"]
   :fr ["Martin" "Bernard" "Dubois" "Thomas" "Robert" "Richard" "Petit" "Durand" "Leroy" "Moreau"
        "Simon" "Laurent" "Lefebvre" "Michel" "Garcia" "David" "Bertrand" "Roux" "Vincent" "Fournier"]
   :tr ["Yılmaz" "Kaya" "Demir" "Şahin" "Çelik" "Yıldız" "Yıldırım" "Öztürk" "Aydın" "Arslan"
        "Doğan" "Kılıç" "Aslan" "Erdem" "Kara" "Koç" "Güneş" "Çetin" "Keskin" "Şimşek"]})

(defn random-first-name
  "Generates a random first name in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr.
   Defaults to :en if no language is specified."
  ([] (random-first-name :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         names (get first-names (keyword lang))]
     (if names
       (rand-nth names)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))

(defn random-last-name
  "Generates a random last name in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr
   Defaults to :en if no language is specified."
  ([] (random-last-name :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         names (get last-names (keyword lang))]
     (if names
       (rand-nth names)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))

(defn random-name
  "Generates a random full name in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr
   Defaults to :en if no language is specified."
  ([] (random-name :en))
  ([language]
   (str (random-first-name language) " " (random-last-name language))))

(defn random-age []
  (+ 18 (rand-int 63))) ;; Random age between 18 and 80

(defn random-email [name]
  (let [domain (rand-nth ["gmail.com" "yahoo.com" "outlook.com" "example.com"])]
    (str (str/replace name " " ".") "@" domain)))

(defn random-phone []
  (str "+1-" (rand-int 900) "-" (format "%03d" (rand-int 1000)) "-" (format "%04d" (rand-int 10000))))

(defn random-address []
  (let [street-number (rand-int 9999)
        street-name (rand-nth ["Main St" "Second St" "Third St" "Elm St" "Oak St"
                               "Maple St" "Pine St" "Cedar St" "Birch St"
                               "Spruce St" "Chestnut St" "Poplar St" "Willow St"])
        city (rand-nth ["New York" "Los Angeles" "Chicago" "Houston"
                        "Phoenix" "Philadelphia" "San Antonio"
                        "San Diego" "Dallas" "San Jose"])
        state (rand-nth ["NY" "CA" "IL" "TX" "AZ" "PA" "FL" "OH" "NC"])
        zip-code (format "%05d" (rand-int 100000))]
    (str street-number " " street-name ", " city ", " state " " zip-code)))

(defn random-person
  "Generates random person data."
  []
  (let [name (random-name)]
    {:name name
     :age (random-age)
     :email (random-email name)
     :address (random-address)
     :phone (random-phone)}))

(defn random-people
  "Generates n random people."
  [n]
  (repeatedly n random-person))

(def usernames
  ["user1" "user2" "user3" "user4" "user5" "user6" "user7" "user8" "user9" "user10"
   "alice" "bob" "charlie" "dave" "eve" "mallory" "oscar" "peggy" "trent" "victor"])

(defn random-username []
  "Generates a random username."
  (rand-nth usernames))

(defn random-password []
  "Generates a random password of length 8-12 characters."
  (let [length (+ 8 (rand-int 5))
        chars "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()"]
    (apply str (repeatedly length #(rand-nth chars)))))

(defn random-salt []
  "Generates a random salt."
  (let [salt-bytes (byte-array 16)]
    (.nextBytes (SecureRandom.) salt-bytes)
    (.encodeToString (Base64/getEncoder) salt-bytes)))

;; Thanks to https://gist.github.com/kubek2k/8446062
;; l0st3d
(defn sha256 [string]
  "Generates sha256 string."
  (let [digest (.digest (MessageDigest/getInstance "SHA-256") (.getBytes string "UTF-8"))]
    (apply str (map (partial format "%02x") digest))))

(defn random-user-login-data []
  "Generates random user login data with uuid, username, password, salt, and sha256 fields."
  (let [uuid (str (UUID/randomUUID))
        username (random-username)
        password (random-password)
        salt (random-salt)
        salted-password (str password salt)
        sha256-hash (sha256 salted-password)]
    {:uuid uuid
     :username username
     :password password
     :salt salt
     :sha256 sha256-hash}))
