(ns dataimitator.vehicle.core
  (:require [clojure.string :as str]))

(def vehicle-types ["Sedan" "SUV" "Truck" "Coupe" "Convertible" "Van" "Hatchback" "Wagon" "Sports Car"])
(def vehicle-models ["Model S" "Model X" "Model 3" "Model Y" "Mustang" "Civic" "Accord" "Corolla" "Camry" "F-150"])
(def vehicle-colors ["Red" "Blue" "Black" "White" "Silver" "Green" "Yellow" "Gray" "Orange" "Purple"])
(def vehicle-years (range 1990 2023))
(def vehicle-fuels ["Petrol" "Diesel" "Electric" "Hybrid"])
(def vehicle-manufacturers ["Toyota" "Ford" "Honda" "Chevrolet" "Tesla" "BMW" "Mercedes-Benz" "Audi" "Volkswagen" "Nissan"])

(defn random-element [coll]
  (rand-nth coll))

(defn random-vehicle []
  {:type (random-element vehicle-types)
   :model (random-element vehicle-models)
   :color (random-element vehicle-colors)
   :year (random-element vehicle-years)
   :fuel (random-element vehicle-fuels)
   :manufacturer (random-element vehicle-manufacturers)})
