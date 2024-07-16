(ns dataimitator.datetime.core-test
  (:require [clojure.test :refer :all]
            [dataimitator.datetime.core :refer :all])
  (:import (java.time LocalDate LocalDateTime LocalTime ZoneId ZonedDateTime)
           (java.time.format DateTimeFormatter)))

(deftest test-random-local-date
  (testing "random-local-date"
    (let [date (random-local-date)]
      (is (instance? LocalDate date)))))

(deftest test-random-local-time
  (testing "random-local-time"
    (let [time (random-local-time)]
      (is (instance? LocalTime time))
      (is (>= (.getHour time) 0))
      (is (< (.getHour time) 24))
      (is (>= (.getMinute time) 0))
      (is (< (.getMinute time) 60))
      (is (>= (.getSecond time) 0))
      (is (< (.getSecond time) 60)))))

(deftest test-random-local-date-time
  (testing "random-local-date-time"
    (let [date-time (random-local-date-time)]
      (is (instance? LocalDateTime date-time)))))

(deftest test-random-zone-id
  (testing "random-zone-id"
    (let [zone-id (random-zone-id)]
      (is (instance? ZoneId zone-id)))))

(deftest test-random-zoned-date-time
  (testing "random-zoned-date-time"
    (let [zoned-date-time (random-zoned-date-time)]
      (is (instance? ZonedDateTime zoned-date-time)))))

(deftest test-random-date-between-strings
  (testing "random-date-between-strings"
    (let [start-date "2000-01-01"
          end-date "2020-01-01"
          date-str (random-date-between-strings start-date end-date)]
      (is (string? date-str))
      (let [date (LocalDate/parse date-str (DateTimeFormatter/ofPattern "yyyy-MM-dd"))]
        (is (instance? LocalDate date))
        (is (not (.isBefore date (LocalDate/parse start-date))))
        (is (not (.isAfter date (LocalDate/parse end-date))))))))

(deftest test-random-date-between
  (testing "random-date-between"
    (let [start-date (LocalDate/of 2000 1 1)
          end-date (LocalDate/of 2020 1 1)
          date (random-date-between start-date end-date)]
      (is (instance? LocalDate date))
      (is (not (.isBefore date start-date)))
      (is (not (.isAfter date end-date))))))

(deftest test-format-date
  (testing "format-date"
    (let [date-time (LocalDateTime/of 2024 7 11 14 38 45)
          formatted (format-date date-time "yyyy-MM-dd HH:mm:ss")]
      (is (= formatted "2024-07-11 14:38:45")))))

(deftest test-formatted-random-local-date
  (testing "formatted-random-local-date"
    (let [formatted-date (formatted-random-local-date "dd-MM-yyyy")]
      (is (string? formatted-date)))))

(deftest test-formatted-random-local-time
  (testing "formatted-random-local-time"
    (let [formatted-time (formatted-random-local-time "HH:mm:ss")]
      (is (string? formatted-time)))))

(deftest test-formatted-random-local-date-time
  (testing "formatted-random-local-date-time"
    (let [formatted-date-time (formatted-random-local-date-time "dd-MM-yyyy HH:mm:ss")]
      (is (string? formatted-date-time)))))

(deftest test-formatted-random-zoned-date-time
  (testing "formatted-random-zoned-date-time"
    (let [formatted-zoned-date-time (formatted-random-zoned-date-time "dd-MM-yyyy HH:mm:ss VV")]
      (is (string? formatted-zoned-date-time)))))

(deftest test-random-weekday-name
  (testing "random-weekday-name"
    (doseq [lang [:ar :de :en :es :fr :tr]]
      (let [name (random-weekday-name lang)]
        (is (string? name))))))

(deftest test-random-month-name
  (testing "random-month-name"
    (doseq [lang [:ar :de :en :es :fr :tr]]
      (let [name (random-month-name lang)]
        (is (string? name))))))

(deftest test-random-year
  (testing "random-year"
    (let [year (random-year 1900 2100)]
      (is (integer? year))
      (is (>= year 1900))
      (is (<= year 2100)))))

(deftest test-random-hour
  (testing "random-hour"
    (let [hour-am (random-hour "AM")
          hour-pm (random-hour "PM")]
      (is (re-matches #"\d{1,2}:\d{2} AM" hour-am))
      (is (re-matches #"\d{1,2}:\d{2} PM" hour-pm)))))

;; Run all tests
;; (run-tests)
