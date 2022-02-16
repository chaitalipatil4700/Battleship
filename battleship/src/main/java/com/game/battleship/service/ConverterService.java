package com.game.battleship.service;

import com.game.battleship.exception.InvalidInputException;
import com.game.battleship.model.BattleshipInput;
import com.game.battleship.model.BattleshipOutput;
import org.apache.commons.lang3.tuple.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConverterService {

    public BattleshipInput convertInputFileToDto(File file) throws InvalidInputException, IOException {
        List<String> inputList = readFileToList(file);
        if(!validateInputFile(inputList))
        {
            FileWriter fw=new FileWriter("src/main/resources/output.txt");
            fw.write("Invalid Input File!!!");
            fw.close();
            throw new InvalidInputException("Input file is Invalid!!!");
        }
        return  mapListToBattleship(inputList);
    }

    public void convertOutputDtoToFile(BattleshipOutput battleshipOutput){
        try{
            FileWriter fw=new FileWriter("src/main/resources/output.txt",true);
            fw.write("Player1"+"\n");
            fw.write(extractMultidimensionalArray(battleshipOutput.getPlayer1Ground()));
            fw.write("Player2"+"\n");
            fw.write(extractMultidimensionalArray(battleshipOutput.getPlayer2Ground()));
            fw.write("P1:"+battleshipOutput.getPlayer1Hits()+"\n");
            fw.write("P2:"+battleshipOutput.getPlayer2Hits()+"\n");
            fw.write(battleshipOutput.getResult());
            fw.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    private Boolean validateInputFile(List<String> inputList){
        if(inputList == null || inputList.size()!= 7){
            return false;
        }
        int i=0;
        if(validateNumber(inputList.get(i++))){
            if(validateNumber(inputList.get(i++))){
                if(validatePositions(inputList.get(i++),Integer.parseInt(inputList.get(1)))){
                    if(validatePositions(inputList.get(i++),Integer.parseInt(inputList.get(1)))){
                        if(validateNumber(inputList.get(i++))){
                            if(validatePositions(inputList.get(i++),Integer.parseInt(inputList.get(4)))){
                                if(validatePositions(inputList.get(i++),Integer.parseInt(inputList.get(4)))){
                                    return true;
                                }

                                }
                        }
                    }
                }
            }
        }
        return false;
    }

    private Boolean validatePositions(String st,Integer size){
        if(st.split(":").length!=size){
            return false;
        }
        String[] str = st.split(":");
        int i=0;
        while(i<size)
            if(str[i++].split(",").length!=2){
                return false;
            }
        return true;
    }

    private Boolean validateNumber(String st){
        try {
            double d = Integer.parseInt(st);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private String extractMultidimensionalArray(String[][] battleField) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < battleField.length; i++){
            for (int j=0; j < battleField.length; j++){
                sb.append(battleField[i][j]+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private List<String> readFileToList(File file){
        try
        {
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            List<String> input = new ArrayList();
            String line;
            while((line=br.readLine())!=null)
            {
                input.add(line);
            }
            fr.close();
            return input;
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }



    private BattleshipInput mapListToBattleship(List<String> inputList){
        BattleshipInput battleshipInput = new BattleshipInput();
        int i=0;
        battleshipInput.setGridSize(Integer.parseInt(inputList.get(i++)));
        battleshipInput.setTotalShips(Integer.parseInt(inputList.get(i++)));
        battleshipInput.setPlayer1ShipPositions(extractPositionsFromString(inputList.get(i++),battleshipInput.getGridSize()));
        battleshipInput.setPlayer2ShipPositions(extractPositionsFromString(inputList.get(i++),battleshipInput.getGridSize()));
        battleshipInput.setTotalMissiles(Integer.parseInt(inputList.get(i++)));
        battleshipInput.setPlayer1Moves(extractPositionsFromString(inputList.get(i++),battleshipInput.getGridSize()));
        battleshipInput.setPlayer2Moves(extractPositionsFromString(inputList.get(i++),battleshipInput.getGridSize()));
        return battleshipInput;
    }

    private List<Pair<Integer,Integer>> extractPositionsFromString(String pairString, Integer gridSize){
        List<Pair<Integer,Integer>> pairArray = new ArrayList();
        int i=0;
        while(i<gridSize) {
            String[] pos = pairString.split(":")[i].split(",");
            Pair<Integer, Integer> pair = Pair.of(Integer.parseInt(pos[0]), Integer.parseInt(pos[1]));
            pairArray.add(pair);
            i++;
        }
        return  pairArray;
    }
}
