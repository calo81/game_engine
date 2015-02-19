package com.cacique.gaming.engine.systems.implementations

import akka.actor.{ActorRef, Props}
import com.cacique.gaming.engine.models.actorwrappers._
import com.cacique.gaming.engine.systems.{System, SystemActor}
import org.lwjgl.input.Keyboard

/**
 * Created by cscarion on 09/02/15.
 */

case class KeyPressed(key: Int)


class UserInputSystem extends System {

  var player: ActorRef = null

  override def handleMessage = {
    case KeyPressed(key) =>
        key match {
          case Keyboard.KEY_UP =>
            this.player ! MoveForward
          case Keyboard.KEY_DOWN =>
            this.player ! MoveBackward
          case Keyboard.KEY_LEFT =>
            this.player ! TurnLeft
          case Keyboard.KEY_RIGHT =>
            this.player ! TurnRight
          case Keyboard.KEY_ESCAPE =>
            System.exit(0)
          case _ =>
        }
  }

  override def customStart = {
    this.player = context.actorOf(Props[PlayerActor], "PlayerCharacter")
  }
}

object UserInputSystem extends SystemActor[UserInputSystem]
