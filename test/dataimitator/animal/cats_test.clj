(ns dataimitator.animal.cats-test
  (:require [clojure.test :refer :all]
            [dataimitator.animal.cats :refer [random-cat cat-species]]))

(declare thrown? thrown-with-msg?)

;; Define test cases using clojure.test
(deftest test-random-cat
  (testing "Random cat species generation"
    ;; Test for English
    (is (contains? (set (:en cat-species)) (random-cat :en)))

    ;; Test for Arabic
    (is (contains? (set (:ar cat-species)) (random-cat :ar)))

    ;; Test for German
    (is (contains? (set (:de cat-species)) (random-cat :de)))

    ;; Test for Spanish
    (is (contains? (set (:es cat-species)) (random-cat :es)))

    ;; Test for French
    (is (contains? (set (:fr cat-species)) (random-cat :fr)))

    ;; Test for Turkish
    (is (contains? (set (:tr cat-species)) (random-cat :tr)))

    ;; Test with unsupported language
    (is (thrown? IllegalArgumentException (random-cat :it)))))

;; Run tests
(defn run-tests []
  (test-random-cat)
  (clojure.test/run-tests))

;; Run tests programmatically
(run-tests)