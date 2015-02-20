package com.cacique.gaming.engine.models

import com.cacique.gaming.engine.drawing.{Sprite, Drawable, WithDrawable}
import com.cacique.gaming.engine.models.features.Position
import com.cacique.gaming.engine.implicits.Implicits._
import org.apache.commons.math3.linear.{RealVector, ArrayRealVector}

/**
 * Created by cscarion on 18/02/15.
 */
class Character(name: String) extends WithDrawable{

  var position = new Position(1,1)
  protected var velocity: RealVector = new ArrayRealVector(Array[Double](1, 2), false)
  protected var orientation = 0.0
  protected var rotation = 0.0
  protected val timeUpdate = 0.5
  protected var maxSpeed = 0.1


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
    new Sprite(name, position)
  }
}
