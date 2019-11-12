package edu.austral.starship.scala.entity.starship.weapon

import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.bullet.BulletController
import edu.austral.starship.scala.entity.starship.StarshipModel

trait Weapon {
  val player: StarshipModel
  def shoot(playerPosition: Vector2, direction: Vector2): BulletController

}
