package edu.austral.starship.scala.entity.explosion

import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.EntityManager
import edu.austral.starship.scala.entity.traits.Factory

object ExplosionFactory extends Factory[ExplosionController] {
  override def make(position: Vector2): ExplosionController = {
    val model: ExplosionModel = new ExplosionModel(position)
    val view: ExplosionView = new ExplosionView(model)
    val controller: ExplosionController = new ExplosionController(model, view)
    EntityManager.addController(controller)
    controller
  }
}
