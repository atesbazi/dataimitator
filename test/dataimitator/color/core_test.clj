(ns dataimitator.color.core-test
  (:require [clojure.test :refer :all]
            [dataimitator.color.core :refer :all]))

(declare thrown? thrown-with-msg?)

(deftest test-random-color
  (testing "random-color"
    (is (some #{(random-color :en)} (get color-names :en)))
    (is (some #{(random-color :de)} (get color-names :de)))
    (is (some #{(random-color :ar)} (get color-names :ar)))
    (is (thrown? IllegalArgumentException (random-color :unsupported)))))

(deftest test-random-hex-color
  (testing "random-hex-color"
    (is (re-matches #"#[0-9A-F]{6}" (random-hex-color)))))

(deftest test-random-rgb-color
  (testing "random-rgb-color"
    (let [[r g b] (random-rgb-color)]
      (is (and (integer? r) (<= 0 r 255)))
      (is (and (integer? g) (<= 0 g 255)))
      (is (and (integer? b) (<= 0 b 255))))))

(deftest test-random-hsl-color
  (testing "random-hsl-color"
    (let [[h s l] (random-hsl-color)]
      (is (and (number? h) (<= 0.0 h 1.0)))
      (is (and (number? s) (<= 0.0 s 1.0)))
      (is (and (number? l) (<= 0.0 l 1.0))))))

(deftest test-harmonious-color
  (testing "harmonious-color"
    (is (re-matches #"#[0-9A-F]{6}" (harmonious-color "#FF0000" 1)))
    (is (re-matches #"#[0-9A-F]{6}" (harmonious-color "#00FF00" -1)))
    (is (re-matches #"#[0-9A-F]{6}" (harmonious-color "#0000FF" 2)))))

(deftest test-random-harmonious-color-palette
  (testing "random-harmonious-color-palette"
    (let [palette (random-harmonious-color-palette)]
      (is (= 5 (count palette)))
      (doseq [color palette]
        (is (re-matches #"#[0-9A-F]{6}" color))))))

;;(run-tests)
