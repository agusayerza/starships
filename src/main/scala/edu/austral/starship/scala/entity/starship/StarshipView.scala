package edu.austral.starship.scala.entity.starship

import edu.austral.starship.scala.entity.abstracts.AbstractView

class StarshipView(model: StarshipModel) extends AbstractView(Array("starship-fire.png", "starship.png"), model, 50, 50){
  override def updateObserver(): Unit = {
    super.updateObserver()
    renderView(0) = model.speed.y != 0 || model.speed.x != 0
  }
}
