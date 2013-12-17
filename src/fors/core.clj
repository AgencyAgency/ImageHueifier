(ns fors.core
  (:import [java.awt Color]
           [java.awt.image BufferedImage DataBufferByte]
           [javax.imageio ImageIO]))

(defn do-for []
  (for [x [1 2 3]
        y [4 5 6]
        :when (not (= x 1))]
    [x y]))

;; Iolani Seal
(def seal-file (clojure.java.io/file "Iolani_shield.jpg"))
(defn buff-image [image-file]
  (ImageIO/read image-file))
(defn buff-seal-image []
  (buff-image seal-file))

(defn pixels [buffered-image]
    (.. buffered-image (getRaster) (getDataBuffer) (getData)))

(defn raster
  "Returns a raster of buffered image."
  [buffered-image]
  (.getRaster buffered-image))

(defn pixel
  "Returns array of r, g, b ints."
  [raster x y]
  (.getPixel raster x y nil))

(defn red [pix-rgb]
  (nth pix-rgb 0))

(defn green [pix-rgb]
  (nth pix-rgb 1))

(defn blue [pix-rgb]
  (nth pix-rgb 2))

(defn hue
  [pix-rgb]
  (first
   (Color/RGBtoHSB (red pix-rgb)
                   (green pix-rgb)
                   (blue pix-rgb)
                   nil)))
