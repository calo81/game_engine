package com.cacique.gaming.engine.implicits

import com.cacique.gaming.engine.models.features.Position
import org.apache.commons.math3.linear.{ArrayRealVector, RealVector}

/**
 * Created by cscarion on 20/02/15.
 */
object Implicits {
  implicit def vectorToPosition(vector: RealVector): Position = {
    new Position(vector)
  }

  implicit def positionToVector(position: Position) = {
    position.vector
  }

  implicit class VectorExtensions(vector: RealVector) {
    def normalize = {
      val vectorDimension = vector.getDimension
      val newX = vector.getEntry(0) / vectorDimension
      val newY = vector.getEntry(1) / vectorDimension
      new ArrayRealVector(Array[Double](newX, newY), false)
    }
  }
}
