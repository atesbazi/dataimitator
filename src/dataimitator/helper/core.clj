(ns dataimitator.helper.core
  (:require [clojure.string :as str]))

(defn round-to-two-decimals [num]
  (let [num (double num)]
    (Double/parseDouble (str/replace (format "%.2f" num) #"," "."))))