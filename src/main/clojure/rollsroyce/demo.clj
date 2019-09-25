(ns rollsroyce.demo
  (:require [starfish.core :as sf :refer :all])
  (:require [rollsroyce.utils :as utils])
  (:require [clojure.core.matrix :as m]
            [clojure.core.matrix.dataset :as ds]))

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
  
  ;; Create an operation to compute statistics
  (def op1 (create-operation [:input]
                             (fn [{input :input}]
                               (let [csv-data (utils/read-csv input)
                                     dset (ds/dataset (first csv-data) (rest csv-data))
                                     dset (ds/emap-columns dset ["Temperature" "Pressure"] (fn [s] (Double/parseDouble ^String s)))
                                     results [["Min-temp" (m/minimum (ds/column dset "Temperature"))]
                                              ["Max-temp" (m/maximum (ds/column dset "Temperature"))]
                                              ["Min-pres" (m/minimum (ds/column dset "Pressure"))]
                                              ["Max-pres" (m/maximum (ds/column dset "Pressure"))]]]
                                 
                                 {:output (memory-asset {:contentType "text/csv"}
                                                        (utils/csv-string results)
                                                        )})
                              )))
  
  ;; Run statistics on any asset, producing a new asset
  (def stats1 (:output (invoke-result op1 a1)))
  
  ;; show the content of the analysis
  (println (utils/read-csv stats1))
 
  ;; show the metadata of the results
  (println (metadata stats1))
  
  )



(defn remote-demo []
  ;; This section of the demo interacts with an Agent to store assets and relevant metadata
  ;; To run these commands, you need an instance of surfer or another compatible Agent running.
  
  ;; create a connection to an agent. Change the base URL if required.
  (def ag1 (utils/connect-agent "http://localhost:8080"))
  
  ;; upload an asset to the surfer instance for sharing
  (def stats2 (upload ag1 stats1))
  
  ;; Get a DID to refer to the asset on the Agent
  (def did2 (did stats2))
  
  ;; Display the DID. May be shared with others to refer to the Asset.
  (println (str did2))

  ;; another user can access the asset via the DID
  (def a2 (get-asset ag1 (asset-id did2)))
  )



