package com.cacique.gaming.engine.models

import com.cacique.gaming.engine.drawing.{Drawable, WithDrawable, Sprite}
import org.apache.commons.math3.linear.{ArrayRealVector}

/**
 * Created by cscarion on 13/02/15.
 */
class PlayerCharacter extends WithDrawable {

  var position = new ArrayRealVector(Array[Double](1, 1), false)
  var velocity = new ArrayRealVector(Array[Double](1, 2), false)
  var orientation = 0.0
  var rotation = 0.0
  val timeUpdate = 0.05

  def moveForward = {
    position = position.add(velocity.mapMultiply(timeUpdate))
  }

  def moveBackward = {
    position = position.subtract(velocity.mapMultiply(timeUpdate))
  }

  def turnLeft = {
    val sinRadians = Math.sin(0.1)
    val cosRadians = Math.cos(0.1)

    val velocityX = velocity.getEntry(0) * cosRadians - velocity.getEntry(1) * sinRadians
    val velocityY = velocity.getEntry(0) * sinRadians + velocity.getEntry(1) * cosRadians
    velocity = new ArrayRealVector(Array[Double](velocityX, velocityY), false)
    position = position.add(velocity.mapMultiply(timeUpdate))
  }

  def turnRight = {
    val sinRadians = Math.sin(-0.1)
    val cosRadians = Math.cos(-0.1)

    val velocityX = velocity.getEntry(0) * cosRadians - velocity.getEntry(1) * sinRadians
    val velocityY = velocity.getEntry(0) * sinRadians + velocity.getEntry(1) * cosRadians
    velocity = new ArrayRealVector(Array[Double](velocityX, velocityY), false)
    position = position.add(velocity.mapMultiply(timeUpdate))
  }

  override def drawable: Drawable = {
    new Sprite("player", position)
  }
}
