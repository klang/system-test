(ns my.quartzite-service
  (:require [clojurewerkz.quartzite.scheduler :as qs]
            [clojurewerkz.quartzite.triggers :as t]
            [clojurewerkz.quartzite.jobs :as j])
  (:use [clojurewerkz.quartzite.jobs :only [defjob]]
        [clojurewerkz.quartzite.schedule.simple 
         :only [schedule with-repeat-count 
                with-interval-in-milliseconds 
                with-interval-in-minutes 
                with-interval-in-seconds]]))
 
(defjob NoOpJob
  [ctx]
  (println "Does nothing"))
 
(defn -main
  [& m]
  (qs/initialize)
  (qs/start)
  (let [job (j/build
              (j/of-type NoOpJob)
              (j/with-identity (j/key "jobs.noop.1")))
        tk      (t/key "triggers.1")
        trigger (t/build
                  (t/with-identity tk)
                  (t/start-now)
                  (t/with-schedule (schedule
                                     (with-repeat-count 10)
                                     (with-interval-in-milliseconds 200))))]
  ;; submit for execution
  (qs/schedule job trigger)
  ;; and immediately unschedule the trigger
  (qs/unschedule-job tk)))

;(-main)