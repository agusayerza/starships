package edu.austral.starship.scala.entity.bullet

import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.abstracts.AbstractController

class BulletController(model: BulletModel, view: BulletView) extends AbstractController(model, view){
  val shooterId: Int = model.shooterId
  def changeSpeed(newSpeed: Vector2): Unit ={
    model.speed = newSpeed
  }

}
