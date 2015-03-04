package com.cacique.gaming.engine.models.behaviour.ai.movement

import com.cacique.gaming.engine.models.features.Position
import com.cacique.gaming.engine.implicits.Implicits._
import org.apache.commons.math3.linear.RealVector

/**
 * Created by cscarion on 20/02/15.
 */

trait StopCondition {
  def reached: Boolean
}

case class ShootingDistance(selfPosition: Position, targetPosition: Position) extends StopCondition {
  val shootingDistance = 10.0

  override def reached: Boolean = {
    selfPosition.vector.getDistance(targetPosition) <= shootingDistance
  }
}

trait Seeker {

  protected var position: Position
  protected var orientation: Double
  protected var velocity: RealVector
  protected var maxSpeed: Double

  def seek(targetPosition: Position) = {
    if (!ShootingDistance(position, targetPosition).reached) {
      velocity = targetPosition.subtract(position)
      velocity = velocity.normalize
      position = position.add(velocity.mapMultiply(0.01))
    }
  }
}
