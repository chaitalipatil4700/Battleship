package com.game.battleship.model;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class BattleshipInput {
    private Integer gridSize;
    private Integer totalShips;
    private List<Pair<Integer,Integer>> player1ShipPositions;
    private List<Pair<Integer,Integer>> player2ShipPositions;
    private Integer totalMissiles;
    private List<Pair<Integer,Integer>> player1Moves;
    private List<Pair<Integer,Integer>> player2Moves;

    public Integer getGridSize() {
        return gridSize;
    }

    public void setGridSize(Integer gridSize) {
        this.gridSize = gridSize;
    }

    public Integer getTotalShips() {
        return totalShips;
    }

    public void setTotalShips(Integer totalShips) {
        this.totalShips = totalShips;
    }

    public Integer getTotalMissiles() {
        return totalMissiles;
    }

    public void setTotalMissiles(Integer totalMissiles) {
        this.totalMissiles = totalMissiles;
    }

    public List<Pair<Integer, Integer>> getPlayer1ShipPositions() {
        return player1ShipPositions;
    }

    public void setPlayer1ShipPositions(List<Pair<Integer, Integer>> player1ShipPositions) {
        this.player1ShipPositions = player1ShipPositions;
    }

    public List<Pair<Integer, Integer>> getPlayer2ShipPositions() {
        return player2ShipPositions;
    }

    public void setPlayer2ShipPositions(List<Pair<Integer, Integer>> player2ShipPositions) {
        this.player2ShipPositions = player2ShipPositions;
    }

    public List<Pair<Integer, Integer>> getPlayer1Moves() {
        return player1Moves;
    }

    public void setPlayer1Moves(List<Pair<Integer, Integer>> player1Moves) {
        this.player1Moves = player1Moves;
    }

    public List<Pair<Integer, Integer>> getPlayer2Moves() {
        return player2Moves;
    }

    public void setPlayer2Moves(List<Pair<Integer, Integer>> player2Moves) {
        this.player2Moves = player2Moves;
    }
}
