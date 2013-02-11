(ns timed.tron-service
  (:require tron)
)

(defn- periodic [] (println "periodic"))
(defn- ponctual [] (println "ponctual"))
(comment
;; Run the fonction 10 seconds from now
  (tron/once ponctual 10000)
(* 1000 60 30)
;; Run the periodic function every second
;; after the last call
  (tron/periodically :bar periodic 1000)

;; Run the periodic function every 10 second
  (tron/fixed-periodically :foo periodic 10000)

;; Cancel the periodic run 5 seconds from now
  (tron/once #(tron/cancel :foo) 5000)
  (tron/once #(tron/cancel :bar) 0)

;; Execute the followin expressions periodically
  (tron/do-periodically 5000
                        (println "hello"))

  )

;; can't handle starting at specific, predefined times