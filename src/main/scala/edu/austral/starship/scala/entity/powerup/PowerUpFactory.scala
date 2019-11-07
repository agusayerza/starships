package edu.austral.starship.scala.entity.powerup

import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.EntityManager
import edu.austral.starship.scala.entity.abstracts.AbstractSpawner
import edu.austral.starship.scala.entity.traits.Factory

object PowerUpFactory extends AbstractSpawner(1000){

  override def make(position: Vector2): PowerUpController = {
    var model: PowerUpModel = new PowerUpModel(position)
    var view: PowerUpView = new PowerUpView(model)
    val controller: PowerUpController = new PowerUpController(model, view)
    EntityManager.addController(controller)
    controller
  }

}
