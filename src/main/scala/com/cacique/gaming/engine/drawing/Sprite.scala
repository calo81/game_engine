package com.cacique.gaming.engine.drawing

import com.cacique.gaming.engine.models.features.Position
import org.lwjgl.opengl.GL11

/**
 * Created by cscarion on 16/02/15.
 */
class Sprite(val id: String, position: Position) extends Drawable {

  val textureLoader = new TextureLoader

  override def draw: Unit = {
    val texture = textureLoader.getTexture("alien.gif")

    // bind to the appropriate texture for this sprite
    // texture.bind

    val positionXChange = (position.x * 10).toFloat
    val positionYChange = (position.y * 10).toFloat

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
