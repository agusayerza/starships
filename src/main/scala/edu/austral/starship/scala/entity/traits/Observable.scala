package edu.austral.starship.scala.entity.traits

trait Observable {
  var observers: List[Observer] = List()

  def addObserver(observer: Observer): Unit = observers = observer :: observers

  def removeObserver(observer: Observer): Unit = observers = observers.filterNot((p: Observer) => p == observer)

  def notifyObserver(): Unit = observers.foreach((o: Observer) => o.updateObserver())

}
