package edu.austral.starship.scala.entity.starship.weapon

import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.EntityManager
import edu.austral.starship.scala.entity.bullet.{BulletController, BulletFactory}
import edu.austral.starship.scala.entity.starship.StarshipModel

class TripleShotPowerUp(cweapon: Weapon) extends WeaponPowerUp {

  override val player: StarshipModel = cweapon.player
  override val weapon: Weapon = cweapon

  override def shoot(playerPosition: Vector2, direction: Vector2): BulletController = {
    val controller: BulletController = weapon.shoot(playerPosition, direction)
    val controllerExtra: BulletController = BulletFactory.shoot(playerPosition, direction, weapon.player)
    controllerExtra.model.speed = controller.model.speed.rotate(Math.PI.asInstanceOf[Float] / 4f)
    val controllerExtra2: BulletController = BulletFactory.shoot(playerPosition, direction, weapon.player)
    controllerExtra2.model.speed = controller.model.speed.rotate(Math.PI.asInstanceOf[Float] / -4f)
    EntityManager.addController(controllerExtra)
    EntityManager.addController(controllerExtra2)
    controller
  }
}
