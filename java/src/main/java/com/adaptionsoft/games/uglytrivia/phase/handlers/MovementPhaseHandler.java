package com.adaptionsoft.games.uglytrivia.phase.handlers;

import com.adaptionsoft.games.uglytrivia.Category;
import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.Player;
import com.adaptionsoft.games.uglytrivia.phase.actions.PlayerAction;
import com.adaptionsoft.games.uglytrivia.phase.actions.RollAction;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.adaptionsoft.games.uglytrivia.Category.*;
import static java.util.Arrays.stream;

public class MovementPhaseHandler extends PhaseHandler {

    public MovementPhaseHandler(Game game) {
        super(game);
    }

    @Override
    public void handle(PlayerAction action) {
        int roll = ((RollAction) action).getRoll();

        System.out.println(player + " is the current player");
        System.out.println("They have rolled a " + roll);

        updateCanPlayThisTurn(roll);
        if(player.canPlayThisTurn()) {
            player.moveForward(roll);

            System.out.println(player
                               + "'s new location is "
                               + player.getPlace());
            game.advancePhase();
        }
        else {
            game.nextPlayer();
        }
    }

    private void updateCanPlayThisTurn(int roll) {
        if(player.isInPenaltyBox()) {
            if(roll % 2 != 0) {
                player.setCanPlayThisTurn(true);
                System.out.println(player + " is getting out of the penalty box");
            }
            else {
                player.setCanPlayThisTurn(false);
                System.out.println(player + " is not getting out of the penalty box");
            }
        }
        else {
            player.setCanPlayThisTurn(true);
        }
    }

}
