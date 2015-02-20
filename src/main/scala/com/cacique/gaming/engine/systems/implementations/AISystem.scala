package com.cacique.gaming.engine.systems.implementations

import akka.actor.{Props, ActorRef}
import com.cacique.gaming.engine.models.actorwrappers.EnemyActor
import com.cacique.gaming.engine.models.features.Position
import com.cacique.gaming.engine.systems.{SystemActor, System}

/**
 * Created by cscarion on 19/02/15.
 */

case class PlayerChangedPosition(position: Position)

class AISystem extends System {

  var enemy: ActorRef = null

  override def handleMessage: Receive = {
    case p: PlayerChangedPosition =>
      enemy ! p
  }

  override def customStart = {
    this.enemy = context.actorOf(Props[EnemyActor], "Enemy1")
  }
}

object AISystem extends SystemActor[AISystem]
