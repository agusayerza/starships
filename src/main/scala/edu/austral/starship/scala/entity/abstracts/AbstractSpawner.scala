package edu.austral.starship.scala.entity.abstracts

import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.{CustomGameFramework, Screen, Updatable}
import edu.austral.starship.scala.entity.traits.Factory
import edu.austral.starship.scala.util.RandomUtils

abstract class AbstractSpawner(val spawnRate: Float = 1500) extends Updatable with Factory[AbstractController]{
  var nextSpawn: Float = spawnRate
  val screen: Screen = CustomGameFramework.screen
  override def update(time: Float): Unit = {
    nextSpawn -= time
    if(nextSpawn <= 0f){
      spawn()
      nextSpawn = spawnRate
    }
  }

  def spawnOutsideScreen(): AbstractController ={
    val screenWidth = screen.width
    val screenHeight = screen.height
    var position: Vector2 = Vector2(RandomUtils.randomFloat(0, screenWidth), RandomUtils.randomFloat(0, screenHeight))
    val screenCast = RandomUtils.randomInt(0,3)

    screenCast match {
      case 0 =>
        position = screen.toScreenTop(position)
        position = Vector2(position.x, position.y - 100)
      case 1 =>
        position = screen.toScreenBottom(position)
        position = Vector2(position.x, position.y + 100)
      case 2 =>
        position = screen.toScreenLeft(position)
        position = Vector2(position.x - 100, position.y)
      case 3 =>
        position = screen.toScreenRight(position)
        position = Vector2(position.x + 100, position.y)
    }

    CustomGameFramework.addController(make(position))
  }

  def spawn(): AbstractController = {
    spawnOutsideScreen()
  }
}
