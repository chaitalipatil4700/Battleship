package com.game.battleship.service;

import com.game.battleship.exception.InvalidInputException;
import com.game.battleship.model.BattleshipInput;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class ConverterServiceTest {

    ConverterService converterService = new ConverterService();

    @Test
    void convertInputFileToDto() throws InvalidInputException, IOException {
        BattleshipInput battleshipInput = converterService.convertInputFileToDto(new File("src/main/resources/test/inputValidTest.txt"));
        assertEquals(5,battleshipInput.getGridSize());
        assertEquals(5,battleshipInput.getTotalMissiles());
        assertEquals(5,battleshipInput.getTotalShips());
        List<Pair<Integer,Integer>> player1ShipPositions = new ArrayList<>();
        player1ShipPositions.add(Pair.of(1,1));
        player1ShipPositions.add(Pair.of(2,0));
        player1ShipPositions.add(Pair.of(2,3));
        player1ShipPositions.add(Pair.of(3,4));
        player1ShipPositions.add(Pair.of(4,3));

        List<Pair<Integer,Integer>> player2ShipPositions = new ArrayList<>();
        player2ShipPositions.add(Pair.of(0,1));
        player2ShipPositions.add(Pair.of(2,3));
        player2ShipPositions.add(Pair.of(3,0));
        player2ShipPositions.add(Pair.of(3,4));
        player2ShipPositions.add(Pair.of(4,1));

        List<Pair<Integer,Integer>> player1Moves = new ArrayList<>();
        player1Moves.add(Pair.of(0,1));
        player1Moves.add(Pair.of(4,3));
        player1Moves.add(Pair.of(2,3));
        player1Moves.add(Pair.of(3,1));
        player1Moves.add(Pair.of(4,1));

        List<Pair<Integer,Integer>> player2Moves = new ArrayList<>();
        player2Moves.add(Pair.of(0,1));
        player2Moves.add(Pair.of(0,0));
        player2Moves.add(Pair.of(1,1));
        player2Moves.add(Pair.of(2,3));
        player2Moves.add(Pair.of(4,3));
        assertArrayEquals(player1ShipPositions.toArray(),battleshipInput.getPlayer1ShipPositions().toArray());
        assertArrayEquals(player2ShipPositions.toArray(),battleshipInput.getPlayer2ShipPositions().toArray());
        assertArrayEquals(player1Moves.toArray(),battleshipInput.getPlayer1Moves().toArray());
        assertArrayEquals(player2Moves.toArray(),battleshipInput.getPlayer2Moves().toArray());

    }

    @Test
    void convertOutputDtoToFile() {

    }
}