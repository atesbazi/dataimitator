(ns dataimitator.geometry.core-test
  (:require [clojure.test :refer :all]
            [dataimitator.geometry.core :refer :all]))

(deftest test-calculate-circle
  (testing "calculate-circle"
    (let [radius 5
          circle (calculate-circle radius)]
      (is (= "circle" (:type circle)))
      (is (= radius (:radius circle)))
      (is (= (* Math/PI (* radius radius)) (:area circle)))
      (is (= (* 2 Math/PI radius) (:perimeter circle))))))

(deftest test-calculate-rectangle
  (testing "calculate-rectangle"
    (let [length 4
          width 3
          rectangle (calculate-rectangle length width)]
      (is (= "rectangle" (:type rectangle)))
      (is (= length (:length rectangle)))
      (is (= width (:width rectangle)))
      (is (= (* length width) (:area rectangle)))
      (is (= (* 2 (+ length width)) (:perimeter rectangle))))))

(deftest test-calculate-square
  (testing "calculate-square"
    (let [side 4
          square (calculate-square side)]
      (is (= "square" (:type square)))
      (is (= side (:side square)))
      (is (= (* side side) (:area square)))
      (is (= (* 4 side) (:perimeter square))))))

(deftest test-calculate-cube
  (testing "calculate-cube"
    (let [side 3
          cube (calculate-cube side)]
      (is (= "cube" (:type cube)))
      (is (= side (:side cube)))
      (is (= (* side side side) (:volume cube)))
      (is (= (* 6 (* side side)) (:surface-area cube))))))

(deftest test-calculate-triangle
  (testing "calculate-triangle"
    (let [base 4
          height 3
          triangle (calculate-triangle base height)]
      (is (= "triangle" (:type triangle)))
      (is (= base (:base triangle)))
      (is (= height (:height triangle)))
      (is (= (/ (* base height) 2) (:area triangle)))
      (is (= (* 3 base) (:perimeter triangle))))))

(deftest test-random-shape
  (testing "random-shape"
    (let [shape (random-shape)]
      (is (some #{(:type shape)} shapes))
      (is (contains? shape :area))
      (cond
        (= "circle" (:type shape))
        (do (is (contains? shape :radius))
            (is (contains? shape :perimeter)))

        (= "rectangle" (:type shape))
        (do (is (contains? shape :length))
            (is (contains? shape :width))
            (is (contains? shape :perimeter)))

        (= "square" (:type shape))
        (do (is (contains? shape :side))
            (is (contains? shape :perimeter)))

        (= "cube" (:type shape))
        (do (is (contains? shape :side))
            (is (contains? shape :volume))
            (is (contains? shape :surface-area)))

        (= "triangle" (:type shape))
        (do (is (contains? shape :base))
            (is (contains? shape :height))
            (is (contains? shape :perimeter)))))))

;; Run all tests
;; (run-tests)
