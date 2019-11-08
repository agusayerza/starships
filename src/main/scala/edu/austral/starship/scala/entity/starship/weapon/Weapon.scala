package edu.austral.starship.scala.entity.starship.weapon

import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.bullet.BulletController

trait Weapon {

  def shoot(playerPosition: Vector2, direction: Vector2): BulletController

}
