package edu.austral.starship.scala.entity.starship

import edu.austral.starship.scala.CustomGameFramework
import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.abstracts.AbstractController
import edu.austral.starship.scala.entity.traits.Factory
import edu.austral.starship.scala.input.{KeyConfiguration, KeyConfigurationImpl}

object StarshipFactory extends Factory[AbstractController]{

  def make(position: Vector2, direction: Vector2 , keyConfigurationImpl: KeyConfiguration, id: Int): StarshipController = {
    var model: StarshipModel = new StarshipModel(position, direction, id)
    var view: StarshipView = new StarshipView(model)
    val keyConfiguration: KeyConfiguration = keyConfigurationImpl
    CustomGameFramework.registerKeyListener(keyConfiguration)
    new StarshipController(model, view, keyConfiguration)
  }

  override def make(position: Vector2): AbstractController = {
    var model: StarshipModel = new StarshipModel(position, Vector2.UP, 0)
    var view: StarshipView = new StarshipView(model)
    val keyConfiguration: KeyConfiguration = KeyConfigurationImpl.defaultPlayer1Configuration
    CustomGameFramework.registerKeyListener(keyConfiguration)
    new StarshipController(model, view, keyConfiguration)
  }
}
