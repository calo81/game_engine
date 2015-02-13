package com.cacique.gaming.engine.systems.implementations

import com.cacique.gaming.engine.systems.{ActorDispatcher, RegisterActor, System, SystemActor}
import org.lwjgl.input.{Keyboard, Mouse}
import org.lwjgl.opengl.{GL11, Display}

/**
 * Created by cscarion on 12/02/15.
 */
class GameSystem extends System {

  override def customStart = {
    val dm = org.lwjgl.util.Display.getAvailableDisplayModes(1024, 768, -1, -1, -1, -1, 60, 60);

    org.lwjgl.util.Display.setDisplayMode(dm, Array(
      "width=" + 1024, "height=" + 768,
      "freq=" + 60,
      "bpp=" + org.lwjgl.opengl.Display.getDisplayMode().getBitsPerPixel()
    ));

    Display.create()
    Display.setTitle("The Akka Game");
    Mouse.create()
    //Mouse.setGrabbed(true)


    GL11.glEnable(GL11.GL_TEXTURE_2D)

    // disable the OpenGL depth test since we're rendering 2D graphics
    GL11.glDisable(GL11.GL_DEPTH_TEST)

    GL11.glMatrixMode(GL11.GL_PROJECTION)
    GL11.glLoadIdentity();

    GL11.glOrtho(0, 1024, 768, 0, -1, 1)
    Keyboard.create
    Keyboard.enableRepeatEvents(true)
  }

  override def onTick = {
    if (!Display.isCurrent) {
      Display.makeCurrent
    }
    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT)
    Display.update
    Keyboard.next()
    Keyboard.poll()
    if (Keyboard.getEventKey != 0) {
      ActorDispatcher() ! KeyPressed(Keyboard.getEventKey)
    }
  }
}

object GameSystem extends SystemActor[GameSystem]
