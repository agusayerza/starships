package edu.austral.starship.scala.entity.asteroid

import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.abstracts.{AbstractController, AbstractSpawner}

object AsteroidFactory extends AbstractSpawner(1000){

  def make(position: Vector2): AsteroidController = {
    var model: AsteroidModel = new AsteroidModel(position)
    var view: AsteroidView = new AsteroidView(model)
    new AsteroidController(model, view)
  }

}
