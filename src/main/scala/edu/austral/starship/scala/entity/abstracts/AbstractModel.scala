package edu.austral.starship.scala.entity.abstracts

import java.awt.Shape
import java.awt.geom.{AffineTransform, Ellipse2D}

import edu.austral.starship.scala.{Screen, Updatable}
import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.traits.{Collidable, Observable}

abstract class AbstractModel(var position: Vector2)  extends Updatable with Observable with Collidable {
  var alive = true
  var rotation: Float = 0
  var speed: Vector2 = Vector2(0,0)
  var acceleration: Vector2 = Vector2(0,0)
  var colliderWidth : Float
  var colliderHeight : Float

  def translate(speed: Vector2): Unit = position += speed

  def rotate(angle: Float): Unit = rotation += angle

  def destroyMe(): Unit = this.alive = false

  override def getShape: Shape = new Ellipse2D.Float(position.x, position.y, colliderWidth, colliderHeight)

  override def update(time: Float): Unit = {
    notifyObserver()
    speed += acceleration
    translate(speed)
    if(Screen.farFarAway(this.position)){
      destroyMe()
    }
  }

  def accelerate(amountToAccelerate: Vector2): Unit = {
    acceleration = amountToAccelerate
  }

}
