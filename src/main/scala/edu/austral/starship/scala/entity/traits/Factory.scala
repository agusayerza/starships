package edu.austral.starship.scala.entity.traits

import edu.austral.starship.scala.base.vector.Vector2

trait Factory[T] {

  def make(position: Vector2): T
}
