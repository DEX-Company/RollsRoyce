(ns rollsroyce.demo
  (:require [starfish.core :as sf :refer :all])
  (:require [rollsroyce.utils :as utils])
  (:require [clojure.core.matrix :as m]))

(defn local-demo []
  ;; Commands in local-demo can be executed directly at the REPL
  ;; And do not require a agent instance (surfer) to be running
  ;; This mimics the functionality that might be used by a data scientist or analyst
  
  ;; Create an Asset from a file
  (def a1 
    (file-asset "IoT-data.csv"))
  
  ;; Read the contents of an asset in csv format
  (def a1-csv (utils/read-csv a1))
  
  ;; Display the csv header
  (println (first a1-csv))
  
  ;; 
  
  )