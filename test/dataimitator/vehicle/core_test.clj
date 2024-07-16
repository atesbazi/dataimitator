(ns dataimitator.vehicle.core-test
  (:require [clojure.test :refer :all]
            [dataimitator.vehicle.core :refer :all]))

(deftest test-random-vehicle
  (testing "Random vehicle generation"
    (let [vehicle (random-vehicle)]
      ;; Test that vehicle is a map
      (is (map? vehicle) "Generated vehicle should be a map")
      ;; Test that the vehicle has all required keys
      (is (contains? vehicle :type) "Vehicle should have a type")
      (is (contains? vehicle :model) "Vehicle should have a model")
      (is (contains? vehicle :color) "Vehicle should have a color")
      (is (contains? vehicle :year) "Vehicle should have a year")
      (is (contains? vehicle :fuel) "Vehicle should have a fuel")
      (is (contains? vehicle :manufacturer) "Vehicle should have a manufacturer")
      ;; Test that each attribute is valid
      (is (some #(= (:type vehicle) %) vehicle-types) "Type should be a valid vehicle type")
      (is (some #(= (:model vehicle) %) vehicle-models) "Model should be a valid vehicle model")
      (is (some #(= (:color vehicle) %) vehicle-colors) "Color should be a valid vehicle color")
      (is (some #(= (:year vehicle) %) vehicle-years) "Year should be a valid vehicle year")
      (is (some #(= (:fuel vehicle) %) vehicle-fuels) "Fuel should be a valid vehicle fuel type")
      (is (some #(= (:manufacturer vehicle) %) vehicle-manufacturers) "Manufacturer should be a valid vehicle manufacturer"))))

;; Run tests
;; (run-tests)
