package edu.austral.starship.scala.entity.asteroid

import edu.austral.starship.scala.entity.abstracts.AbstractView
import edu.austral.starship.scala.render.GraphicResource
import edu.austral.starship.scala.util.RandomUtils

class AsteroidView(model: AsteroidModel) extends AbstractView(
  Array(GraphicResource.loadFromFile("asteroid1.png", 80, 80, draw = true)),
  model) {

}
