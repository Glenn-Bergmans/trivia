package com.adaptionsoft.games.uglytrivia.phase.handlers;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.Player;
import com.adaptionsoft.games.uglytrivia.phase.actions.AnswerAction;
import com.adaptionsoft.games.uglytrivia.phase.actions.PlayerAction;

public class QuestionPhaseHandler extends PhaseHandler {
    
    @Override
    public void handle(Player player, Game game, PlayerAction action) {
        boolean correct = ((AnswerAction) action).isCorrect();
        if(correct) {
            wasCorrectlyAnsweredBy(player);
        }
        else {
            wasIncorrectlyAnsweredBy(player);
        }
        game.advancePhase();
    }

    private void wasCorrectlyAnsweredBy(Player player) {
        if(! (player.isInPenaltyBox() && ! player.canPlayThisTurn())) {
            System.out.println("Answer was correct!!!!");
            player.addCoin();
            System.out.println(player
                               + " now has "
                               + player.getCoins()
                               + " Gold Coins.");
        }
    }

    private void wasIncorrectlyAnsweredBy(Player player) {
        System.out.println("Question was incorrectly answered");
        System.out.println(player + " was sent to the penalty box");
        player.setInPenaltyBox(true);
    }
    
}
