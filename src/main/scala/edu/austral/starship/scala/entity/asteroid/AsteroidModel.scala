package edu.austral.starship.scala.entity.asteroid

import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.abstracts.AbstractModel
import edu.austral.starship.scala.util.RandomUtils

class AsteroidModel(position: Vector2) extends AbstractModel(position: Vector2){
  speed  = Vector2(RandomUtils.randomFloat(-1,1), RandomUtils.randomFloat(-1,1))
}
