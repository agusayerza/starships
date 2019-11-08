package edu.austral.starship.scala.entity.starship

import java.awt.Shape

import edu.austral.starship.scala.{CustomGameFramework, Screen}
import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.abstracts.AbstractModel
import edu.austral.starship.scala.entity.asteroid.AsteroidModel
import edu.austral.starship.scala.entity.bullet.{BulletFactory, BulletModel}
import edu.austral.starship.scala.entity.powerup.PowerUpModel
import edu.austral.starship.scala.entity.starship.weapon.{SimpleWeapon, SpeedPowerUp, Weapon}
import edu.austral.starship.scala.entity.traits.Collidable
import edu.austral.starship.scala.input.PlayerAction
import edu.austral.starship.scala.input.PlayerAction.PlayerAction

class StarshipModel(cposition: Vector2, val direction: Vector2, val playerID: Int) extends AbstractModel(cposition){

  override var colliderWidth: Float = 60
  override var colliderHeight: Float = 40
  val SHOOT_INTERVAL:Float = 5000
  var timeSinceLastShot: Float= 0
  var lifes: Int = 3
  rotation = direction.angle + Math.PI.asInstanceOf[Float] / 2f
  var weapon: Weapon = new SimpleWeapon(playerID)

  override def update(time: Float): Unit = {
    super.update(time)
    timeSinceLastShot = timeSinceLastShot + time
    acceleration = acceleration * Math.pow(0.90, time).asInstanceOf[Float]
    speed = speed * Math.pow(0.999, time).asInstanceOf[Float]
    if(acceleration.module < 0.05f) acceleration = Vector2.ZERO
  }

  def shoot(time: Float) : Unit = {
    if(timeSinceLastShot > SHOOT_INTERVAL){
      weapon.shoot(position, this.direction)
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

  override def collideWith(collidable: AsteroidModel): Unit = {
    looseLife()
  }

  def looseLife(): Unit ={
    this.lifes -= 1
    if(lifes <= 0){
      CustomGameFramework.restartGame()
    }
  }


  override def collideWith(collidable: BulletModel): Unit = {
    if(collidable.shooterId != this.playerID) looseLife()
  }

  override def collideWith(collidable: PowerUpModel): Unit = this.weapon = new SpeedPowerUp(this.weapon)
}
