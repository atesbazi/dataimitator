(ns dataimitator.datetime.core
  (:require [clojure.string :as str]
            [dataimitator.helper.utils :refer [random-in-range]])
  (:import (java.time Instant LocalDate LocalDateTime LocalTime ZoneId ZonedDateTime)
           (java.time.format DateTimeFormatter)
           (java.util Date)))

(defn random-local-date []
  (let [start-date (.toEpochDay (LocalDate/of 1970 1 1))
        end-date (.toEpochDay (LocalDate/now))
        random-day (+ start-date (rand-int (- end-date start-date)))]
    (LocalDate/ofEpochDay random-day)))

(defn random-local-time []
  "Generate a random LocalTime."
  (let [hour (random-in-range 0 23)
        minute (random-in-range 0 59)
        second (random-in-range 0 59)]
    (LocalTime/of hour minute second)))

(defn random-local-date-time []
  "Generate a random LocalDateTime."
  (LocalDateTime/of (random-local-date) (random-local-time)))

(defn random-zone-id []
  "Generate a random ZoneId."
  (let [zone-ids (into [] (ZoneId/getAvailableZoneIds))
        random-index (random-in-range 0 (count zone-ids))]
    (ZoneId/of (nth zone-ids random-index))))

(defn random-zoned-date-time []
  "Generate a random ZonedDateTime."
  (let [local-date-time (random-local-date-time)
        zone-id (random-zone-id)]
    (ZonedDateTime/of local-date-time zone-id)))

(defn random-date-between-strings [start-date-str end-date-str]
  (let [formatter (DateTimeFormatter/ofPattern "yyyy-MM-dd")
        start-date (LocalDate/parse start-date-str formatter)
        end-date (LocalDate/parse end-date-str formatter)
        start-epoch (.toEpochDay start-date)
        end-epoch (.toEpochDay end-date)
        random-epoch (+ start-epoch (rand-int (inc (- end-epoch start-epoch))))]
    (.format (LocalDate/ofEpochDay random-epoch) formatter)))

(defn random-date-between [start-date end-date]
  (let [start-epoch (.toEpochDay start-date)
        end-epoch (.toEpochDay end-date)
        random-epoch (+ start-epoch (rand-int (inc (- end-epoch start-epoch))))]
    (LocalDate/ofEpochDay random-epoch)))

(defn format-date
  "Formats a given date/time object with an optional format string.
   If no format is provided, uses ISO_LOCAL_DATE_TIME as default.
   Supported date/time objects: LocalDateTime, ZonedDateTime, Instant, java.util.Date"
  ([date-obj]
   (format-date date-obj "yyyy-MM-dd'T'HH:mm:ss"))
  ([date-obj format-str]
   (let [formatter (DateTimeFormatter/ofPattern format-str)
         local-date-time (cond
                           (instance? LocalDateTime date-obj) date-obj
                           (instance? ZonedDateTime date-obj) (.toLocalDateTime date-obj)
                           (instance? Instant date-obj) (LocalDateTime/ofInstant date-obj (ZoneId/systemDefault))
                           (instance? Date date-obj)
                            (LocalDateTime/ofInstant (.toInstant date-obj) (ZoneId/systemDefault))
                           :else (throw (IllegalArgumentException. "Unsupported date/time object")))]
     (.format formatter local-date-time))))

(defn formatted-prefix
  "Formats a given date/time object with an optional format string.
   Defaults to ISO format if no format string is provided."
  [datetime & [format-str]]
  (let [formatter (if format-str
                    (DateTimeFormatter/ofPattern format-str)
                    (DateTimeFormatter/ISO_LOCAL_DATE_TIME))]
    (.format datetime formatter)))

(defn formatted-random-local-date [& [format-str]]
  "Generate a formatted random LocalDate with an optional format string."
  (let [formatter (if format-str
                    (DateTimeFormatter/ofPattern format-str)
                    (DateTimeFormatter/ISO_LOCAL_DATE))]
    (.format (random-local-date) formatter)))

