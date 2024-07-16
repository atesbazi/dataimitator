(ns dataimitator.word.verb.core-test
  (:require [clojure.test :refer :all]
            [dataimitator.word.verb.core :refer :all]))

(declare thrown? thrown-with-msg?)

(deftest test-random-verb-default
  (testing "Random verb generation with default language (English)"
    (let [verb (random-verb)]
      (is (some #(= verb %) (:en verbs-data))))))

(deftest test-random-verb-specific-language
  (testing "Random verb generation with specified language"
    (doseq [lang [:ar :de :es :fr :tr]]
      (let [verb (random-verb lang)]
        (is (some #(= verb %) (get verbs-data lang)))))))

(deftest test-random-verb-unsupported-language
  (testing "Random verb generation with unsupported language"
    (is (thrown? IllegalArgumentException (random-verb :unsupported-lang)))))

(deftest test-random-verb-type
  (testing "Random verb should be a string"
    (let [verb (random-verb)]
      (is (string? verb)))))

;; Run all tests
;; (run-tests)
