(defproject generate "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :source-paths ["src/clj" "src/cljs" "src/cljc" "test/cljs"]

  :dependencies [[org.clojure/clojure "1.7.0-RC1"]
                 [org.clojure/clojurescript "1.7.48"]
                 [org.clojure/test.check "0.8.0"]
                 [com.cemerick/double-check "0.6.1"]]

  :plugins [[lein-cljsbuild "1.0.6"]
            [com.cemerick/clojurescript.test "0.3.3"]]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target" "resources/public/cljs/test"]

  :cljsbuild
  {:builds [{:id "test"
             :source-paths ["src/cljs" "src/cljc" "test/cljs"]
             :compiler {:pretty-print true
                        :output-to "resources/public/cljs/test/generate.js"
                        :output-dir "resources/public/cljs/test"
                        :optimizations :advanced}}]}

  :main generate.core)
