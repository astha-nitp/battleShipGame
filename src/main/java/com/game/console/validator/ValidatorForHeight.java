package com.game.console.validator;

import com.game.console.utils.Utilities;

public class ValidatorForHeight implements IValidator {

	private int noOfships;
	private String[] inputs;
	private char rows;

	public ValidatorForHeight(int noOfships, String[] inputs, char rows) {
		this.noOfships = noOfships;
		this.inputs = inputs;
		this.rows = rows;
	}

	public boolean isValid() {
		boolean result = false;
        int k =noOfships+2;
		
		for(int i = 2;i<k;i++){
			String[] shipCells  = inputs[i].split(" ");
			int height = Integer.parseInt(shipCells[2]);
			if(height>= 1 && height<=Utilities.convertLetterToInt(rows))
				result =  true;
			else
				{
					System.out.println("Invalid height.");
					return result;
				}
			
		}
		return result;
	}

}
