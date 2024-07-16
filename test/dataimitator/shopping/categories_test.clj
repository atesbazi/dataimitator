(ns dataimitator.shopping.categories-test
  (:require [clojure.test :refer :all]
            [dataimitator.shopping.categories :refer [random-shopping-category]]))

(declare thrown? thrown-with-msg?)

(deftest test-random-shopping-category
  (testing "Random shopping category generation"
    (let [ar-category (random-shopping-category :ar)
          de-category (random-shopping-category :de)
          en-category (random-shopping-category :en)
          es-category (random-shopping-category :es)
          fr-category (random-shopping-category :fr)
          tr-category (random-shopping-category :tr)]

      ;; Test Arabic category
      (is (some? ar-category)
          "Expected a non-nil Arabic category")
      (is (re-find #".+" ar-category)
          "Arabic category should not be empty")

      ;; Test German category
      (is (some? de-category)
          "Expected a non-nil German category")
      (is (re-find #".+" de-category)
          "German category should not be empty")

      ;; Test English category
      (is (some? en-category)
          "Expected a non-nil English category")
      (is (re-find #".+" en-category)
          "English category should not be empty")

      ;; Test Spanish category
      (is (some? es-category)
          "Expected a non-nil Spanish category")
      (is (re-find #".+" es-category)
          "Spanish category should not be empty")

      ;; Test French category
      (is (some? fr-category)
          "Expected a non-nil French category")
      (is (re-find #".+" fr-category)
          "French category should not be empty")

      ;; Test Turkish category
      (is (some? tr-category)
          "Expected a non-nil Turkish category")
      (is (re-find #".+" tr-category)
          "Turkish category should not be empty"))

    (testing "Default language"
      (let [default-category (random-shopping-category)]
        (is (some? default-category)
            "Expected a non-nil default category")
        (is (re-find #".+" default-category)
            "Default category should not be empty")))

    (testing "Unsupported language"
      (is (thrown? IllegalArgumentException (random-shopping-category :unsupported))
          "Expected an IllegalArgumentException for unsupported language"))))

;; Run tests
;; (run-tests)
