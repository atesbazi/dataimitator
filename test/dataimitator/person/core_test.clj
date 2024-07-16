(ns dataimitator.person.core-test
  (:require [clojure.test :refer :all]
            [dataimitator.person.core :refer :all]))

(declare thrown? thrown-with-msg?)

(deftest test-random-first-name
  (testing "Random first name generation"
    (is (some? (random-first-name)))
    (is (thrown? IllegalArgumentException (random-first-name :xx)))))

(deftest test-random-last-name
  (testing "Random last name generation"
    (is (some? (random-last-name)))
    (is (thrown? IllegalArgumentException (random-last-name :xx)))))

(deftest test-random-name
  (testing "Random full name generation"
    (is (re-find #"\s" (random-name))) ;; Should contain a space
    (is (thrown? IllegalArgumentException (random-name :xx)))))

(deftest test-random-age
  (testing "Random age generation"
    (let [age (random-age)]
      (is (>= age 18))
      (is (<= age 80)))))

(deftest test-random-email
  (testing "Random email generation"
    (let [name "John Doe"]
      (is (re-find #".+@.+\..+" (random-email name))))))

(deftest test-random-phone
  (testing "Random phone number generation"
    (is (re-find #"\+\d{1}-\d{3}-\d{3}-\d{4}" (random-phone)))))

(deftest test-random-address
  (testing "Random address generation"
    (is (re-find #"\d{1,4} .+, .+, \w{2} \d{5}" (random-address)))))

(deftest test-random-person
  (testing "Random person data generation"
    (let [person (random-person)]
      (is (some? (:name person)))
      (is (some? (:age person)))
      (is (some? (:email person)))
      (is (some? (:address person)))
      (is (some? (:phone person))))))

(deftest test-random-people
  (testing "Random people generation"
    (let [people (random-people 5)]
      (is (= 5 (count people)))
      (doseq [person people]
        (is (some? (:name person)))
        (is (some? (:age person)))
        (is (some? (:email person)))
        (is (some? (:address person)))
        (is (some? (:phone person)))))))

(deftest test-random-username
  (testing "Random username generation"
    (is (some? (random-username)))
    (is (contains? (set usernames) (random-username)))))

(deftest test-random-password
  (testing "Random password generation"
    (let [password (random-password)]
      (is (<= 8 (count password) 12))
      (is (re-find #"[a-zA-Z0-9!@#$%^&*()]" password)))))

(deftest test-random-salt
  (testing "Random salt generation"
    (is (= 24 (count (random-salt)))))) ;; Base64 encoded salt length

(deftest test-sha256
  (testing "SHA-256 hashing"
    (let [hash (sha256 "test")]
      (is (= 64 (count hash))) ;; SHA-256 produces a 64 char hex string
      (is (re-find #"[0-9a-f]+" hash))))) ;; Should be hexadecimal

(deftest test-random-user-login-data
  (testing "Random user login data generation"
    (let [login-data (random-user-login-data)]
      (is (some? (:uuid login-data)))
      (is (some? (:username login-data)))
      (is (some? (:password login-data)))
      (is (some? (:salt login-data)))
      (is (some? (:sha256 login-data)))
      (is (= 64 (count (:sha256 login-data))))))) ;; SHA-256 hash length

;; Run the tests
;; (run-tests)
