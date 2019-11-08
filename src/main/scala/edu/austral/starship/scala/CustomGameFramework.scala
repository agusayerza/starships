package edu.austral.starship.scala

import edu.austral.starship.scala.base.framework.{GameFramework, ImageLoader, WindowSettings}
import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.EntityManager
import edu.austral.starship.scala.entity.abstracts.{AbstractController, AbstractModel}
import edu.austral.starship.scala.entity.asteroid.AsteroidFactory
import edu.austral.starship.scala.entity.starship.StarshipFactory
import edu.austral.starship.scala.entity.traits.Collidable
import edu.austral.starship.scala.input.{KeyConfiguration, KeyConfigurationImpl}
import edu.austral.starship.scala.render.Renderer
import edu.austral.starship.scala.util.ImageManager
import processing.core.PGraphics
import processing.event.KeyEvent

import scala.collection.mutable

object CustomGameFramework extends GameFramework {

  var imageManager: ImageManager = _
  var imageLoader: ImageLoader = _
  var keyListeners: Set[KeyConfiguration] = mutable.HashSet().toSet

  override def setup(windowsSettings: WindowSettings, imageLoader: ImageLoader): Unit = {
    imageManager = new ImageManager(imageLoader)
    this.imageLoader = imageLoader

    windowsSettings.setSize(width = Screen.width, height = Screen.height)
    EntityManager.addController(StarshipFactory.make(Vector2(Screen.width / 2.3f, Screen.height - 100), Vector2.UP, KeyConfigurationImpl.defaultPlayer1Configuration, 1))
    EntityManager.addController(StarshipFactory.make(Vector2(Screen.width / 1.7f, 100), Vector2.DOWN, KeyConfigurationImpl.defaultPlayer2Configuration, 2))

  }

  override def draw(graphics: PGraphics, timeSinceLastDraw: Float, keySet: Set[Int]): Unit = {
    keyListeners.foreach(listener => listener.setKeys(keySet))

    EntityManager.update(timeSinceLastDraw, graphics)

  }

  def registerKeyListener(keyConfiguration: KeyConfiguration): Unit = {
    var listeners: mutable.HashSet[KeyConfiguration] = mutable.HashSet()
    listeners += keyConfiguration
    keyListeners.map(listener => listeners += listener)
    keyListeners = listeners.toSet
  }

  override def keyPressed(event: KeyEvent): Unit = {

  }

  override def keyReleased(event: KeyEvent): Unit = {

  }

  def restartGame(): Unit ={
    EntityManager.clearAllEntities()
    EntityManager.addController(StarshipFactory.make(Vector2(Screen.width / 2.3f, Screen.height - 100), Vector2.UP, KeyConfigurationImpl.defaultPlayer1Configuration, 1))
    EntityManager.addController(StarshipFactory.make(Vector2(Screen.width / 1.7f, 100), Vector2.DOWN, KeyConfigurationImpl.defaultPlayer2Configuration,2))
  }
}
