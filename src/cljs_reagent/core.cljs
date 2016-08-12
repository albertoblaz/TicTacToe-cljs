(ns cljs-reagent.core
  (:require [reagent.core :as r] [clojure.browser.repl :as repl]))

;; (defonce conn
;;   (repl/connect "http://localhost:9000/repl"))

(enable-console-print!)

(defonce values (r/atom [[0 1 0] [0 0 0] [1 0 0]]))

(defn validate [])

(defn cell [value]
	[:td.cell (if (= value 1) "X" "O")])

(defn row [row]
	[:tr.row (map cell row)])

(defn table [values]
	[:table.table {:cell-padding "0" :cell-spacing "0"}
		[:tbody (map row values)]])

(defn app []
  [:div.container
  	[:h1.title "Tic Tac Toe!"]
		[:h2.description "♥ ClojureScript and Reagent. Huzzah!"]
  	[table @values]])


((defn main []
  (r/render-component [app]
    (js/document.getElementById "app"))))
