package com.adaptionsoft.games.uglytrivia.phase.actions;

public class AnswerAction extends PlayerAction {

    private boolean correct;

    public AnswerAction(boolean correct) {
        this.correct = correct;
    }

    public boolean isCorrect() {
        return correct;
    }

}
