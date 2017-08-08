package com.adaptionsoft.games.uglytrivia.phase.handlers;

import com.adaptionsoft.games.uglytrivia.Category;
import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.Player;
import com.adaptionsoft.games.uglytrivia.phase.actions.PlayerAction;

public abstract class PhaseHandler {

    protected Game game;
    protected Player player;

    public PhaseHandler(Game game) {
        this.game = game;
    }

    public void startPhase(Player player) {
        this.player = player;
    }

    public abstract void handle(PlayerAction action);

}
