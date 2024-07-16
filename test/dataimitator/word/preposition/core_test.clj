(ns dataimitator.word.preposition.core-test
  (:require [clojure.test :refer :all]
            [dataimitator.word.preposition.core :refer :all]))

(declare thrown? thrown-with-msg?)

(deftest test-random-preposition-default
  (testing "Random preposition generation with default language (English)"
    (let [preposition (random-preposition)]
      (is (some #(= preposition %) (:en prepositions-data))))))

(deftest test-random-preposition-specific-language
  (testing "Random preposition generation with specified language"
    (doseq [lang [:ar :de :es :fr :tr]]
      (let [preposition (random-preposition lang)]
        (is (some #(= preposition %) (get prepositions-data lang)))))))

(deftest test-random-preposition-unsupported-language
  (testing "Random preposition generation with unsupported language"
    (is (thrown? IllegalArgumentException (random-preposition :unsupported-lang)))))

(deftest test-random-preposition-type
  (testing "Random preposition should be a string"
    (let [preposition (random-preposition)]
      (is (string? preposition)))))

;; Run all tests
;; (run-tests)
