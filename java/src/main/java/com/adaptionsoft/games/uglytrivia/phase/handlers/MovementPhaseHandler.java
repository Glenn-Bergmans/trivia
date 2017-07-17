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

    private Map<Category, List<String>> categoryQuestions = new HashMap<>();

    public MovementPhaseHandler() {
        createQuestions();
    }

    private void createQuestions() {
        stream(Category.values()).forEach(category -> {
            List<String> questions = new LinkedList<>();
            for(int i = 0; i < 50; i++) {
                questions.add(category + " Question " + i);
            }
            categoryQuestions.put(category, questions);
        });
    }
    
    @Override
    public void handle(Player player, Game game, PlayerAction action) {
        int roll = ((RollAction) action).getRoll();

        System.out.println(player + " is the current player");
        System.out.println("They have rolled a " + roll);

        updateCanPlayThisTurn(player, roll);
        if(player.canPlayThisTurn()) {
            player.moveForward(roll);

            System.out.println(player
                               + "'s new location is "
                               + player.getPlace());
            Category category = categoryOf(player.getPlace());
            System.out.println("The category is " + category);
            askQuestion(category);
            game.advancePhase();
        }
        else {
            game.nextPlayer();
        }
    }

    private void updateCanPlayThisTurn(Player player, int roll) {
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

    private Category categoryOf(int place) {
        int placeMod = place % 4;
        switch(placeMod) {
            case 0:
                return POP;
            case 1:
                return SCIENCE;
            case 2:
                return SPORTS;
            default:
                return ROCK;
        }
    }

    private void askQuestion(Category category) {
        System.out.println(categoryQuestions.get(category).remove(0));
    }

}
