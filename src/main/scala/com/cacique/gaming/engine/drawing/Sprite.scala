package com.cacique.gaming.engine.drawing

import org.apache.commons.math3.linear.RealVector
import org.lwjgl.opengl.GL11

/**
 * Created by cscarion on 16/02/15.
 */
class Sprite(val id: String, position: RealVector) extends Drawable {

  val textureLoader = new TextureLoader

  override def draw: Unit = {
    val texture = textureLoader.getTexture("alien.gif")

    // bind to the appropriate texture for this sprite
    // texture.bind

    val positionXChange = (position.getEntry(0).toFloat * 10)
    val positionYChange = (position.getEntry(1).toFloat * 10)

    GL11.glColor3f(0.5f, 0.5f, 1.0f);

    // draw quad
    GL11.glBegin(GL11.GL_QUADS);
    GL11.glVertex2f(100 + positionXChange, 100 + positionYChange);
    GL11.glVertex2f(100 + 200 + positionXChange, 100 + positionYChange);
    GL11.glVertex2f(100 + 200 + positionXChange, 100 + 200 + positionYChange);
    GL11.glVertex2f(100 + positionXChange, 100 + 200 + positionYChange);
    GL11.glEnd();

  }
}
