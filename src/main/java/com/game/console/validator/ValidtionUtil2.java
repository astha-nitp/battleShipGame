package com.game.console.validator;
import com.game.console.utils.Utilities;

public class ValidtionUtil2 {
	
	
	public static String validateInputs(String[] inputs) {
		String result = "Success";
        String fieldsize = inputs[0];
		String[] dimensions = fieldsize.split(" ");
		char rows = dimensions[1].charAt(0);
		int cols = Integer.parseInt(dimensions[0]);
		int noOfships = Integer.parseInt(inputs[1]);
		int rowInInt = Utilities.convertLetterToInt(rows);
		
		result = isValidSize(rows,cols);
		
		if("Success".equals(result)) {
			result=isValidNoOfShips(noOfships,rowInInt,cols);
			if("Success".equals(result)) {
				result=isValidShipType(noOfships, inputs);
				if("Success".equals(result)) {
					result=isValidWidth(noOfships, inputs,cols);
					if("Success".equals(result)) {
						result= isValidHeight(noOfships, inputs, rows);
					}
				}
			}
		}else {
			return result;
		}
		return result;
		
	}
	
	private static String isValidSize(char rows, int cols) {
		String result = "Success";
		if(rows >= 'A' && rows<='Z'){
			if(cols >= 1 && cols <= 9){
				result =  "Success";
			}
			else
			{
				result =  "Size of Battle area is invalid";
				return result;
			}	
		}
		return result;
		
	}
	
	private static String isValidNoOfShips(int noOfships, int rowInInt,int cols) {
		String result = "Success";
		if(noOfships <= (cols*rowInInt) && noOfships>=1)
			result =  "Success";
		else {
			result = "Invalid no. of battle ships.";
			return result;
		}
		return result;
	}
	
	private static String isValidShipType(int noOfships, String[] inputs) {
		String result = "Success";
        int k =noOfships+2;
		
		for(int i = 2;i<k;i++){
			String[] shipCells  = inputs[i].split(" ");
			if(shipCells[0].equalsIgnoreCase("p") || shipCells[0].equalsIgnoreCase("q")){
				result =  "Success";
			}
			else {
				result = "Invalid Ship Type.";
				return result;
			}
			
		}
		return result;
	}
	
	private static String isValidWidth(int noOfships, String[] inputs,int cols) {
		String result = "Success";
        int k =noOfships+2;
		
		for(int i = 2;i<k;i++){
			String[] shipCells  = inputs[i].split(" ");
			int width = Integer.parseInt(shipCells[1]);
			if(width>=1 && width<=cols)
				result =  "Success";
			else
				{
					result = "Invalid width.";
					return result;
				}
			
		}
		return result;
	}
	
	private static String isValidHeight(int noOfships, String[] inputs,char rows) {
		String result = "Success";
        int k =noOfships+2;
		
		for(int i = 2;i<k;i++){
			String[] shipCells  = inputs[i].split(" ");
			int height = Integer.parseInt(shipCells[2]);
			if(height>= 1 && height<=Utilities.convertLetterToInt(rows))
				result =  "Success";
			else
				{
					result = "Invalid height.";
					return result;
				}
			
		}
		return result;
	}
	
	
}
