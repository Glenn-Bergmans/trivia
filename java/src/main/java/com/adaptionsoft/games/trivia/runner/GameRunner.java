
package com.adaptionsoft.games.trivia.runner;

import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

    public static void main(String[] args) {
        runGame(new Random());
    }

    public static void runGame(Random rand) {
        Game aGame = new Game();

        aGame.addPlayer("Chet");
        aGame.addPlayer("Pat");
        aGame.addPlayer("Sue");

        do {
            aGame.roll(rand.nextInt(5) + 1);

            if(rand.nextInt(9) == 7) {
                aGame.wasWronglyAnswered();
            }
            else {
                aGame.wasCorrectlyAnswered();
            }
        } while(! aGame.hasAWinner());
    }
}
