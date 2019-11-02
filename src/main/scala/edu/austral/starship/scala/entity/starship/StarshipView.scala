package edu.austral.starship.scala.entity.starship

import edu.austral.starship.scala.entity.abstracts.AbstractView
import edu.austral.starship.scala.render.GraphicResource

class StarshipView(model: StarshipModel) extends AbstractView(

  Array(GraphicResource.loadFromFile("starship-fire.png", 100, 100, draw = false),
    GraphicResource.loadFromFile("starship.png", 100, 100, draw = true)),

  model){

  override def updateObserver(): Unit = {
    super.updateObserver()
    graphic(0).draw = model.acceleration.module != 0
  }
}
