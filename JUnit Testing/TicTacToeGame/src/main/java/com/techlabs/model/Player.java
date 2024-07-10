package com.techlabs.model;

public class Player {
    private String playerName;
    private MarkType mark;

    public Player(String playerName) {
        this.playerName = playerName;
        this.mark = MarkType.X;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public MarkType getMark() {
        return mark;
    }

    public void setMark(MarkType mark) {
        this.mark = mark;
    }
}
