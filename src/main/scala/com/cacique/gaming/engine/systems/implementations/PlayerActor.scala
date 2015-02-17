package com.cacique.gaming.engine.systems.implementations

import akka.actor.Actor
import akka.actor.Actor.Receive
import com.cacique.gaming.engine.models.PlayerCharacter
import com.cacique.gaming.engine.systems.ActorDispatcher

/**
 * Created by cscarion on 13/02/15.
 */

object MoveForward
object MoveBackward

class PlayerActor extends Actor{

  val playerCharacter = new PlayerCharacter

  override def receive: Receive = {
    case MoveForward =>
      playerCharacter.moveForward
      ActorDispatcher() ! Draw(playerCharacter)
    case MoveBackward =>
      playerCharacter.moveBackward
      ActorDispatcher() ! Draw(playerCharacter)
  }
}