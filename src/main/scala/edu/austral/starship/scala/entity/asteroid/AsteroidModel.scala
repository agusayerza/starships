package edu.austral.starship.scala.entity.asteroid

import edu.austral.starship.scala.Screen
import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.abstracts.AbstractModel
import edu.austral.starship.scala.entity.starship.StarshipModel
import edu.austral.starship.scala.entity.traits.Collidable
import edu.austral.starship.scala.util.RandomUtils

class AsteroidModel(created_position: Vector2) extends AbstractModel(created_position: Vector2){
  speed  = Vector2(RandomUtils.randomFloat(-1,1), RandomUtils.randomFloat(-1,1))

  override def collisionedWith(collisionable: Collidable): Unit = collisionable.collideWith(this)

  override def collideWith(collidable: StarshipModel): Unit = {
    destroyMe()
  }

  override def update(time: Float): Unit = {
    super.update(time)
    rotate(speed.module / 3)
    if(Screen.farFarAway(this.position)){
      destroyMe()
    }
  }

  override var colliderWidth: Float = 40
  override var colliderHeight: Float = 40
}
