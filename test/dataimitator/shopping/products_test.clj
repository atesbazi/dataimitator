(ns dataimitator.shopping.products-test
  (:require [clojure.test :refer :all]
            [dataimitator.shopping.products :refer :all]))

(declare thrown? thrown-with-msg?)

(deftest test-random-shopping-product-name
  (testing "Random shopping product name generation"
    (testing "Default language (English)"
      (let [product-name (random-shopping-product-name)]
        (is (string? product-name) "Generated product name should be a string")
        (is (some #(= product-name %) (shopping-product-names :en)) "Product name should be in the English list")))

    (testing "Specified language"
      (doseq [lang [:ar :de :es :fr :tr]]
        (let [product-name (random-shopping-product-name lang)]
          (is (string? product-name) (str "Generated product name should be a string for " lang))
          (is (some #(= product-name %) (shopping-product-names lang))
              (str "Product name should be in the list for language " lang)))))

    (testing "Unsupported language"
      (is (thrown? IllegalArgumentException #"Unsupported language: \w+"
                            (random-shopping-product-name :unsupported-lang))
          "Should throw an exception for unsupported languages"))))

;; Run tests
;; (run-tests)
