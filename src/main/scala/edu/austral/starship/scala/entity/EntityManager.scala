package edu.austral.starship.scala.entity

import edu.austral.starship.scala.base.collision.CollisionEngine
import edu.austral.starship.scala.entity.abstracts.{AbstractController, AbstractModel}
import edu.austral.starship.scala.entity.asteroid.AsteroidFactory
import edu.austral.starship.scala.entity.powerup.PowerUpFactory
import edu.austral.starship.scala.entity.starship.{StarshipController, StarshipModel}
import edu.austral.starship.scala.entity.traits.Collidable
import edu.austral.starship.scala.render.Renderer
import processing.core.PGraphics

import scala.collection.mutable

object EntityManager {

  val collisionEngine: CollisionEngine[Collidable] = new CollisionEngine[Collidable]()

  var abstractControllers: mutable.HashSet[AbstractController] = new mutable.HashSet[AbstractController]()
  var models: mutable.MutableList[AbstractModel] = new mutable.MutableList[AbstractModel]()
  var players: mutable.MutableList[StarshipController] = new mutable.MutableList[StarshipController]()
  def update(time: Float, graphics: PGraphics): Unit = {
    AsteroidFactory.update(time)
    PowerUpFactory.update(time)
    collisionEngine.checkCollisions(models.toList)

    abstractControllers.foreach(c => {
      c.update(time)
      Renderer.render(graphics, c.view)
      Renderer.renderPoints(graphics, players)
    })

    deleteDeadEntities()

  }

  def addController(c: AbstractController) : AbstractController = {
    abstractControllers add c
    models += c.model
    c
  }

  def addPlayer(p: StarshipController) : AbstractController = {
    players += p
    addController(p)
  }

  def removeController(c: AbstractController) : Unit = {
    abstractControllers.remove(c)
    models = models.filterNot(c2 => c2 == c.model)
  }

  def deleteDeadEntities() : Unit = {
    abstractControllers.foreach(c => if(!c.model.alive) removeController(c))
  }

  def clearAllEntities(): Unit ={
    abstractControllers = new mutable.HashSet[AbstractController]()
    models = new mutable.MutableList[AbstractModel]()
    players = new mutable.MutableList[StarshipController]
  }
}
