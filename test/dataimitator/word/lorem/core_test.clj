(ns dataimitator.word.lorem.core-test
  (:require [clojure.test :refer :all]
            [dataimitator.word.lorem.core :refer :all]
            [clojure.string :as str]))

(deftest test-random-lorem-ipsum
  (testing "Random Lorem Ipsum text generation with specified number of words"
    (let [word-count 30
          lorem (random-lorem-ipsum word-count)]
      (is (= word-count (count (str/split lorem #" ")))))))

;; Run test
;; (run-tests)