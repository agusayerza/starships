package edu.austral.starship.scala.entity.bullet

import edu.austral.starship.scala.entity.abstracts.AbstractView
import edu.austral.starship.scala.render.GraphicResource

class BulletView(model: BulletModel) extends AbstractView(
  Array(GraphicResource.loadFromFile("asteroid0.png", 10, 10, draw = true)),
  model) {

}
