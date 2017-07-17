package com.adaptionsoft.games.uglytrivia.phase.actions;

public class RollAction extends PlayerAction {

    private int roll;

    public RollAction(int roll) {
        this.roll = roll;
    }

    public int getRoll() {
        return roll;
    }
}
