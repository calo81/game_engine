package com.cacique.gaming.engine.models.actorwrappers

import akka.actor.Actor
import com.cacique.gaming.engine.models.PlayerCharacter
import com.cacique.gaming.engine.systems.ActorDispatcher
import com.cacique.gaming.engine.systems.implementations.{PlayerChangedPosition, Draw}

/**
 * Created by cscarion on 13/02/15.
 */

object MoveForward
object MoveBackward
object TurnRight
object TurnLeft

class PlayerActor extends Actor{

  val playerCharacter = new PlayerCharacter("hero")

  override def receive: Receive = {
    case MoveForward =>
      playerCharacter.moveForward
      publishPlayerMessages
    case MoveBackward =>
      playerCharacter.moveBackward
      publishPlayerMessages
    case TurnRight =>
      playerCharacter.turnRight
      publishPlayerMessages
    case TurnLeft =>
      playerCharacter.turnLeft
      publishPlayerMessages
  }

  private def publishPlayerMessages = {
    ActorDispatcher() ! Draw(playerCharacter.drawable)
    ActorDispatcher() ! PlayerChangedPosition(playerCharacter.position)
  }
}
