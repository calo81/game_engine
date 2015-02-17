package com.cacique.gaming.engine.models

import com.cacique.gaming.engine.drawing.Sprite
import org.apache.commons.math3.linear.{ArrayRealVector}

/**
 * Created by cscarion on 13/02/15.
 */
class PlayerCharacter extends Sprite{

  var position = new ArrayRealVector(Array[Double](1,1), false)
  var velocity = new ArrayRealVector(Array[Double](1,2), false)
  var orientation = 0.0
  var rotation = 0.0
  val timeUpdate = 0.05

  def moveForward = {
    position = position.add(velocity.mapMultiply(timeUpdate))
    println(s"Position: $position")
  }

  def moveBackward = {
    position = position.subtract(velocity.mapMultiply(timeUpdate))
    println(s"Position: $position")
  }
}
