(ns timed.cronj-service
  (:use [clojure.java.io :only (reader)])
  (:require [cronj.core :as cj]))

(defn parse-line 
  [line] 
  (map str (.split (.toLowerCase line) " ")))

(defn record 
  [[state data]] 
  {:state state :data data})

(defn getState[]
  (->> (reader "state.txt") 
       (line-seq) 
       (map parse-line) 
       (map record) 
       first))

(def ^:dynamic *state* 
  (ref (getState)))

(cj/defcronj cnj
    :entries [{:id "opts"
               :handler (fn [dt opts] 
                          (dosync (ref-set *state* (getState))
                                  ;; get the *server-state* and the *database-state*
                                  ;; and calculate a new status (difference between the two)
                                  (println (:task-name opts) ": " dt ": " @*state*)))
               :schedule "/2 * * * * * *"
               :opts {:task-name "state from file"}}])



;;(cj/start! cnj)
;; get bored and stop
;;(cj/stop! cnj)
