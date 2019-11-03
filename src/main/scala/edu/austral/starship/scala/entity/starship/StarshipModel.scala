package edu.austral.starship.scala.entity.starship

import java.awt.Shape

import edu.austral.starship.scala.Screen
import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.abstracts.AbstractModel
import edu.austral.starship.scala.entity.asteroid.AsteroidModel
import edu.austral.starship.scala.entity.bullet.BulletFactory
import edu.austral.starship.scala.entity.traits.Collidable
import edu.austral.starship.scala.input.PlayerAction
import edu.austral.starship.scala.input.PlayerAction.PlayerAction

class StarshipModel(cposition: Vector2) extends AbstractModel(cposition){

  override var colliderWidth: Float = 60
  override var colliderHeight: Float = 40
  val SHOOT_INTERVAL:Float = 2000
  var timeSinceLastShot: Float= 0

  override def update(time: Float): Unit = {
    super.update(time)
    timeSinceLastShot = timeSinceLastShot + time
    acceleration = acceleration * Math.pow(0.90, time).asInstanceOf[Float]
    speed = speed * Math.pow(0.999, time).asInstanceOf[Float]
    if(acceleration.module < 0.05f) acceleration = Vector2.ZERO
  }

  def shoot(time: Float) : Unit = {
    if(timeSinceLastShot > SHOOT_INTERVAL){
      BulletFactory.shoot(position, Vector2.UP)
      timeSinceLastShot = 0
    }
  }

  def processPlayerActions(actions: Set[PlayerAction], time: Float): Unit = {
    var move: Vector2 = Vector2.ZERO
    if (actions.contains(PlayerAction.SHOOT)) shoot(time)
    if (actions.contains(PlayerAction.UP)) move = move + Vector2.UP
    if (actions.contains(PlayerAction.DOWN)) move = move + Vector2.DOWN
    if (actions.contains(PlayerAction.LEFT)) move = move + Vector2.LEFT
    if (actions.contains(PlayerAction.RIGHT)) move = move + Vector2.RIGHT
    if (!(move == Vector2.ZERO)) move = move.unitary
    if (speed.module < 15) accelerate(move)
  }

  override def translate(speed: Vector2): Unit = {
    super.translate(speed)
    if(position.x < 0) position = Vector2(0, position.y)
    if(position.x > Screen.width) position = Vector2(Screen.width, position.y)
    if(position.y < 0) position = Vector2(position.x, 0)
    if(position.y > Screen.height) position = Vector2(position.x, Screen.height)
  }

  override def collisionedWith(collisionable: Collidable): Unit = {collisionable.collideWith(this)}

  override def collideWith(collidable: AsteroidModel): Unit = { /** todo: loose life **/}
}
