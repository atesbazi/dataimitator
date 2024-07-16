(ns dataimitator.company.core-test
  (:require [clojure.test :refer :all]
            [dataimitator.company.core :refer :all]))

(declare thrown? thrown-with-msg?)

(deftest test-random-company-name
  (testing "Random company name generation"
    (is (some? (random-company-name :en)))
    (is (some? (random-company-name :de)))
    (is (some? (random-company-name :fr)))
    (is (some? (random-company-name :es)))
    (is (some? (random-company-name :tr)))
    (is (some? (random-company-name :ar)))
    (is (thrown? IllegalArgumentException (random-company-name :unsupported-lang)))))

;;(run-tests 'dataimitator.company.core-test)
