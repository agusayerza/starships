package edu.austral.starship.scala.util

import java.util.Random

object RandomUtils {
  def randomFloat(min: Float, max: Float): Float = {
    val r = new Random
    min + r.nextFloat * (max - min)
  }

  def randomPositiveOrNegative: Int = if (new Random().nextBoolean) 1
  else -1

  def randomBool: Boolean = new Random().nextBoolean

  def randomInt(min: Int, max: Int): Int = {
    val r = new Random
    min + r.nextInt(max + 1 - min)
  }
}
