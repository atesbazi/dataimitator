(ns dataimitator.word.adjective.core-test
  (:require [clojure.test :refer :all]
            [dataimitator.word.adjective.core :refer :all]))

(declare thrown? thrown-with-msg?)

(deftest test-random-adjective
  (testing "Random adjective generation"
    (let [adjective (random-adjective)]
      ;; Test that the default language is English
      (is (some #(= adjective %) (:en adjectives-data)) "Default language should be English and the adjective should be valid"))

    (doseq [lang [:ar :de :en :es :fr :tr]]
      (testing (str "Testing language: " lang)
        (let [adjective (random-adjective lang)]
          ;; Test that the adjective is valid for the specified language
          (is (some #(= adjective %) (get adjectives-data lang))
              (str "Adjective should be valid for language " lang)))))

    ;; Test unsupported language
    (testing "Unsupported language"
      (is (thrown? IllegalArgumentException
                            (random-adjective :unsupported))))))

;; Run tests
;; (run-tests)
