package edu.austral.starship.scala.entity.starship

import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.abstracts.AbstractModel
import edu.austral.starship.scala.input.PlayerAction
import edu.austral.starship.scala.input.PlayerAction.PlayerAction

class StarshipModel(position: Vector2) extends AbstractModel(position){


  override def update(time: Float): Unit = {
    super.update(time)
    acceleration = acceleration * Math.pow(0.90, time).asInstanceOf[Float]
    speed = speed * Math.pow(0.999, time).asInstanceOf[Float]
    if(acceleration.module < 0.05f) acceleration = Vector2.ZERO
  }

  def processPlayerActions(actions: Set[PlayerAction], time: Float): Unit = {
    var move: Vector2 = Vector2.ZERO
    if (actions.contains(PlayerAction.UP)) move = move + Vector2.UP
    if (actions.contains(PlayerAction.DOWN)) move = move + Vector2.DOWN
    if (actions.contains(PlayerAction.LEFT)) move = move + Vector2.LEFT
    if (actions.contains(PlayerAction.RIGHT)) move = move + Vector2.RIGHT
    if (!(move == Vector2.ZERO)) move = move.unitary
    if (speed.module < 15) accelerate(move)
  }
}
