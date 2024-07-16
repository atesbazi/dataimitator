(ns dataimitator.animal.dogs-test
  (:require [clojure.test :refer :all]
            [dataimitator.animal.dogs :refer [random-dog dog-species]]))

(declare thrown? thrown-with-msg?)

;; Define test cases using clojure.test
(deftest test-random-dog
  (testing "Random dog species generation"
    ;; Test for English
    (is (contains? (set (:en dog-species)) (random-dog :en)))

    ;; Test for Arabic
    (is (contains? (set (:ar dog-species)) (random-dog :ar)))

    ;; Test for German
    (is (contains? (set (:de dog-species)) (random-dog :de)))

    ;; Test for Spanish
    (is (contains? (set (:es dog-species)) (random-dog :es)))

    ;; Test for French
    (is (contains? (set (:fr dog-species)) (random-dog :fr)))

    ;; Test for Turkish
    (is (contains? (set (:tr dog-species)) (random-dog :tr)))

    ;; Test with unsupported language
    (is (thrown? IllegalArgumentException (random-dog :it)))))

;; Run tests
(defn run-tests []
  (test-random-dog)
  (clojure.test/run-tests))

;; Run tests programmatically
(run-tests)