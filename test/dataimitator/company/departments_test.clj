(ns dataimitator.company.departments-test
  (:require [clojure.test :refer :all]
            [dataimitator.company.departments :refer :all]))

(declare thrown? thrown-with-msg?)

(deftest test-random-department-name
  (testing "Random department name generation"
    (is (some? (random-department-name :en)))
    (is (some? (random-department-name :de)))
    (is (some? (random-department-name :fr)))
    (is (some? (random-department-name :es)))
    (is (some? (random-department-name :tr)))
    (is (some? (random-department-name :ar)))
    (is (thrown? IllegalArgumentException (random-department-name :unsupported-lang)))))

;;(run-tests)
