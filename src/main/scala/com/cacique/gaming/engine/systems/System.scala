package com.cacique.gaming.engine.systems

import akka.actor.{Props, ActorSystem, Actor}
import org.lwjgl.input.{Keyboard, Mouse}
import org.lwjgl.opengl.Display

import scala.reflect.ClassTag

/**
 * Created by cscarion on 09/02/15.
 */
abstract class System extends Actor {
  var started = false

  def receive = handleMessage orElse commonReceive

  val commonReceive: Receive = {
    case SystemStart =>
      context.actorSelection("akka://GameEngine/user/ActorDispatcher") ! RegisterActor(self)
      println(s"Started ${this.getClass}")
      started = true
      self ! Tick
    case Tick =>
      onTick
      Thread.sleep(1000)
      self ! Tick
  }

  def handleMessage: Receive = {
    case Noop =>
  }

  def onTick = {

  }
}

abstract class SystemActor[T <: System : ClassTag] {
  def apply()(implicit actorSystem: ActorSystem) = {
    val actorNameSplits = this.getClass.getCanonicalName.split("\\.")
    val actorName = actorNameSplits(actorNameSplits.length - 1).split("\\$")(0)
    new SystemWrapper(actorSystem.actorOf(Props[T], actorName))
  }
}
