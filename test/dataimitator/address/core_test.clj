(ns dataimitator.address.core-test
  (:require [clojure.test :refer :all]
            [dataimitator.address.core :refer [random-address]]))

(deftest test-random-address
  []
  (testing "Test random address generation"
    (let [en-address (random-address :en)
          de-address (random-address :de)
          es-address (random-address :es)
          fr-address (random-address :fr)
          ar-address (random-address :ar)
          tr-address (random-address :tr)]
      ;; Assertions for English address
      (is (string? (:street en-address)))
      (is (string? (:city en-address)))
      (is (string? (:state en-address)))
      (is (string? (:postcode en-address)))
      (is (string? (:building-number en-address)))
      (is (string? (:country en-address)))
      (is (string? (:country-code en-address)))
      (is (vector? (:coordinates en-address)))

      ;; Assertions for German address
      (is (string? (:street de-address)))
      (is (string? (:city de-address)))
      (is (string? (:state de-address)))
      (is (string? (:postcode de-address)))
      (is (string? (:building-number de-address)))
      (is (string? (:country de-address)))
      (is (string? (:country-code de-address)))
      (is (vector? (:coordinates de-address)))

      ;; Assertions for Spanish address
      (is (string? (:street es-address)))
      (is (string? (:city es-address)))
      (is (string? (:state es-address)))
      (is (string? (:postcode es-address)))
      (is (string? (:building-number es-address)))
      (is (string? (:country es-address)))
      (is (string? (:country-code es-address)))
      (is (vector? (:coordinates es-address)))

      ;; Assertions for French address
      (is (string? (:street fr-address)))
      (is (string? (:city fr-address)))
      (is (string? (:state fr-address)))
      (is (string? (:postcode fr-address)))
      (is (string? (:building-number fr-address)))
      (is (string? (:country fr-address)))
      (is (string? (:country-code fr-address)))
      (is (vector? (:coordinates fr-address)))

      ;; Assertions for Arabic address
      (is (string? (:street ar-address)))
      (is (string? (:city ar-address)))
      (is (string? (:state ar-address)))
      (is (string? (:postcode ar-address)))
      (is (string? (:building-number ar-address)))
      (is (string? (:country ar-address)))
      (is (string? (:country-code ar-address)))
      (is (vector? (:coordinates ar-address)))

      ;; Assertions for Turkish address
      (is (string? (:street tr-address)))
      (is (string? (:city tr-address)))
      (is (string? (:state tr-address)))
      (is (string? (:postcode tr-address)))
      (is (string? (:building-number tr-address)))
      (is (string? (:country tr-address)))
      (is (string? (:country-code tr-address)))
      (is (vector? (:coordinates tr-address))))))

;; Run the tests
;; Run tests
(defn -main []
  (test-random-address)
  (clojure.test/run-tests))


