(ns dataimitator.company.organizations-test
  (:require [clojure.test :refer :all]
            [dataimitator.company.organizations :refer :all]))

(declare thrown? thrown-with-msg?)

(deftest test-random-organization-name
  (testing "Random organization name generation"
    (is (some? (random-organization-name :en)))
    (is (some? (random-organization-name :de)))
    (is (some? (random-organization-name :fr)))
    (is (some? (random-organization-name :es)))
    (is (some? (random-organization-name :tr)))
    (is (some? (random-organization-name :ar)))
    (is (thrown? IllegalArgumentException (random-organization-name :unsupported-lang)))))

;;(run-tests)
