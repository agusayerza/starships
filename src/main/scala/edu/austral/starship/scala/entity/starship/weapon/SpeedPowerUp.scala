package edu.austral.starship.scala.entity.starship.weapon
import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.bullet.BulletController

class SpeedPowerUp(cweapon: Weapon) extends WeaponPowerUp {
  override val weapon: Weapon = cweapon

  override def shoot(playerPosition: Vector2, direction: Vector2): BulletController = {
    val controller: BulletController = weapon.shoot(playerPosition, direction)
    controller.changeSpeed(controller.model.speed * 2)
    controller
  }
}
