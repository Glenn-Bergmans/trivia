package com.adaptionsoft.games.uglytrivia;

import java.util.*;

import static com.adaptionsoft.games.uglytrivia.Category.*;
import static java.util.Arrays.*;

public class Game {
    private List<Player> players = new ArrayList<>();

    private Map<Category, List<String>> categoryQuestions = new HashMap<>();

    private Player currentPlayer = null;
    boolean isGettingOutOfPenaltyBox;

    public Game() {
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

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public void addPlayer(String playerName) {
        players.add(new Player(playerName));
        if(players.size() == 1) {
            currentPlayer = players.get(0);
        }
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        System.out.println(currentPlayer + " is the current player");
        System.out.println("They have rolled a " + roll);

        if(currentPlayer.isInPenaltyBox()) {
            if(roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                System.out.println(currentPlayer + " is getting out of the penalty box");
                currentPlayer.moveForward(roll);

                System.out.println(currentPlayer
                                   + "'s new location is "
                                   + currentPlayer.getPlace());
                System.out.println("The category is " + currentCategory());
                askQuestion();
            }
            else {
                System.out.println(currentPlayer + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        }
        else {
            currentPlayer.moveForward(roll);

            System.out.println(currentPlayer
                               + "'s new location is "
                               + currentPlayer.getPlace());
            System.out.println("The category is " + currentCategory());
            askQuestion();
        }

    }

    private void askQuestion() {
        System.out.println(categoryQuestions.get(currentCategory()).remove(0));
    }

    private Category currentCategory() {
        int placeMod = currentPlayer.getPlace() % 4;
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

    public void wasCorrectlyAnswered() {
        if(! (currentPlayer.isInPenaltyBox() && ! isGettingOutOfPenaltyBox)) {
            System.out.println("Answer was correct!!!!");
            currentPlayer.addCoin();
            System.out.println(currentPlayer
                               + " now has "
                               + currentPlayer.getCoins()
                               + " Gold Coins.");
        }

        nextPlayer();
    }

    public void wasWronglyAnswered() {
        System.out.println("Question was incorrectly answered");
        System.out.println(currentPlayer + " was sent to the penalty box");
        currentPlayer.setInPenaltyBox(true);

        nextPlayer();
    }

    private void nextPlayer() {
        int index = players.indexOf(currentPlayer);
        int next = (index + 1) % players.size();
        currentPlayer = players.get(next);
    }

    public boolean hasAWinner() {
        return players.stream()
                      .map(Player::getCoins)
                      .anyMatch(coins -> coins == 6);
    }

}
