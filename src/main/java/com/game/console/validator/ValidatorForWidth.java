package com.game.console.validator;

public class ValidatorForWidth implements IValidator {

	private int noOfships;
	private String[] inputs;
	private int cols;

	public ValidatorForWidth(int noOfships, String[] inputs, int cols) {
		this.noOfships = noOfships;
		this.inputs = inputs;
		this.cols = cols;
	}

	public boolean isValid() {
		boolean result = false;
        int k =noOfships+2;
		
		for(int i = 2;i<k;i++){
			String[] shipCells  = inputs[i].split(" ");
			int width = Integer.parseInt(shipCells[1]);
			if(width>=1 && width<=cols)
				result =  true;
			else
				{
					System.out.println("Invalid width.");
					return result;
				}
			
		}
		return result;
	}

}
