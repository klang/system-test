(defproject system-test "0.1.0-SNAPSHOT"
  :description "long term REPL usage to perform system testing"
  :url "http://clojure.lang.dk"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
		 ;; web-view
		 [ring "1.1.0"]
		 [compojure "1.0.2"]
		 [hiccup "1.0.0"]

		 ;; info collection
		 [clj-time "0.4.4"]
		 [clj-ssh "0.4.3"]
		 [org.clojure/tools.cli "0.2.2"]
                 [overtone/at-at "1.1.1"]
                 [tron "0.5.3"]
                 [cronj "0.6.1"]

                 ;; quartzite
                 [org/slf4j/slf4j-api "1.7.2"]
                 [org/slf4j/slf4j-simple "1.7.2"]
                 [clojurewerkz/quartzite "1.0.1"]

		 ;; repl-view
		 [org.clojure/tools.nrepl "0.2.0-RC1"]
		 [swank-clojure "1.4.0-SNAPSHOT"]
		 ]
  :plugins [[lein-swank "1.4.1"]]
  :min-lein-version "2.0.0"
  :main system-test.server 
  )

