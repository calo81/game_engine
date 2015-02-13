package com.cacique.gaming.engine

import akka.actor.{Props, ActorSystem}
import com.cacique.gaming.engine.systems._
import com.cacique.gaming.engine.systems.implementations.{GameSystem, UserInputSystem}

/**
 * Created by cscarion on 09/02/15.
 */
object Runner {
  implicit val system = ActorSystem("GameEngine")
  system.actorOf(Props[ActorDispatcher], "ActorDispatcher")

  def main(args: Array[String]): Unit = {
    systems foreach(_.start)
  }

  private def systems = {
    Seq[SystemWrapper](GameSystem(), UserInputSystem())
  }
}
