package edu.austral.starship.scala.entity.abstracts

import edu.austral.starship.scala.Updatable

abstract class AbstractController(val model: AbstractModel, val view: AbstractView) extends Updatable {

  override def update(time: Float): Unit = {
    model.update(time)
  }


}
