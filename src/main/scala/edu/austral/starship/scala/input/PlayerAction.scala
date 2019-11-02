package edu.austral.starship.scala.input

object PlayerAction extends Enumeration {
  type PlayerAction = Value
  val UP, DOWN, LEFT, RIGHT, SHOOT, NONE = Value
}
