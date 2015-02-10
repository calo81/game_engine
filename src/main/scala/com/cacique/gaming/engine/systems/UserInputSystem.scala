package com.cacique.gaming.engine.systems

import akka.actor.{Props, ActorSystem}
import scala.reflect.ClassTag
/**
 * Created by cscarion on 09/02/15.
 */
class UserInputSystem extends System{
  override val handleMessage: Receive = {
    case Tick =>
      while(true){
        val c = System.in.read()
        println(s"IT IS A $c")
      }
  }
}

object UserInputSystem extends SystemActor[UserInputSystem]
