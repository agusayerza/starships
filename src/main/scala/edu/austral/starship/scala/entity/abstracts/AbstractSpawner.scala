package edu.austral.starship.scala.entity.abstracts

import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.EntityManager
import edu.austral.starship.scala.{CustomGameFramework, Screen, Updatable}
import edu.austral.starship.scala.entity.traits.Factory
import edu.austral.starship.scala.util.RandomUtils

abstract class AbstractSpawner(val spawnRate: Float = 1500) extends Updatable with Factory[AbstractController]{
  var nextSpawn: Float = spawnRate
  override def update(time: Float): Unit = {
    nextSpawn -= time
    if(nextSpawn <= 0f){
      spawn()
      nextSpawn = spawnRate
    }
  }

  def spawnOutsideScreen(): AbstractController ={
    val screenWidth = Screen.width
    val screenHeight = Screen.height
    var position: Vector2 = Vector2(RandomUtils.randomFloat(0, screenWidth), RandomUtils.randomFloat(0, screenHeight))
    val screenCast = RandomUtils.randomInt(0,3)

    screenCast match {
      case 0 =>
        position = Screen.toScreenTop(position)
        position = Vector2(position.x, position.y - 60)
      case 1 =>
        position = Screen.toScreenBottom(position)
        position = Vector2(position.x, position.y + 60)
      case 2 =>
        position = Screen.toScreenLeft(position)
        position = Vector2(position.x - 60, position.y)
      case 3 =>
        position = Screen.toScreenRight(position)
        position = Vector2(position.x + 60, position.y)
    }

    make(position)
  }

  def spawn(): AbstractController = {
    spawnOutsideScreen()
  }
}
