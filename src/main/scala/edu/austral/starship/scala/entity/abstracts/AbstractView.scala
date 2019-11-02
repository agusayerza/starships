package edu.austral.starship.scala.entity.abstracts

import edu.austral.starship.scala.CustomGameFramework
import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.Renderable
import edu.austral.starship.scala.entity.traits.Observer

abstract class AbstractView(fileNames: Array[String], abstractModel: AbstractModel, val height: Float, val width: Float) extends Renderable(CustomGameFramework.imageManager.loadImages(fileNames)) with Observer {
  abstractModel.addObserver(this)
  var position: Vector2 = abstractModel.position
  var rotation: Float = abstractModel.rotation

  var renderView: Array[Boolean] = Array.fill(fileNames.length) (true)

  def updateObserver(): Unit = {
    this.position = abstractModel.position
    this.rotation = abstractModel.rotation
  }


}
