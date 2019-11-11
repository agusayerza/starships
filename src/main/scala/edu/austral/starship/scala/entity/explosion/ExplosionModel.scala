package edu.austral.starship.scala.entity.explosion

import edu.austral.starship.scala.base.vector.Vector2
import edu.austral.starship.scala.entity.abstracts.AbstractModel
import edu.austral.starship.scala.entity.traits.Collidable

class ExplosionModel(cposition: Vector2) extends AbstractModel(cposition){
  override var colliderWidth: Float = 0
  override var colliderHeight: Float = 0
  var index = 0;
  override def collisionedWith(collisionable: Collidable): Unit = {}

  override def update(time: Float): Unit = {
    super.update(time)
    index += 1
    if(index == 30) destroyMe()
  }
}
