package edu.austral.starship.scala.render

import edu.austral.starship.scala.entity.abstracts.AbstractView
import processing.core.PGraphics

object Renderer {
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
