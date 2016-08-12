(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'cljs-reagent.core
   :output-to "out/cljs_reagent.js"
   :output-dir "out"})
