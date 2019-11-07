package edu.austral.starship.scala.entity.asteroid

import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.EntityManager
import edu.austral.starship.scala.entity.abstracts.{AbstractController, AbstractSpawner}

object AsteroidFactory extends AbstractSpawner(5000){

  def make(position: Vector2): AsteroidController = {
    var model: AsteroidModel = new AsteroidModel(position)
    var view: AsteroidView = new AsteroidView(model)
    val controller: AsteroidController = new AsteroidController(model, view)
    EntityManager.addController(controller)
    controller

  }

}
