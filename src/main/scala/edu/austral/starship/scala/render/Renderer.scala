package edu.austral.starship.scala.render

import edu.austral.starship.scala.entity.abstracts.AbstractView
import edu.austral.starship.scala.entity.starship.{StarshipController, StarshipModel}
import processing.core.PGraphics

import scala.collection.mutable

object Renderer {
  def renderPoints(graphics: PGraphics, players: mutable.MutableList[StarshipController]): Unit = {
    graphics.text("Points: ", 15, 15)
    val x = 20
    var y = 30
    players.map(c => c.model.asInstanceOf[StarshipModel]).foreach(model => {
      graphics.text("Player " + model.playerID + ": " + model.points, x, y)
      y += 15
    })
  }

  val renderColliders = false
  def render(graphics: PGraphics, view: AbstractView): Unit ={
    graphics.imageMode(3)
    graphics.pushMatrix()
    graphics.translate(view.position.x, view.position.y)
    graphics.rotate(view.rotation)
    if(renderColliders) graphics.ellipse(0, 0, view.model.colliderWidth, view.model.colliderHeight)
    view.graphic.foreach(g => if(g.draw) graphics.image(g.image, 0, 0, g.width, g.height))
    graphics.popMatrix()
  }
}
