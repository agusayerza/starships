package edu.austral.starship.scala

import edu.austral.starship.scala.base.framework.{GameFramework, ImageLoader, WindowSettings}
import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.abstracts.AbstractController
import edu.austral.starship.scala.entity.asteroid.AsteroidFactory
import edu.austral.starship.scala.entity.starship.StarshipFactory
import edu.austral.starship.scala.input.KeyConfiguration
import edu.austral.starship.scala.render.Renderer
import edu.austral.starship.scala.util.ImageManager
import processing.core.PGraphics
import processing.event.KeyEvent

import scala.collection.mutable

object CustomGameFramework extends GameFramework {

  var imageManager: ImageManager = _
  var imageLoader: ImageLoader = _
  var keyListeners: Set[KeyConfiguration] = mutable.HashSet().toSet

  var abstractControllers: mutable.HashSet[AbstractController] = new mutable.HashSet[AbstractController]()

  override def setup(windowsSettings: WindowSettings, imageLoader: ImageLoader): Unit = {
    imageManager = new ImageManager(imageLoader)
    this.imageLoader = imageLoader

    windowsSettings.setSize(width = Screen.width, height = Screen.height)
    abstractControllers add StarshipFactory.make(Vector2(300, 300))
    abstractControllers add AsteroidFactory.make(Vector2(200, 200))
  }

  override def draw(graphics: PGraphics, timeSinceLastDraw: Float, keySet: Set[Int]): Unit = {
    AsteroidFactory.update(timeSinceLastDraw)
    if(keySet.nonEmpty){
      var a = 1
    }

    keyListeners.foreach(listener => listener.setKeys(keySet))

    graphics.imageMode(3)

    abstractControllers.foreach(c => {
      c.update(timeSinceLastDraw)
      Renderer.render(graphics, c.view)
    })
  }

  def registerKeyListener(keyConfiguration: KeyConfiguration): Unit = {
    var listeners: mutable.HashSet[KeyConfiguration] = mutable.HashSet()
    listeners += keyConfiguration
    keyListeners.map(listener => listeners += listener)
    keyListeners = listeners.toSet
  }

  def addController(c: AbstractController) : AbstractController = {
    abstractControllers add c
    c
  }

  override def keyPressed(event: KeyEvent): Unit = {

  }

  override def keyReleased(event: KeyEvent): Unit = {

  }
}
