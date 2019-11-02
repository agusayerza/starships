package edu.austral.starship.scala.render

import edu.austral.starship.scala.CustomGameFramework
import processing.core.PImage

object GraphicResource{
  def loadFromFile(fileName: String, width: Float, height: Float, draw: Boolean): GraphicResource = {
    val image: PImage  = CustomGameFramework.imageManager.loadImage(fileName)
    new GraphicResource(image, width, height, draw)
  }

  def loadFromFiles(fileNames: Array[String], width: Float, height: Float, draw: Boolean): Array[GraphicResource] = {
    var graphics = Array[GraphicResource]()
    fileNames.foreach(fileName => {
      graphics = graphics :+ loadFromFile(fileName, width, height, draw)
    })
    graphics
  }
}

class GraphicResource(val image: PImage, val width: Float, val height: Float, var draw: Boolean) {

}
