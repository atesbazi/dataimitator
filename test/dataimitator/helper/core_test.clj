(ns dataimitator.helper.core-test
  (:require [clojure.test :refer :all]
            [dataimitator.helper.core :refer :all]))

(deftest test-round-to-two-decimals
  (testing "round-to-two-decimals"
    (is (= 3.14 (round-to-two-decimals 3.14159)))
    (is (= 2.72 (round-to-two-decimals 2.71828)))
    (is (= 1.0 (round-to-two-decimals 1)))
    (is (= -1.23 (round-to-two-decimals -1.2345)))
    (is (= 0.0 (round-to-two-decimals 0)))
    (is (= 123.46 (round-to-two-decimals 123.456)))
    (is (= 12345.68 (round-to-two-decimals 12345.6789)))))

;; Run all tests
;; (run-tests)