(defn formatted-random-local-time [& [format-str]]
  "Generate a formatted random LocalTime with an optional format string."
  (let [formatter (if format-str
                    (DateTimeFormatter/ofPattern format-str)
                    (DateTimeFormatter/ISO_LOCAL_TIME))]
    (.format (random-local-time) formatter)))

(defn formatted-random-local-date-time [& [format-str]]
  "Generate a formatted random LocalDateTime with an optional format string."
  (formatted-prefix (random-local-date-time) format-str))

(defn formatted-random-zoned-date-time [& [format-str]]
  "Generate a formatted random ZonedDateTime with an optional format string."
  (formatted-prefix (random-zoned-date-time) format-str))

(def weekday-names
  {:ar ["الأحد" "الاثنين" "الثلاثاء" "الأربعاء" "الخميس" "الجمعة" "السبت"]
   :de ["Sonntag" "Montag" "Dienstag" "Mittwoch" "Donnerstag" "Freitag" "Samstag"]
   :en ["Sunday" "Monday" "Tuesday" "Wednesday" "Thursday" "Friday" "Saturday"]
   :es ["Domingo" "Lunes" "Martes" "Miércoles" "Jueves" "Viernes" "Sábado"]
   :fr ["Dimanche" "Lundi" "Mardi" "Mercredi" "Jeudi" "Vendredi" "Samedi"]
   :tr ["Pazar" "Pazartesi" "Salı" "Çarşamba" "Perşembe" "Cuma" "Cumartesi"]})

(defn random-weekday-name
  "Generates a random weekday name in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr.
   Defaults to :en (English) if no language is specified."
  ([] (random-weekday-name :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         names (get weekday-names (keyword lang))]
     (if names
       (rand-nth names)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))

(def month-names
  {:ar ["يناير" "فبراير" "مارس" "أبريل" "مايو" "يونيو" "يوليو" "أغسطس" "سبتمبر" "أكتوبر" "نوفمبر" "ديسمبر"]
   :de ["Januar" "Februar" "März" "April" "Mai" "Juni" "Juli" "August" "September" "Oktober" "November" "Dezember"]
   :en ["January" "February" "March" "April" "May" "June" "July" "August" "September" "October" "November" "December"]
   :es ["Enero" "Febrero" "Marzo" "Abril" "Mayo" "Junio" "Julio" "Agosto" "Septiembre" "Octubre" "Noviembre" "Diciembre"]
   :fr ["Janvier" "Février" "Mars" "Avril" "Mai" "Juin" "Juillet" "Août" "Septembre" "Octobre" "Novembre" "Décembre"]
   :tr ["Ocak" "Şubat" "Mart" "Nisan" "Mayıs" "Haziran" "Temmuz" "Ağustos" "Eylül" "Ekim" "Kasım" "Aralık"]})

(defn random-month-name
  "Generates a random month name in the specified language.
   Supported languages: :ar, :de, :en, :es, :fr, :tr.
   Defaults to :en (English) if no language is specified."
  ([] (random-month-name :en))
  ([language]
   (let [lang (if (keyword? language) (name language) language)
         names (get month-names (keyword lang))]
     (if names
       (rand-nth names)
       (throw (IllegalArgumentException. (str "Unsupported language: " language)))))))

(defn random-year
  "Generates a random year between start-year and end-year."
  ([] (random-year 1900 2100))
  ([start-year end-year]
   (let [year (random-in-range start-year end-year)]
     year)))

(defn random-hour
  "Generates a random time with optional period (AM or PM, default is AM)."
  ([] (random-hour "AM"))
  ([period]
   (let [hour (rand-int 12)
         minutes (rand-int 60)
         period (if (= (str/lower-case period) "pm") "PM" "AM")]
     (str hour ":" (format "%02d" minutes) " " period))))
