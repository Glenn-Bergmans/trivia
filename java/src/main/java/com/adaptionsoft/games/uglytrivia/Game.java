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
        if(currentPlayer.getPlace() == 0) {
            return POP;
        }
        if(currentPlayer.getPlace() == 4) {
            return POP;
        }
        if(currentPlayer.getPlace() == 8) {
            return POP;
        }
        if(currentPlayer.getPlace() == 1) {
            return SCIENCE;
        }
        if(currentPlayer.getPlace() == 5) {
            return SCIENCE;
        }
        if(currentPlayer.getPlace() == 9) {
            return SCIENCE;
        }
        if(currentPlayer.getPlace() == 2) {
            return SPORTS;
        }
        if(currentPlayer.getPlace() == 6) {
            return SPORTS;
        }
        if(currentPlayer.getPlace() == 10) {
            return SPORTS;
        }
        return ROCK;
    }

    public boolean wasCorrectlyAnswered() {
        if(currentPlayer.isInPenaltyBox()) {
            if(isGettingOutOfPenaltyBox) {
                System.out.println("Answer was correct!!!!");
                currentPlayer.addCoin();
                System.out.println(currentPlayer
                                   + " now has "
                                   + currentPlayer.getCoins()
                                   + " Gold Coins.");

                boolean winner = didPlayerWin();
                nextPlayer();

                return winner;
            }
            else {
                nextPlayer();
                return true;
            }


        }
        else {
            System.out.println("Answer was corrent!!!!");
            currentPlayer.addCoin();
            System.out.println(currentPlayer
                               + " now has "
                               + currentPlayer.getCoins()
                               + " Gold Coins.");

            boolean winner = didPlayerWin();
            nextPlayer();

            return winner;
        }
    }

    private void nextPlayer() {
        int index = players.indexOf(currentPlayer);
        int next = (index + 1) % players.size();
        currentPlayer = players.get(next);
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(currentPlayer + " was sent to the penalty box");
        currentPlayer.setInPenaltyBox(true);

        nextPlayer();
        return true;
    }


    private boolean didPlayerWin() {
        return !(currentPlayer.getCoins() == 6);
    }
}
