package edu.austral.starship.scala.entity.starship.weapon
import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.bullet.{BulletController, BulletFactory}
import edu.austral.starship.scala.entity.starship.StarshipModel

class SimpleWeapon(val cplayer: StarshipModel) extends Weapon {

  override val player: StarshipModel = cplayer

  override def shoot(playerPosition: Vector2, direction: Vector2): BulletController = {
    BulletFactory.shoot(playerPosition, direction * 1.5f, player)
  }
}
