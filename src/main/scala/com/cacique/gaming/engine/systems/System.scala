package com.cacique.gaming.engine.systems

import akka.actor.{Props, ActorSystem, Actor}
import org.lwjgl.input.{Keyboard, Mouse}

import scala.reflect.ClassTag

/**
 * Created by cscarion on 09/02/15.
 */
abstract class System extends Actor {

  var started = false
  implicit val actorContext = this.context
  val fps = 60

  def receive = handleMessage orElse commonReceive

  val commonReceive: Receive = {
    case SystemStart =>
      ActorDispatcher() ! RegisterActor(self)
      println(s"Started ${this.getClass}")
      started = true
      customStart
      self ! Tick
    case Tick =>
      onTick
      Thread.sleep(1000/fps)
      self ! Tick
  }

  def handleMessage: Receive = {
    case Noop =>
  }

  def onTick = {

  }

  def customStart = {

  }
}

abstract class SystemActor[T <: System : ClassTag] {
  def apply()(implicit actorSystem: ActorSystem) = {
    val actorNameSplits = this.getClass.getCanonicalName.split("\\.")
    val actorName = actorNameSplits(actorNameSplits.length - 1).split("\\$")(0)
    new SystemWrapper(actorSystem.actorOf(Props[T], actorName))
  }
}
