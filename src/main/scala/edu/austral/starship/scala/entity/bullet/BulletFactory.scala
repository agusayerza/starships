package edu.austral.starship.scala.entity.bullet

import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.EntityManager
import edu.austral.starship.scala.entity.abstracts.AbstractController
import edu.austral.starship.scala.entity.starship.StarshipModel
import edu.austral.starship.scala.entity.traits.Factory

object BulletFactory extends Factory[AbstractController]{
  override def make(position: Vector2): BulletController = {
    var model: BulletModel = new BulletModel(position, direction = Vector2.UP, new StarshipModel(position, Vector2.UP, -1))
    var view: BulletView = new BulletView(model)
    val controller: BulletController = new BulletController(model, view)
    EntityManager.addController(controller)
    controller
  }

  def shoot(playerPosition: Vector2, direction: Vector2, player: StarshipModel): BulletController ={
    val position: Vector2 = playerPosition + direction.unitary * 10
    var model: BulletModel = new BulletModel(position, direction, player)
    var view: BulletView = new BulletView(model)
    val controller: BulletController = new BulletController(model, view)
    EntityManager.addController(controller)
    controller
  }
}
