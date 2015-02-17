package com.cacique.gaming.engine.drawing

import org.lwjgl.opengl.GL11

/**
 * Created by cscarion on 16/02/15.
 */
class Sprite extends Drawable {
  override def draw: Unit = {
    GL11.glPushMatrix

    // bind to the appropriate texture for this sprite
    //texture.bind

    // translate to the right location and prepare to draw
    GL11.glTranslatef(0, 10, 0)
    GL11.glColor3f(1, 1, 1)

    // draw a quad textured to match the sprite
    GL11.glBegin(GL11.GL_QUADS)
    GL11.glTexCoord2f(0, 0)
    GL11.glVertex2f(0, 0)
    GL11.glTexCoord2f(0, 10)
    GL11.glVertex2f(0, 10)
    GL11.glTexCoord2f(10, 10)
    GL11.glVertex2f(10, 10)
    GL11.glTexCoord2f(10, 0)
    GL11.glVertex2f(10, 0)

    GL11.glEnd

    // restore the model view matrix to prevent contamination
    GL11.glPopMatrix
  }
}
