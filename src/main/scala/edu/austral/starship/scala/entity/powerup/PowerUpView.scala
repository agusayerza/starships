package edu.austral.starship.scala.entity.powerup

import edu.austral.starship.scala.entity.abstracts.AbstractView
import edu.austral.starship.scala.render.GraphicResource

class PowerUpView(model: PowerUpModel) extends AbstractView(
  Array(GraphicResource.loadFromFile("powerup.png", 80, 80, draw = true)),
  model){

}
