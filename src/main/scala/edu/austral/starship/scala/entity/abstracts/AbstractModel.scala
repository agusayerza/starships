package edu.austral.starship.scala.entity.abstracts

import edu.austral.starship.scala.Updatable
import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.traits.Observable

abstract class AbstractModel(var position: Vector2)  extends Updatable with Observable {
  var alive = true
  var rotation: Float = 0
  var speed: Vector2 = Vector2(0,0)
  var acceleration: Vector2 = Vector2(0,0)
  def translate(speed: Vector2): Unit = position += speed

  def rotate(angle: Int): Unit = rotation += angle


  override def update(time: Float): Unit = {
    notifyObserver()
    speed += acceleration
    translate(speed)
  }

  def accelerate(amountToAccelerate: Vector2): Unit = {
    acceleration = amountToAccelerate
  }

}
