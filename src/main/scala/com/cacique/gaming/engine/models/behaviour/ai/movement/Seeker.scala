package com.cacique.gaming.engine.models.behaviour.ai.movement

import com.cacique.gaming.engine.models.features.Position
import com.cacique.gaming.engine.implicits.Implicits._
import org.apache.commons.math3.linear.RealVector

/**
 * Created by cscarion on 20/02/15.
 */

trait Seeker {

  protected var position: Position
  protected var orientation: Double
  protected var velocity: RealVector
  protected var maxSpeed: Double

  def seek(targetPosition: Position) = {
    velocity = targetPosition.subtract(position)
    velocity = velocity.normalize
  }
}
