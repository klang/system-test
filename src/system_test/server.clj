(ns system-test.server
  (:require 
   [swank swank])
  (:use [clojure.tools.nrepl.server :only (start-server stop-server)])
  (:gen-class))

(defn -main [& m]
  (swank.swank/start-repl 4005)
  (start-server :port 7888)
  (println "swank server started on localhost:4005")
  (println "nREPL server started on localhost:7888")

  #_(let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))
        host (.getHostAddress
              (java.net.InetAddress/getLocalHost))]
    (swank.swank/start-repl 4006 :host host)    
    (start-server :port 7889 :bind host)))




