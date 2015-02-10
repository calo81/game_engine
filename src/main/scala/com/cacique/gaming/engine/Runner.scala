package com.cacique.gaming.engine

import akka.actor.ActorSystem
import com.cacique.gaming.engine.systems._

/**
 * Created by cscarion on 09/02/15.
 */
object Runner {
  implicit val system = ActorSystem("GameEngine")

  def main(args: Array[String]): Unit = {
    systems foreach(_.start)
  }

  private def systems = {
    Seq[SystemWrapper](UserInputSystem())
  }
}
