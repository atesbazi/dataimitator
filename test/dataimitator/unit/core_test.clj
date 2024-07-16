(ns dataimitator.unit.core-test
  (:require [clojure.test :refer :all]
            [dataimitator.unit.core :refer :all]))

(declare thrown? thrown-with-msg?)

(deftest test-random-unit-of-length
  (testing "Random unit of length generation"
    (testing "Default language (English)"
      (let [unit (random-unit-of-length)]
        (is (string? unit) "Generated unit should be a string")
        (is (some #(= unit %) (length-units :en)) "Unit should be in the English list")))

    (testing "Specified language"
      (doseq [lang [:ar :de :es :fr :tr]]
        (let [unit (random-unit-of-length lang)]
          (is (string? unit) (str "Generated unit should be a string for " lang))
          (is (some #(= unit %) (length-units lang))
              (str "Unit should be in the list for language " lang)))))

    (testing "Unsupported language"
      (is (thrown? IllegalArgumentException #"Unsupported language: \w+"
                            (random-unit-of-length :unsupported-lang))
          "Should throw an exception for unsupported languages"))))

(deftest test-random-volume-unit
  (testing "Random volume unit generation"
    (testing "Default language (English)"
      (let [unit (random-volume-unit)]
        (is (string? unit) "Generated unit should be a string")
        (is (some #(= unit %) (volume-units :en)) "Unit should be in the English list")))

    (testing "Specified language"
      (doseq [lang [:ar :de :es :fr :tr]]
        (let [unit (random-volume-unit lang)]
          (is (string? unit) (str "Generated unit should be a string for " lang))
          (is (some #(= unit %) (volume-units lang))
              (str "Unit should be in the list for language " lang)))))

    (testing "Unsupported language"
      (is (thrown? IllegalArgumentException #"Unsupported language: \w+"
                            (random-volume-unit :unsupported-lang))
          "Should throw an exception for unsupported languages"))))

(deftest test-random-weight-unit
  (testing "Random weight unit generation"
    (testing "Default language (English)"
      (let [unit (random-weight-unit)]
        (is (string? unit) "Generated unit should be a string")
        (is (some #(= unit %) (weight-units :en)) "Unit should be in the English list")))

    (testing "Specified language"
      (doseq [lang [:ar :de :es :fr :tr]]
        (let [unit (random-weight-unit lang)]
          (is (string? unit) (str "Generated unit should be a string for " lang))
          (is (some #(= unit %) (weight-units lang))
              (str "Unit should be in the list for language " lang)))))

    (testing "Unsupported language"
      (is (thrown? IllegalArgumentException #"Unsupported language: \w+"
                            (random-weight-unit :unsupported-lang))
          "Should throw an exception for unsupported languages"))))

;; Run tests
;; (run-tests)
