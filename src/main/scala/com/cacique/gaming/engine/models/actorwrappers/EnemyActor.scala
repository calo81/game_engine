package com.cacique.gaming.engine.models.actorwrappers

import akka.actor.Actor
import akka.actor.Actor.Receive
import com.cacique.gaming.engine.models.Enemy
import com.cacique.gaming.engine.systems.implementations.PlayerChangedPosition

/**
 * Created by cscarion on 19/02/15.
 */
class EnemyActor extends Actor{

  val enemy = new Enemy("assasin")

  override def receive: Receive = {
    case PlayerChangedPosition(position) =>
      enemy.playerChangedPosition(position)
  }
}
