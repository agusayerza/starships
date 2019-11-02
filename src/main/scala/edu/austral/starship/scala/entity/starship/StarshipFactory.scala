package edu.austral.starship.scala.entity.starship

import edu.austral.starship.scala.CustomGameFramework
import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.input.{KeyConfiguration, KeyConfigurationImpl}

object StarshipFactory {
  def make(position: Vector2): StarshipController = {
    var model: StarshipModel = new StarshipModel(position)
    var view: StarshipView = new StarshipView(model)
    val keyConfiguration: KeyConfiguration = KeyConfigurationImpl.defaultConfiguration
    CustomGameFramework.registerKeyListener(keyConfiguration)
    new StarshipController(model, view, keyConfiguration)
  }
}
