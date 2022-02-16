package com.game.battleship.model;

public class BattleshipOutput {
    private String[][] player1Ground;
    private String[][] player2Ground;
    private Integer player1Hits;
    private Integer player2Hits;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String[][] getPlayer1Ground() {
        return player1Ground;
    }

    public void setPlayer1Ground(String[][] player1Ground) {
        this.player1Ground = player1Ground;
    }

    public String[][] getPlayer2Ground() {
        return player2Ground;
    }

    public void setPlayer2Ground(String[][] player2Ground) {
        this.player2Ground = player2Ground;
    }

    public Integer getPlayer1Hits() {
        return player1Hits;
    }

    public void setPlayer1Hits(Integer player1Hits) {
        this.player1Hits = player1Hits;
    }

    public Integer getPlayer2Hits() {
        return player2Hits;
    }

    public void setPlayer2Hits(Integer player2Hits) {
        this.player2Hits = player2Hits;
    }
}
