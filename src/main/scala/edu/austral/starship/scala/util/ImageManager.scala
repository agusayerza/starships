package edu.austral.starship.scala.util

import edu.austral.starship.scala.base.framework.ImageLoader
import processing.core.PImage


class ImageManager(imageLoader: ImageLoader) {
  val graphicSrc = "graphics/"
  def loadImages(fileName: Array[String]): Array[PImage] = {
    var graphics = Array[PImage]()
    fileName.foreach(
      fileNameMapped => {
        var image = imageLoader.load(graphicSrc + fileNameMapped)
        graphics = graphics :+ image
      }
    )
    graphics
  }
}
