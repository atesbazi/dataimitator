(ns dataimitator.helper.utils
  (:require [clojure.core]
            [clojure.string :as str])
  (:import (java.util Arrays Collections Random UUID)))

(defn random-in-range
  "Generates a random integer between lower and upper bounds (inclusive)."
  [lower upper]
  (if (<= lower upper)
    (+ lower (rand-int (inc (- upper lower))))
    (throw (IllegalArgumentException. "Lower bound must be less than or equal to upper bound"))))

(defn random-long-in-range
  "Generates a random integer between lower and upper bounds (inclusive)."
  [lower upper]
  (if (<= lower upper)
    (let [random (Random.)
          range (inc (- upper lower))]
      (+ lower (mod (.nextLong random) range)))
    (throw (IllegalArgumentException. "Lower bound must be less than or equal to upper bound"))))

(defn random-int
  "Generates a random integer between -128 and 127 (inclusive)."
  []
  (- (rand-int 256) 128))

(defn random-with-max
  "Generates a random integer between 0 (inclusive) and max (exclusive)."
  [max]
  (if (>= max 0)
    (rand-int max)
    (throw (IllegalArgumentException. "Max bound must be greater than or equal to zero"))))

(defn random-with
  "Generates a random integer with the given bound. Throws an exception if the bound is non-positive."
  [bound]
  (if (<= bound 0)
    (throw (IllegalArgumentException. "Bound must be greater than zero"))
    (rand-int bound)))

(defn random-ints [n max]
  "Generates a sequence of random integers less than a specified maximum value."
  (repeatedly n #(random-with-max max)))

(defn random-choice
  "Selects a random element from a given collection."
  [coll]
  (nth coll (random-in-range 0 (dec (count coll)))))

(defn shuffle-coll
  "Randomly shuffles the elements of a collection."
  [coll]
  (let [arr (into-array coll)]
    (Collections/shuffle (Arrays/asList arr))
    (vec arr)))

(defn random-string
  "Generates a random string of the specified length from a given character set."
  [length charset]
  (apply str (repeatedly length #(random-choice charset))))

(defn random-alphanumeric [length]
  "Generate a random alphanumeric string of given length."
  (apply str (repeatedly length #(rand-nth (str/join (concat (range 48 58) (range 65 91)))))))