package com.cacique.gaming.engine.models

import com.cacique.gaming.engine.drawing.{Sprite, Drawable, WithDrawable}
import com.cacique.gaming.engine.models.features.Position
import org.apache.commons.math3.linear.ArrayRealVector

/**
 * Created by cscarion on 18/02/15.
 */
class Character(name: String) extends WithDrawable{

  var position = new Position(1,1)
  protected var velocity = new ArrayRealVector(Array[Double](1, 2), false)
  protected var orientation = 0.0
  protected var rotation = 0.0
  protected val timeUpdate = 0.05

  override def drawable: Drawable = {
    new Sprite(name, position)
  }
}
