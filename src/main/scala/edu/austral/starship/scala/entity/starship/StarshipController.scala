package edu.austral.starship.scala.entity.starship

import edu.austral.starship.scala.entity.abstracts.AbstractController
import edu.austral.starship.scala.input.KeyConfiguration

class StarshipController(model: StarshipModel, view: StarshipView, keyConfiguration: KeyConfiguration) extends AbstractController(model, view) {
  override def update(time: Float): Unit = {
    super.update(time)
    model.processPlayerActions(keyConfiguration.getActions, time)
  }
}
