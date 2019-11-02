package edu.austral.starship.scala.input

import java.util
import java.util.{HashMap, Map}

import edu.austral.starship.scala.input.PlayerAction.PlayerAction
import processing.event.KeyEvent

import scala.collection.mutable

object KeyConfigurationImpl {
  def defaultConfiguration: KeyConfiguration = {
    val binds: util.Map[Integer, PlayerAction] = new util.HashMap[Integer, PlayerAction]
    binds.put(37, PlayerAction.LEFT)
    binds.put(38, PlayerAction.UP)
    binds.put(39, PlayerAction.RIGHT)
    binds.put(40, PlayerAction.DOWN)
    new KeyConfigurationImpl(binds)
  }
}

class KeyConfigurationImpl private(val keyBinds: util.Map[Integer, PlayerAction]) extends KeyConfiguration {
  var keys: Set[Int] = mutable.Set[Int]().toSet

  private def getActionForKey(keyCode: Int): PlayerAction = {
    var playerAction: PlayerAction = PlayerAction.NONE
    if (keyBinds.containsKey(keyCode)) playerAction = keyBinds.get(keyCode)
    playerAction
  }

  override def setKeys(keys: Set[Int]): Unit = this.keys = keys

  override def getActions: Set[PlayerAction] = {
    var actions = new mutable.HashSet[PlayerAction]()
    keys.map(keyCode => actions += getActionForKey(keyCode))
    actions.toSet
  }
}
