package com.cacique.gaming.engine.systems

import akka.actor.{ActorRef, Actor}
import akka.actor.Actor.Receive

/**
 * Created by cscarion on 12/02/15.
 */

case class RegisterActor(actor: ActorRef)

class ActorDispatcher extends Actor {
  var actors: Seq[ActorRef] = Seq()

  override def receive: Receive = {
    case RegisterActor(actor) =>
      actors = actors :+ actor
    case event =>
      actors.foreach(_ ! event)
  }
}
