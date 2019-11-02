package edu.austral.starship.scala.input

import edu.austral.starship.scala.input.PlayerAction.PlayerAction

trait KeyConfiguration {
  def setKeys(keys: Set[Int]): Unit
  def getActions: Set[PlayerAction]
}
