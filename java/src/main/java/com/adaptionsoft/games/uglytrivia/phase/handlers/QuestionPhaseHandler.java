package com.adaptionsoft.games.uglytrivia.phase.handlers;

import com.adaptionsoft.games.uglytrivia.Category;
import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.Player;
import com.adaptionsoft.games.uglytrivia.phase.actions.AnswerAction;
import com.adaptionsoft.games.uglytrivia.phase.actions.PlayerAction;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.adaptionsoft.games.uglytrivia.Category.*;
import static java.util.Arrays.stream;

public class QuestionPhaseHandler extends PhaseHandler {

    private Map<Category, List<String>> categoryQuestions = new HashMap<>();

    public QuestionPhaseHandler(Game game) {
        super(game);
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
    public void startPhase(Player player) {
        super.startPhase(player);
        Category category = categoryOf(player.getPlace());
        System.out.println("The category is " + category);
        askQuestion(category);
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

    @Override
    public void handle(PlayerAction action) {
        boolean correct = ((AnswerAction) action).isCorrect();
        if(correct) {
            questionCorrectlyAnswered();
        }
        else {
            questionIncorrectlyAnswered();
        }
        game.advancePhase();
    }

    private void questionCorrectlyAnswered() {
        if(! (player.isInPenaltyBox() && ! player.canPlayThisTurn())) {
            System.out.println("Answer was correct!!!!");
            player.addCoin();
            System.out.println(player
                               + " now has "
                               + player.getCoins()
                               + " Gold Coins.");
        }
    }

    private void questionIncorrectlyAnswered() {
        System.out.println("Question was incorrectly answered");
        System.out.println(player + " was sent to the penalty box");
        player.setInPenaltyBox(true);
    }
}
