package com.cacique.gaming.engine.systems

import java.util.Scanner

import akka.actor.{Props, ActorSystem}
import org.lwjgl.input.{Keyboard, Mouse}
import org.lwjgl.opengl.Display
import scala.reflect.ClassTag
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
