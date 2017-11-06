(ns jetty-websocket-client.core
  (:require [jetty-websocket-client.socket :as socket])
  (:import (java.net URI)
           (org.eclipse.jetty.websocket.client ClientUpgradeRequest
                                               WebSocketClient)))

(def ws-uri "ws://echo.websocket.org")

(defn client-connect [dest-uri]
  (let [client (new WebSocketClient)
        socket (socket/new-socket)
        uri (new URI dest-uri)
        request (new ClientUpgradeRequest)]
    (doto client
      (.start)
      (.connect socket uri request))))

(comment
  (do
    (client-connect ws-uri)))

