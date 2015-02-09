package com.cacique.gaming.engine.systems

import akka.actor.{Actor, ActorRef}

/**
 * Created by cscarion on 09/02/15.
 */
object SystemStart
class SystemWrapper(actor: ActorRef) {
  def start = {
    actor ! SystemStart
  }
}
