(ns dataimitator.shopping.prices-test
  (:require [clojure.test :refer :all]
            [dataimitator.shopping.prices :refer :all]))

(deftest test-random-price
  (testing "Generate random price with default parameters"
    (let [price (random-price)]
      (is (string? price))))
  (testing "Handle Turkish currency"
    (let [price (random-price 0 50000 :tr)]
      (is (string? price))
      (is (re-matches #"\d{1,3}(.\d{3})*.\d{2}₺" price)))))

(deftest test-currency-formats
  (testing "Check if all supported currencies are present"
    (are [currency] (contains? currency-formats currency)
                    :ar :de :en :es :fr :tr :jp :gb :kw))

  (testing "Check currency format structure"
    (doseq [[_ format] currency-formats]
      (is (contains? format :symbol))
      (is (contains? format :position))
      (is (contains? format :separator))
      (is (contains? format :decimal)))))
