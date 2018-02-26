package com.game.console.application;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.game.console.function.Game;
import com.game.console.validator.ValidtionUtil;
import com.game.console.validator.ValidtionUtil2;

public class BattleShipGame {

	public static void main(String[] args) {
		
        String fileName = "input.txt";

        List<String> input = new ArrayList<String>();
        String line = null;

        try {
           FileReader fileReader = new FileReader(fileName);
           BufferedReader bufferedReader = new BufferedReader(fileReader);
           while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                input.add(line);
            }   
          
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            
        }
        String[] inputs = input.toArray(new String[0]);
        boolean status = ValidtionUtil.validateInputs(inputs);
        if(status) {
//        System.out.println("converted");
        Game battleShip = new Game();        
        battleShip.setInputs(inputs);
//        ValidtionUtil.validate(battleShip);
        battleShip.initializeGame();
        }else {
        	System.out.println("Invalid inputs..Check input file");
        }

	}

}
