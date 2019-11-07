package edu.austral.starship.scala.entity.powerup

import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.abstracts.AbstractModel
import edu.austral.starship.scala.entity.bullet.BulletModel
import edu.austral.starship.scala.entity.starship.StarshipModel
import edu.austral.starship.scala.entity.traits.Collidable
import edu.austral.starship.scala.util.RandomUtils

class PowerUpModel(cposition: Vector2) extends AbstractModel(cposition: Vector2){
  speed  = Vector2(RandomUtils.randomFloat(-1,1), RandomUtils.randomFloat(-1,1))
  override var colliderWidth: Float = 40
  override var colliderHeight: Float = 40

  override def collisionedWith(collisionable: Collidable): Unit = collisionable.collideWith(this)

  override def collideWith(collidable: StarshipModel): Unit = destroyMe()

  override def collideWith(collidable: BulletModel): Unit = destroyMe()

}
