(ns dataimitator.company.roles-test
  (:require [clojure.test :refer :all]
            [dataimitator.company.department_roles :refer :all]))

(declare thrown? thrown-with-msg?)

(deftest test-random-department-role
  (testing "Random department role generation"
    (is (some? (random-department-role :en)))
    (is (some? (random-department-role :de)))
    (is (some? (random-department-role :fr)))
    (is (some? (random-department-role :es)))
    (is (some? (random-department-role :tr)))
    (is (some? (random-department-role :ar)))
    (is (thrown? IllegalArgumentException (random-department-role :unsupported-lang)))))

;;(run-tests)
