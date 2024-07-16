(ns dataimitator.animal.birds-test
  (:require [clojure.test :refer :all]
            [dataimitator.animal.birds :refer [random-bird bird-species]]))

(declare thrown? thrown-with-msg?)

;; Define test cases using clojure.test
(deftest test-random-bird
  (testing "Random bird species generation"
    ;; Test for English
    (is (contains? (set (:en bird-species)) (random-bird :en)))

    ;; Test for Arabic
    (is (contains? (set (:ar bird-species)) (random-bird :ar)))

    ;; Test for German
    (is (contains? (set (:de bird-species)) (random-bird :de)))

    ;; Test for Spanish
    (is (contains? (set (:es bird-species)) (random-bird :es)))

    ;; Test for French
    (is (contains? (set (:fr bird-species)) (random-bird :fr)))

    ;; Test for Turkish
    (is (contains? (set (:tr bird-species)) (random-bird :tr)))

    ;; Test with unsupported language
    (is (thrown? IllegalArgumentException (random-bird :it)))))

;; Run tests
(defn run-tests []
  (test-random-bird)
  (clojure.test/run-tests))

;; Run tests programmatically
(run-tests)
