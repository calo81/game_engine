package com.cacique.gaming.engine.systems

import akka.actor.{Props, ActorSystem, Actor}

import scala.reflect.ClassTag

/**
 * Created by cscarion on 09/02/15.
 */
abstract class System extends Actor {
  var started = false

  def receive = handleMessage orElse commonReceive

  val commonReceive: Receive = {
    case SystemStart =>
      println(s"Started ${this.getClass}")
      started = true
      self ! Tick
    case Tick =>
      doStuff
      self ! Tick
  }

  val handleMessage: Receive

  def doStuff = {

  }
}

abstract class SystemActor[T <: System : ClassTag] {
  def apply()(implicit actorSystem: ActorSystem) = {
    new SystemWrapper(actorSystem.actorOf(Props[T]))
  }
}
