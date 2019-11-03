package edu.austral.starship.scala.render

import edu.austral.starship.scala.entity.abstracts.AbstractView
import processing.core.PGraphics

object Renderer {
  val renderColliders = true
  def render(graphics: PGraphics, view: AbstractView): Unit ={
    graphics.imageMode(3)
    if(renderColliders){
      graphics.ellipse(view.position.x, view.position.y, view.model.colliderWidth, view.model.colliderHeight)
    }
    graphics.pushMatrix()
    graphics.translate(view.position.x, view.position.y)
    graphics.rotate(view.rotation)
    view.graphic.foreach(g => {
      if(g.draw) graphics.image(g.image, 0, 0, g.width, g.height)

    })
    graphics.popMatrix()
  }
}
