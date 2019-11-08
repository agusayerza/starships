package edu.austral.starship.scala.entity.bullet

import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.abstracts.AbstractModel
import edu.austral.starship.scala.entity.asteroid.AsteroidModel
import edu.austral.starship.scala.entity.starship.StarshipModel
import edu.austral.starship.scala.entity.traits.Collidable

class BulletModel(cposition: Vector2, val direction: Vector2 = Vector2.UP, val shooterId: Int = 0) extends AbstractModel(cposition: Vector2){
  speed = direction

  override var colliderWidth: Float = 10
  override var colliderHeight: Float = 10

  override def collisionedWith(collisionable: Collidable): Unit = collisionable.collideWith(this)

  override def collideWith(collidable: AsteroidModel): Unit = destroyMe()

  override def collideWith(collidable: StarshipModel): Unit = {
    if(collidable.playerID != this.shooterId) destroyMe()
  }
}
