(ns dataimitator.geometry.core
  (:require [dataimitator.helper.utils :refer [random-in-range]])
  (:import (java.lang Math)))

(defn calculate-circle [radius]
  {:type "circle"
   :radius radius
   :area (* Math/PI (* radius radius))
   :perimeter (* 2 Math/PI radius)})

(defn calculate-rectangle [length width]
  {:type "rectangle"
   :length length
   :width width
   :area (* length width)
   :perimeter (* 2 (+ length width))})

(defn calculate-square [side]
  {:type "square"
   :side side
   :area (* side side)
   :perimeter (* 4 side)})

(defn calculate-cube [side]
  {:type "cube"
   :side side
   :volume (* side side side)
   :surface-area (* 6 (* side side))})

(defn calculate-triangle [base height]
  {:type "triangle"
   :base base
   :height height
   :area (/ (* base height) 2)
   ;; Assuming it's an equilateral triangle for perimeter
   :perimeter (* 3 base)})

(def shapes ["circle" "rectangle" "square" "cube" "triangle"])

(defn random-shape []
  (let [shape-type (rand-nth shapes)]
    (case shape-type
      "circle" (calculate-circle (random-in-range 1 10))
      "rectangle" (calculate-rectangle (random-in-range 1 10) (random-in-range 1 10))
      "square" (calculate-square (random-in-range 1 10))
      "cube" (calculate-cube (random-in-range 1 10))
      "triangle" (calculate-triangle (random-in-range 1 10) (random-in-range 1 10)))))

;; Example usage:
(random-shape)

