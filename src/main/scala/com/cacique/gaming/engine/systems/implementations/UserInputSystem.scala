package com.cacique.gaming.engine.systems.implementations

import com.cacique.gaming.engine.systems.{System, SystemActor}
import org.lwjgl.input.Keyboard

/**
 * Created by cscarion on 09/02/15.
 */

case class KeyPressed(key: Int)

class UserInputSystem extends System {

  override def handleMessage = {
    case KeyPressed(key) =>
      println(key)
      key match {
        case Keyboard.KEY_UP =>
          println("The dude is moving up")
        case _ =>

      }

  }
}

object UserInputSystem extends SystemActor[UserInputSystem]
