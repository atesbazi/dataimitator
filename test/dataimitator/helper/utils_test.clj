(ns dataimitator.helper.utils-test
  (:require [clojure.test :refer :all]
            [dataimitator.helper.utils :refer :all])
  (:import (java.lang Character)))

(declare thrown? thrown-with-msg?)

(deftest test-random-in-range
  (testing "random-in-range"
    (is (let [result (random-in-range 1 10)]
          (and (>= result 1) (<= result 10))))
    (is (thrown? IllegalArgumentException (random-in-range 10 1)))))

(deftest test-random-long-in-range
  (testing "random-long-in-range"
    (is (let [result (random-long-in-range 1 10000000000)]
          (and (>= result 1) (<= result 10000000000))))
    (is (thrown? IllegalArgumentException (random-long-in-range 10 1)))))

(deftest test-random-int
  (testing "random-int"
    (is (let [result (random-int)]
          (and (>= result -128) (<= result 127))))))

(deftest test-random-with-max
  (testing "random-with-max"
    (is (let [result (random-with-max 10)]
          (and (>= result 0) (< result 10))))
    (is (thrown? IllegalArgumentException (random-with-max -1)))))

(deftest test-random-with
  (testing "random-with"
    (is (let [result (random-with 10)]
          (and (>= result 0) (< result 10))))
    (is (thrown? IllegalArgumentException (random-with -1)))
    (is (thrown? IllegalArgumentException (random-with 0)))))

(deftest test-random-ints
  (testing "random-ints"
    (is (let [result (random-ints 5 10)]
          (and (= (count result) 5)
               (every? #(and (>= % 0) (< % 10)) result))))))

(deftest test-random-choice
  (testing "random-choice"
    (is (let [coll [1 2 3 4 5]
              result (random-choice coll)]
          (contains? (set coll) result)))
    (is (thrown? IllegalArgumentException (random-choice [])))))

(deftest test-shuffle-coll
  (testing "shuffle-coll"
    (is (let [coll [1 2 3 4 5]
              result (shuffle-coll coll)]
          (and (= (count coll) (count result))
               (= (set coll) (set result)))))))

(deftest test-random-string
  (testing "random-string"
    (is (let [charset "abcdefghijklmnopqrstuvwxyz"
              result (random-string 10 charset)]
          (and (= (count result) 10)
               (every? #(contains? (set charset) %) result))))))

(deftest test-random-alphanumeric
  (testing "random-alphanumeric"
    (is (let [result (random-alphanumeric 10)]
          (and (= (count result) 10)
               (every? #(Character/isLetterOrDigit (char %)) result))))))

;; Run all tests
;; (run-tests)
