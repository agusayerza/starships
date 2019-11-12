package edu.austral.starship.scala.entity.explosion

import edu.austral.starship.scala.entity.abstracts.AbstractView
import edu.austral.starship.scala.render.GraphicResource

class ExplosionView(model: ExplosionModel) extends AbstractView(
  Array(
    GraphicResource.loadFromFile("expl_06_0.png", 70, 70, draw = true),
    GraphicResource.loadFromFile("expl_06_1.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_2.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_3.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_4.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_5.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_6.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_7.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_8.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_9.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_10.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_11.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_12.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_13.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_14.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_15.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_16.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_17.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_18.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_19.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_20.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_21.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_22.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_23.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_24.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_25.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_26.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_27.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_28.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_29.png", 70, 70, draw = false),
    GraphicResource.loadFromFile("expl_06_30.png", 70, 70, draw = false),
  ),
  model){

  override def updateObserver(): Unit = {
    super.updateObserver()
    val i = model.index
    if(i != 0) graphic.update(i-1, GraphicResource.loadFromFile("expl_06_" + (i-1) + ".png", 70, 70, draw = false))
    graphic.update(i, GraphicResource.loadFromFile("expl_06_" + i + ".png", 70, 70, draw = true))
  }
}
