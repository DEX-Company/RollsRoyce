(ns rollsroyce.utils
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io])
  (:require [starfish.core :as sf :refer :all]))

(defn read-csv [a]
  (with-open [reader (io/reader (content-stream a))]
    (doall
      (csv/read-csv reader))))
