(ns dataimitator.word.adverb.core-test
  (:require [clojure.test :refer :all]
            [dataimitator.word.adverb.core :refer :all]))

(declare thrown? thrown-with-msg?)

(deftest test-random-adverb
  (testing "Random adverb generation"
    (let [adverb (random-adverb)]
      ;; Test that the default language is English
      (is (some #(= adverb %) (:en adverbs-data)) "Default language should be English and the adverb should be valid"))

    (doseq [lang [:ar :de :en :es :fr :tr]]
      (testing (str "Testing language: " lang)
        (let [adverb (random-adverb lang)]
          ;; Test that the adverb is valid for the specified language
          (is (some #(= adverb %) (get adverbs-data lang))
              (str "Adverb should be valid for language " lang)))))

    ;; Test unsupported language
    (testing "Unsupported language"
      (is (thrown? IllegalArgumentException (random-adverb :unsupported))))))

;; Run tests
;; (run-tests)
