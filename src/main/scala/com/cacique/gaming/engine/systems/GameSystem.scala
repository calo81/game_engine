package com.cacique.gaming.engine.systems

import org.lwjgl.input.{Mouse, Keyboard}
import org.lwjgl.opengl.Display

/**
 * Created by cscarion on 12/02/15.
 */
class GameSystem extends System {

  override val handleMessage: Receive = {
    case SystemStart =>
      context.actorSelection("akka://GameEngine/user/ActorDispatcher") ! RegisterActor(self)
      val dm = org.lwjgl.util.Display.getAvailableDisplayModes(1024, 768, -1, -1, -1, -1, 60, 60);

      org.lwjgl.util.Display.setDisplayMode(dm, Array(
        "width=" + 1024, "height=" + 768,
        "freq=" + 60,
        "bpp=" + org.lwjgl.opengl.Display.getDisplayMode().getBitsPerPixel()
      ));

      Display.create()

      Mouse.setGrabbed(true)
      Keyboard.create()
      self ! Tick

  }

  override def onTick = {
    Display.update
    context.actorSelection("akka://GameEngine/user/ActorDispatcher") ! KeyPressed(Keyboard.getEventKey)
  }
}

object GameSystem extends SystemActor[GameSystem]
