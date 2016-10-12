(ns cljs-reagent.core
  (:require [reagent.core :as r] [clojure.browser.repl :as repl]))

;; (defonce conn
;;   (repl/connect "http://localhost:9000/repl"))

(enable-console-print!)

(defonce values
	[
		[(r/atom 0) (r/atom 0) (r/atom 0)]
		[(r/atom 0) (r/atom 0) (r/atom 0)]
		[(r/atom 0) (r/atom 0) (r/atom 0)]])

(defn validate [])

(defn make-move []
	)

(defn on-click-cell [value]
	(make-move
		reset! value 1))

(defn cell [value]
	[:td.cell
		{:on-click #(on-click-cell)}  "What if the cell was already clicked?"
		(if (= @value 1) "X" "-")])

(defn row [values]
	[:tr.row
		(for [val values]
			^{:key (:id val)}
			[cell val])])

(defn table [values]
	[:table.table
		{:cell-padding "0" :cell-spacing "0"}
		[:tbody
			(for [val values]
				^{:key (:id val)}
				[row val])]])

(defn app []
  [:div.container
  	[:h1.title "Tic Tac Toe!"]
		[:h2.description "♥ ClojureScript and Reagent. Huzzah!"]
  	[table values]])


((defn main []
  (r/render-component [app]
    (js/document.getElementById "app"))))
