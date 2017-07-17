package com.adaptionsoft.games.uglytrivia;

public class Player {

    private String name;
    private int coins = 0;
    private int place = 0;
    private boolean inPenaltyBox = false;
    private boolean canPlayThisTurn = true;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCoins() {
        return coins;
    }

    public void addCoin() {
        this.coins++;
    }

    public int getPlace() {
        return place;
    }

    public void moveForward(int places) {
        place += places;
        place %= 12;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void setInPenaltyBox(boolean inPenaltyBox) {
        this.inPenaltyBox = inPenaltyBox;
    }

    public boolean canPlayThisTurn() {
        return canPlayThisTurn;
    }

    public void setCanPlayThisTurn(boolean canPlayThisTurn) {
        this.canPlayThisTurn = canPlayThisTurn;
    }

    @Override
    public String toString() {
        return name;
    }
}
