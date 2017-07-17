package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.uglytrivia.phase.Phase;
import com.adaptionsoft.games.uglytrivia.phase.actions.AnswerAction;
import com.adaptionsoft.games.uglytrivia.phase.actions.RollAction;
import com.adaptionsoft.games.uglytrivia.phase.handlers.MovementPhaseHandler;
import com.adaptionsoft.games.uglytrivia.phase.handlers.QuestionPhaseHandler;

import java.util.*;

import static com.adaptionsoft.games.uglytrivia.Category.*;
import static com.adaptionsoft.games.uglytrivia.phase.Phase.MOVEMENT;
import static com.adaptionsoft.games.uglytrivia.phase.Phase.QUESTION;
import static java.util.Arrays.*;

public class Game {
    private List<Player> players = new ArrayList<>();
    private Player currentPlayer = null;

    private Phase phase = MOVEMENT;
    private MovementPhaseHandler movementPhaseHandler = new MovementPhaseHandler();
    private QuestionPhaseHandler questionPhaseHandler = new QuestionPhaseHandler();

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

    public void advancePhase() {
        if(phase == MOVEMENT) {
            phase = QUESTION;
        }
        else {
            nextPlayer();
            phase = MOVEMENT;
        }
    }

    public void roll(int roll) {
        movementPhaseHandler.handle(currentPlayer, this, new RollAction(roll));
    }

    public boolean canAnswer() {
        return phase == QUESTION;
    }

    public void answer(boolean correct) {
        questionPhaseHandler.handle(currentPlayer, this, new AnswerAction(correct));
    }

    public void nextPlayer() {
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
