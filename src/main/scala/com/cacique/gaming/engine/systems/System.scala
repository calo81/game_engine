package com.cacique.gaming.engine.systems

import akka.actor.{Props, ActorSystem, Actor}

import scala.reflect.ClassTag

/**
 * Created by cscarion on 09/02/15.
 */
abstract class System extends Actor{
  def start: Unit = {

  }

  def receive = {
    case _ => None
  }
}

abstract class SystemActor[T <: System : ClassTag] {
  def instance(implicit actorSystem: ActorSystem) = {
    new SystemWrapper(actorSystem.actorOf(Props[T]))
  }
}
