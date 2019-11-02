package edu.austral.starship.scala.entity

import edu.austral.starship.scala.Updatable
import edu.austral.starship.scala.entity.asteroid.AsteroidFactory

class EntityManager extends Updatable {

  override def update(time: Float): Unit = {
    AsteroidFactory.update(time)
  }
}
