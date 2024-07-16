(ns dataimitator.word.conjuction.core-test
  (:require [clojure.test :refer :all]
            [dataimitator.word.conjuction.core :refer :all]))

(declare thrown? thrown-with-msg?)

(deftest test-random-conjunction
  (testing "Random conjunction generation"
    (let [conjunction (random-conjunction)]
      ;; Test that the default language is English
      (is (some #(= conjunction %) (:en conjunctions-data))
          "Default language should be English and the conjunction should be valid"))

    (doseq [lang [:ar :de :en :es :fr :tr]]
      (testing (str "Testing language: " lang)
        (let [conjunction (random-conjunction lang)]
          ;; Test that the conjunction is valid for the specified language
          (is (some #(= conjunction %) (get conjunctions-data lang))
              (str "Conjunction should be valid for language " lang)))))

    ;; Test unsupported language
    (testing "Unsupported language"
      (is (thrown? IllegalArgumentException (random-conjunction :unsupported))))))

;; Run tests
;; (run-tests)R
