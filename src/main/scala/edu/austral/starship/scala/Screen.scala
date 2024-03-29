package edu.austral.starship.scala

import edu.austral.starship.scala.base.vector.Vector2

object Screen {
  val width:Int = 1200
  val height:Int = 800
  def onScreen(point: Vector2): Boolean = 0 <= point.x && point.x <= width && point.y <= height && 0 <= point.y

  def farFarAway(point: Vector2): Boolean = {
    val x = point.x
    val y = point.y
    x < -150 || y < -150 || y > this.height + 150 || x > this.width + 150
  }

  def getWidth: Int = width

  def getHeight: Int = height

  def toScreenTop(point: Vector2): Vector2 = {
    if (onScreen(point)) return Vector2(point.x, 0)
    Vector2.ZERO
  }

  def toScreenBottom(point: Vector2): Vector2 = {
    if (onScreen(point)) {
      return Vector2(point.x, this.height)
    }
    Vector2.ZERO
  }

  def toScreenLeft(point: Vector2): Vector2 = {
    if (onScreen(point)){
      return Vector2(0, point.y)
    }
    Vector2.ZERO
  }

  def toScreenRight(point: Vector2): Vector2 = {
    if (onScreen(point)){
      return Vector2(this.width, point.y)
    }
    Vector2.ZERO
  }

}
