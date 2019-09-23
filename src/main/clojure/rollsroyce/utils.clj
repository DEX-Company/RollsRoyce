(ns rollsroyce.utils
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io])
  (:require [starfish.core :as sf :refer :all]))

(defn read-csv [a]
  (with-open [reader (io/reader (content-stream a))]
    (doall
      (csv/read-csv reader))))

(defn csv-string [data]
  (with-out-str (csv/write-csv *out* data)))

(defn connect-agent [base-url] 
  (let [DDO {:service 
             [{:type "Ocean.Invoke.v1"
               :serviceEndpoint (str base-url "/api/v1")}
              {:type "Ocean.Meta.v1"
               :serviceEndpoint (str base-url "/api/v1/meta")}
              {:type "Ocean.Auth.v1"
               :serviceEndpoint (str base-url "/api/v1/auth")}
              {:type "Ocean.Storage.v1"
               :serviceEndpoint (str base-url "/api/v1/assets")}]}
        DID "did:op:7d8d356b3e9bcb7222accf81bc718c521b3b7db958c7d1aa72b93424127db99b"
        DDO-STRING (sf/json-string-pprint DDO)]
    
    (sf/remote-agent (sf/did DID) DDO-STRING "Aladdin" "OpenSesame")))
