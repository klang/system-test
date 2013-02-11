(ns timed.at-at-service
  (:use [overtone.at-at]))

(def my-pool (mk-pool))

(at (+ 1000 (now)) #(println "hello from the past!") my-pool)
(after 1000 #(println "hello from the past!") my-pool)
(stop *1)

(at (+ 10000 (now)) #(println (java.util.Date.)) my-pool)

(show-schedule my-pool)
(- (now)
   (. (java.util.Date.) getTime))

(def tp (mk-pool))
(after 10000 #(println "hello") tp :desc "Hello printer")
(every 5000 #(println "I am still alive!" (java.util.Date.)) tp :desc "Alive task")
(show-schedule tp)
(stop-and-reset-pool! tp)
(stop-and-reset-pool! tp :strategy :kill)

