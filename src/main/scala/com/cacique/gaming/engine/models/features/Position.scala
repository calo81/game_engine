package com.cacique.gaming.engine.models.features

import org.apache.commons.math3.linear.{RealVector, ArrayRealVector}

/**
 * Created by cscarion on 19/02/15.
 */
class Position(val x: Double, val y: Double) {

  def this(vector: RealVector) = {
    this(vector.getEntry(0), vector.getEntry(1))
  }

  val vector = new ArrayRealVector(Array[Double](x, y), false)

  def add(vector: RealVector) = {
    new Position(this.vector.add(vector))
  }

  def subtract(vector: RealVector) = {
    new Position(this.vector.subtract(vector))
  }

  override def toString = {
    vector.toString
  }
}
