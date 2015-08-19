(ns opplz.test-generate-example
  (:require-macros
    [cemerick.cljs.test
     :refer [is deftest with-test run-tests testing test-var]]
    [clojure.test.check.clojure-test :refer [defspec]]
    )
  (:require
   [cemerick.cljs.test]
   [clojure.test.check :as tc]
   [clojure.test.check.generators :as gen]
   [clojure.test.check.properties :as prop :include-macros true]
   [clojure.string :as str])
  )

(def ^:dynamic *default-test-count* 100)

(def runs 100)

(deftest test-it
  (is (= 1 1)))

(defspec first-element-is-min-after-sorting runs
         (prop/for-all [v (gen/not-empty (gen/vector gen/int))]
                       (= (apply min v)
                          (first (sort v)))))

