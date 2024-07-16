(ns dataimitator.word.noun.core-test
  (:require [clojure.test :refer :all]
            [dataimitator.word.noun.core :refer :all]))

(declare thrown? thrown-with-msg?)

(deftest test-random-noun-default
  (testing "Random noun generation with default language (English)"
    (let [noun (random-noun)]
      (is (some #(= noun %) (:en nouns-data))))))

(deftest test-random-noun-specific-language
  (testing "Random noun generation with specified language"
    (doseq [lang [:ar :de :es :fr :tr]]
      (let [noun (random-noun lang)]
        (is (some #(= noun %) (get nouns-data lang)))))))

(deftest test-random-noun-unsupported-language
  (testing "Random noun generation with unsupported language"
    (is (thrown? IllegalArgumentException (random-noun :unsupported-lang)))))

(deftest test-random-noun-capitalization
  (testing "Random noun should start with a lowercase letter"
    (let [noun (random-noun)]
      (is (Character/isLowerCase (first noun))))))

(deftest test-random-noun-type
  (testing "Random noun should be a string"
    (let [noun (random-noun)]
      (is (string? noun)))))

;; Run all tests
;; (run-tests)
