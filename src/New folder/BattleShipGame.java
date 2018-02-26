import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BattleShipGame {

	public static void main(String[] args) {
		
        String fileName = "input.txt";

        List<String> input = new ArrayList<>();
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
        String status = ValidtionUtil.validateInputs(inputs);
        if("Success".equalsIgnoreCase(status)) {
//        System.out.println("converted");
        Game battleShip = new Game();        
        battleShip.setInputs(inputs);
//        ValidtionUtil.validate(battleShip);
        battleShip.initializeGame();
        }else {
        	System.out.println(status);
        }

	}

}
