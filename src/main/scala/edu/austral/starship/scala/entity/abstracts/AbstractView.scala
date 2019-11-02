package edu.austral.starship.scala.entity.abstracts

import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.Renderable
import edu.austral.starship.scala.entity.traits.Observer
import edu.austral.starship.scala.render.GraphicResource

abstract class AbstractView(graphics: Array[GraphicResource] , abstractModel: AbstractModel) extends Renderable(graphics) with Observer {
  abstractModel.addObserver(this)
  var position: Vector2 = abstractModel.position
  var rotation: Float = abstractModel.rotation

  def updateObserver(): Unit = {
    this.position = abstractModel.position
    this.rotation = abstractModel.rotation
  }


}
