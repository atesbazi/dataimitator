(ns dataimitator.finance.core-test
  (:require [clojure.test :refer :all]
            [dataimitator.finance.core :refer :all]))

(deftest test-random-credit-card
  (testing "random-credit-card"
    (let [card (random-credit-card)]
      (is (= 16 (count card)))
      (is (re-matches #"^[4563]\d{15}$" card)))))

(deftest test-random-currency-symbol
  (testing "random-currency-symbol"
    (let [symbol (random-currency-symbol)]
      (is (some #{symbol} (vals currencies))))))

(deftest test-random-iban
  (testing "random-iban"
    (let [iban (random-iban)]
      (is (> 34 (count iban))))))

(deftest test-random-pin
  (testing "random-pin default length"
    (let [pin (random-pin)]
      (is (= 4 (count pin)))
      (is (re-matches #"\d{4}" pin))))
  (testing "random-pin custom length"
    (let [pin (random-pin 6)]
      (is (= 6 (count pin)))
      (is (re-matches #"\d{6}" pin)))))

(deftest test-random-invoice
  (testing "random-invoice default currency"
    (let [invoice (random-invoice)]
      (is (string? (:invoice-number invoice)))
      (is (re-matches #"^INV-\d+$" (:invoice-number invoice)))
      (is (string? (:invoice-date invoice)))
      (is (some #{(:customer-name invoice)} ["Company A" "Company B" "Company C"]))
      (is (vector? (:items invoice)))
      (is (every? #(and (map? %) (contains? % :name) (contains? % :price)) (:items invoice)))
      (is (string? (:total invoice)))
      (is (re-matches #"^\$\d+$" (:total invoice)))))
  (testing "random-invoice custom currency"
    (let [invoice (random-invoice :EUR)]
      (is (re-matches #"^€\d+$" (:total invoice))))))

(deftest test-random-invoices
  (testing "random-invoices"
    (let [invoices (random-invoices 5)]
      (is (= 5 (count invoices)))
      (is (every? map? invoices)))))

;; Run all tests
;; (run-tests)
