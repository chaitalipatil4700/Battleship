package com.game.battleship.service;

import com.game.battleship.model.BattleshipInput;
import com.game.battleship.model.BattleshipOutput;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BattleshipService {


    public BattleshipOutput executeAttacks(BattleshipInput battleshipInput) {

        BattleshipOutput battleshipOutput = new BattleshipOutput();
        String[][] player1Ground = {{"_", "_", "_", "_", "_"}, {"_", "_", "_", "_", "_"}, {"_", "_", "_", "_", "_"}, {"_", "_", "_", "_", "_"}, {"_", "_", "_", "_", "_"}};
        String[][] player2Ground = {{"_", "_", "_", "_", "_"}, {"_", "_", "_", "_", "_"}, {"_", "_", "_", "_", "_"}, {"_", "_", "_", "_", "_"}, {"_", "_", "_", "_", "_"}};
        placeShips(player1Ground, battleshipInput.getPlayer1ShipPositions());
        placeShips(player2Ground, battleshipInput.getPlayer2ShipPositions());

        executeAttack(player1Ground, battleshipInput.getPlayer2Moves());
        executeAttack(player2Ground, battleshipInput.getPlayer1Moves());

        Integer player1DamagedShips = calculateDamagedShips(player1Ground, battleshipInput.getPlayer1ShipPositions());
        Integer player2DamagedShips = calculateDamagedShips(player2Ground, battleshipInput.getPlayer2ShipPositions());

        battleshipOutput.setPlayer1Ground(player1Ground);
        battleshipOutput.setPlayer2Ground(player2Ground);
        battleshipOutput.setPlayer1Hits(player2DamagedShips);
        battleshipOutput.setPlayer2Hits(player1DamagedShips);
        battleshipOutput.setResult(battleshipOutput.getPlayer1Hits() > battleshipOutput.getPlayer1Hits() ? "Player 1 wins" : (battleshipOutput.getPlayer1Hits() < battleshipOutput.getPlayer1Hits() ? "Player 2 wins" : "It is a draw"));
        return battleshipOutput;
    }

    private void placeShips(String[][] playerGround, List<Pair<Integer, Integer>> shipPositions) {
        for (Pair pair : shipPositions) {
            playerGround[(int) pair.getLeft()][(int) pair.getRight()] = "B";
        }
    }

    private void executeAttack(String[][] playerGround, List<Pair<Integer, Integer>> missilePositions) {
        for (Pair pair : missilePositions) {
            if ("B".equalsIgnoreCase(playerGround[(int) pair.getLeft()][(int) pair.getRight()])) {
                playerGround[(int) pair.getLeft()][(int) pair.getRight()] = "X";
            } else if ("_".equalsIgnoreCase(playerGround[(int) pair.getLeft()][(int) pair.getRight()])) {
                playerGround[(int) pair.getLeft()][(int) pair.getRight()] = "O";
            }
        }
    }

    private Integer calculateDamagedShips(String[][] playerGround, List<Pair<Integer, Integer>> shipPositions) {
        int damagedShipCount = 0;
        for (Pair pair : shipPositions) {
            if ("X".equalsIgnoreCase(playerGround[(int) pair.getLeft()][(int) pair.getRight()])) {
                damagedShipCount++;
            }
        }
        return damagedShipCount;
    }


}



