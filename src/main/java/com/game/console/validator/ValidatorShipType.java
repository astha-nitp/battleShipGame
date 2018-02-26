package com.game.console.validator;
public class ValidatorShipType implements IValidator {

	private int noOfships;
	private String[] inputs;

	public ValidatorShipType(int noOfships, String[] inputs) {
		this.noOfships = noOfships;
		this.inputs = inputs;
	}

	
	public boolean isValid() {
		boolean result = false;
        int k =noOfships+2;
		
		for(int i = 2;i<k;i++){
			String[] shipCells  = inputs[i].split(" ");
			if(shipCells[0].equalsIgnoreCase("p") || shipCells[0].equalsIgnoreCase("q")){
				result =  true;
			}
			else {
				System.out.println("Invalid Ship Type.");
				return result;
			}
			
		}
		return result;
	}

}
