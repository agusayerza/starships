package edu.austral.starship.scala.entity.traits

import edu.austral.starship.scala.base.collision.Collisionable
import edu.austral.starship.scala.entity.asteroid.AsteroidModel
import edu.austral.starship.scala.entity.starship.StarshipModel

trait Collidable extends Collisionable[Collidable]{

  def collideWith(collidable: StarshipModel):Unit = {}

  def collideWith(collidable: AsteroidModel):Unit = {}

}
