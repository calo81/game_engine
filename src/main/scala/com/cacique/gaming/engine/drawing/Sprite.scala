package com.cacique.gaming.engine.drawing

import org.lwjgl.opengl.GL11

/**
 * Created by cscarion on 16/02/15.
 */
class Sprite extends Drawable {

  val textureLoader = new TextureLoader

  override def draw: Unit = {
    val texture = textureLoader.getTexture("alien.gif")

    // bind to the appropriate texture for this sprite
    // texture.bind


    GL11.glColor3f(0.5f,0.5f,1.0f);

    // draw quad
    GL11.glBegin(GL11.GL_QUADS);
    GL11.glVertex2f(100,100);
    GL11.glVertex2f(100+200,100);
    GL11.glVertex2f(100+200,100+200);
    GL11.glVertex2f(100,100+200);
    GL11.glEnd();

  }
}
