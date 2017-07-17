package com.adaptionsoft.games.uglytrivia.phase.handlers;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.Player;
import com.adaptionsoft.games.uglytrivia.phase.actions.PlayerAction;

public abstract class PhaseHandler {

    public abstract void handle(Player player, Game game, PlayerAction action);

}
