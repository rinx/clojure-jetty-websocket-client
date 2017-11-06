(ns jetty-websocket-client.socket
  (:import (org.eclipse.jetty.websocket.api Session
                                            StatusCode)
           (org.eclipse.jetty.websocket.api.annotations WebSocket
                                                        OnWebSocketClose
                                                        OnWebSocketConnect
                                                        OnWebSocketMessage)))

(definterface Socket
  (^void onClose [^int statusCode ^String reason])
  (^void onConnect [^org.eclipse.jetty.websocket.api.Session session])
  (^void onMessage [^String msg]))

(deftype ^{WebSocket []} EchoSocket []
  Socket
  (^{OnWebSocketClose []} onClose [this statusCode reason]
    (println (str "Closed: "reason)))
  (^{OnWebSocketConnect []} onConnect [this session]
    (println "Connected: "))
  (^{OnWebSocketMessage []} onMessage [this msg]
    (println msg)))

(defn new-socket []
  (EchoSocket.))

