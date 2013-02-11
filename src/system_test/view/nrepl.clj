(ns system-test.view.nrepl
  (:use [clojure.tools.nrepl.server :only (start-server stop-server)]))

;; (defonce server (start-server :port 7888))
;; (.close server)

(comment
  (require '[clojure.tools.nrepl :as repl])
  (with-open [conn (repl/connect :port 7888)]
    (-> (repl/client conn 1000)
	(repl/message {:op :eval :code "(+ 1 1)"})
	repl/response-values))

  )