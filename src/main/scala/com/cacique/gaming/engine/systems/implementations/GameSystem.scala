package com.cacique.gaming.engine.systems.implementations

import java.util.concurrent.{Executors, ExecutorService}

import com.cacique.gaming.engine.drawing.Drawable
import com.cacique.gaming.engine.systems._
import org.lwjgl.input.{Keyboard, Mouse}
import org.lwjgl.opengl.{GLContext, GL11, Display}

/**
 * Created by cscarion on 12/02/15.
 */

case class Draw(drawable: Drawable)

class GameSystem extends System {

  var drawables = scala.collection.mutable.Map[String, Drawable]()

  private object OpenGlThread {
    var openglExecutor = Executors.newSingleThreadExecutor()

    def initDisplay: Unit ={
      openglExecutor.submit(new Runnable {
        override def run(): Unit = {
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


          GL11.glMatrixMode(GL11.GL_PROJECTION);
          GL11.glLoadIdentity();
          GL11.glOrtho(0, 800, 0, 600, 1, -1);
          GL11.glMatrixMode(GL11.GL_MODELVIEW);

          Keyboard.create
          Keyboard.enableRepeatEvents(true)
        }
      })
    }

    def updateDisplay(drawables: scala.collection.mutable.Map[String, Drawable]): Unit ={
      openglExecutor.submit(new Runnable {
        override def run(): Unit = {
          if (!Display.isCurrent) {
            try {
              Display.makeCurrent
            } catch {
              case _ =>
            }
          }
          GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT)
          Keyboard.next()
          Keyboard.poll()
          if (Keyboard.getEventKey != 0) {
            if (Keyboard.getEventKeyState()) {
              ActorDispatcher() ! KeyPressed(Keyboard.getEventKey)
            }
          }
          renderScene(drawables)
          Display.update
          Display.sync(60)
        }
      })
    }

    def renderScene(drawables: scala.collection.mutable.Map[String, Drawable]): Unit = {
      drawables.values.foreach(_.draw)
    }
  }

  override def customStart = {
    OpenGlThread.initDisplay
  }

  override def handleMessage: Receive = {
    case Draw(drawable) =>
      drawables(drawable.id) = drawable
  }

  override def onTick = {
    OpenGlThread.updateDisplay(drawables)
  }

  def renderScene: Unit = {
    drawables.values.foreach(_.draw)
  }

}

object GameSystem extends SystemActor[GameSystem]
