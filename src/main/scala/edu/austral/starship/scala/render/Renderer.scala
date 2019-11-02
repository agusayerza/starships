package edu.austral.starship.scala.render

import edu.austral.starship.scala.entity.abstracts.AbstractView
import processing.core.PGraphics

object Renderer {
  def render(graphics: PGraphics, abstractView: AbstractView): Unit ={
    graphics.imageMode(3)
    graphics.pushMatrix()
    graphics.translate(abstractView.position.x, abstractView.position.y)
    graphics.rotate(abstractView.rotation)
    abstractView.graphic.foreach(g => {
      if(g.draw) graphics.image(g.image, 0, 0, g.width, g.height)
    })
    graphics.popMatrix()
  }
}
