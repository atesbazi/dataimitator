(ns dataimitator.phone.core-test
  (:require [clojure.test :refer :all]
            [dataimitator.phone.core :refer [random-phone-number]]))

(deftest test-random-phone-number
  (testing "Random phone number generation"
    (let [usa-phone (random-phone-number :usa)
          europe-phone (random-phone-number :europe)
          international-phone (random-phone-number :international)]

      ;; Test USA format
      (is (re-find #"\d{3}-\d{3}-\d{4}" usa-phone)
          "USA phone number format is incorrect")

      ;; Test Europe format
      (is (re-find #"\+\d \d{3} \d{3} \d{4}" europe-phone)
          "Europe phone number format is incorrect")

      ;; Test International format
      (is (re-find #"\+\d{1,3} \d{10}" international-phone)
          "International phone number format is incorrect"))

    (testing "Default format"
      (let [default-phone (random-phone-number)]
        (is (re-find #"\d{3}-\d{3}-\d{4}" default-phone)
            "Default phone number format is incorrect")))))

;; Run tests
;; (run-tests)
