package edu.austral.starship.scala.entity.abstracts

import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.Renderable
import edu.austral.starship.scala.entity.traits.Observer
import edu.austral.starship.scala.render.GraphicResource

abstract class AbstractView(graphics: Array[GraphicResource], val model: AbstractModel) extends Renderable(graphics) with Observer {
  model.addObserver(this)
  var position: Vector2 = model.position
  var rotation: Float = model.rotation

  def updateObserver(): Unit = {
    this.position = model.position
    this.rotation = model.rotation
  }


}
