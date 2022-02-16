package com.game.battleship;

import com.game.battleship.exception.InvalidInputException;
import com.game.battleship.service.BattleshipService;
import com.game.battleship.service.ConverterService;
import com.game.battleship.model.BattleshipInput;
import com.game.battleship.model.BattleshipOutput;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class BattleshipApplication {

	public static void main(String[] args) throws InvalidInputException, IOException {
		ConverterService fm = new ConverterService();
		BattleshipInput battleshipInput = fm.convertInputFileToDto(new File("src/main/resources/input.txt"));
		BattleshipService battleshipService = new BattleshipService();
		//SpringApplication.run(BattleshipApplication.class, args);
		BattleshipOutput battleshipOutput = battleshipService.executeAttacks(battleshipInput);
		fm.convertOutputDtoToFile(battleshipOutput);
	}

}
