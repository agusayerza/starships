package edu.austral.starship.scala.entity.asteroid

import java.awt.Shape
import java.awt.geom.Ellipse2D

import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.abstracts.AbstractModel
import edu.austral.starship.scala.entity.starship.StarshipModel
import edu.austral.starship.scala.entity.traits.Collidable
import edu.austral.starship.scala.util.RandomUtils

class AsteroidModel(position: Vector2) extends AbstractModel(position: Vector2){
  speed  = Vector2(RandomUtils.randomFloat(-1,1), RandomUtils.randomFloat(-1,1))

  override def collisionedWith(collisionable: Collidable): Unit = collisionable.collideWith(this)

  override def collideWith(collidable: StarshipModel): Unit = {
    destroyMe()
  }
}
