
package com.adaptionsoft.games.trivia.runner;

import java.util.ArrayList;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

    private static boolean notAWinner;

    public static void main(String[] args) {
        runGame(new Random());
    }

    public static void runGame(Random rand) {
        Game aGame = new Game();

        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");

        ArrayList<Integer> rolls = new ArrayList<>();

        int roll = 0;
        do {
            roll = rand.nextInt(5);
            rolls.add(roll);
            aGame.roll(roll + 1);

            roll = rand.nextInt(9);
            rolls.add(roll);
            if(roll == 7) {
                notAWinner = aGame.wrongAnswer();
            }
            else {
                notAWinner = aGame.wasCorrectlyAnswered();
            }
        } while(notAWinner);

        /*
        rolls.forEach(value -> {
            System.out.print(value + ", ");
        });
        */
    }
}
