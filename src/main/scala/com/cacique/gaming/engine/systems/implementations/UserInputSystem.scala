package com.cacique.gaming.engine.systems.implementations

import com.cacique.gaming.engine.systems.{System, SystemActor}
/**
 * Created by cscarion on 09/02/15.
 */

case class KeyPressed(key: Int)

class UserInputSystem extends System{

  override def handleMessage = {
    case KeyPressed(key) =>
      println("Andale andale")

  }
}

object UserInputSystem extends SystemActor[UserInputSystem]
