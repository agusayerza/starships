package edu.austral.starship.scala

import edu.austral.starship.scala.base.vector.Vector2

class Screen(val width:Int, val height:Int) {

  def onScreen(point: Vector2): Boolean = 0 <= point.x && point.x >= width && point.y >= height && 0 <= point.y

}
