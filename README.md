# dataimitator
[![Clojars Project](https://img.shields.io/clojars/v/org.clojars.atesbazi/dataimitator.svg)](https://clojars.org/org.clojars.atesbazi/dataimitator)


DataImitator is a Clojure library designed to generate random words, phrases and ready-to-use data in multiple languages. It prepares data to meet your needs in many areas, from address information to finance, from person information to vehicle information.

## Features
-   **Multi-language support:** Generate random words in Arabic, German, English, Spanish, French and Turkish .
-   **Random data:** Generate random animal species, color, company data, datetime, finance, geometry, person, phone, shopping, unit, vehicle and word.

## Installation

Add the following dependency to your `project.clj` file:
```clojure
[dataimitator "0.0.2"]
```

## Usage
You can see some example uses below.

### Random Conjunctions

Generate a random conjunction in a specified language. Defaults to English if no language is specified.

```clojure
(ns example.core 
(:require [dataimitator.word.conjuction.core :refer [random-conjunction]])) 

;; Generate a random English conjunction 
(random-conjunction) 
;; => "and" 

;; Generate a random German conjunction 
(random-conjunction :de)
;; => "aber"
```

### Random Nouns

Generate a random noun in a specified language. Defaults to English if no language is specified.

```clojure
(ns example.core
  (:require [dataimitator.word.noun.core :refer [random-noun]]))

;; Generate a random English noun
(random-noun)
;; => "car"

;; Generate a random Spanish noun
(random-noun :es)
;; => "coche"
```

### Random Prepositions

Generate a random preposition in a specified language. Defaults to English if no language is specified.

```clojure
(ns example.core
  (:require [dataimitator.word.preposition.core :refer [random-preposition]]))

;; Generate a random English preposition
(random-preposition)
;; => "in"

;; Generate a random French preposition
(random-preposition :fr)
;; => "à"
```

### Random Verbs
Generate a random verb in a specified language. Defaults to English if no language is specified.

```clojure
(ns example.core
  (:require [dataimitator.word.verb.core :refer [random-verb]]))

;; Generate a random English verb
(random-verb)
;; => "run"

;; Generate a random Turkish verb
(random-verb :tr)
;; => "çalışmak"
```

### Random Lorem Ipsum Text
Generate random lorem ipsum text with a specified number of words.

```clojure
(ns example.core
  (:require [dataimitator.word.lorem.core :refer [random-lorem-ipsum]]))

;; Generate random lorem ipsum text with 50 words
(random-lorem-ipsum 50)
;; => "Lorem ipsum dolor sit amet consectetur adipiscing elit..."

;; Generate random lorem ipsum text with 100 words
(random-lorem-ipsum 100)
;; => "Lorem ipsum dolor sit amet consectetur adipiscing elit..."
```

## License

Licensed under the EPL.

Copyright © 2024 

