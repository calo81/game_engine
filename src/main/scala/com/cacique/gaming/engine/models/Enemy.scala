package com.cacique.gaming.engine.models

import com.cacique.gaming.engine.models.behaviour.ai.movement.Seeker
import com.cacique.gaming.engine.models.features.Position

/**
 * Created by cscarion on 19/02/15.
 */
class Enemy(name: String) extends Character(name) with Seeker {
  def playerChangedPosition(playerPosition: Position): Unit = {
    seek(playerPosition)
  }

}
