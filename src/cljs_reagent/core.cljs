(ns cljs-reagent.core
  (:require [reagent.core :as r] [clojure.browser.repl :as repl]))

;; (defonce conn
;;   (repl/connect "http://localhost:9000/repl"))

(enable-console-print!)

(defonce values (r/atom [[0 0 0] [0 0 0] [0 0 0]]))

(defn validate [])

(defn cell [value]
	[:td.cell {:on-click onclick}
		(if (= value 1) "X" "0")])

(defn row [row]
	[:tr.row (map cell row)])

(defn table [values]
	[:table>tbody (map row values)])

(defn app []
  [:div
		[:p "Tic Tac Toe made with ClojureScript and Reagent. Huzzah!"]
  	[table @values]])


((defn main []
  (r/render-component [app]
    (js/document.getElementById "app"))))
