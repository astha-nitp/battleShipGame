package com.game.console.validator;
public class ValidatorforNoOfShips implements IValidator {

	private int noOfships;
	private int rowInInt;
	private int cols;

	public ValidatorforNoOfShips(int noOfships, int rowInInt, int cols) {
		this.noOfships = noOfships;
		this.rowInInt = rowInInt;
		this.cols = cols;
	}

	
	public boolean isValid() {
		boolean result = false;
		if(noOfships <= (cols*rowInInt) && noOfships>=1)
			result =  true;
		else {
			System.out.println("Invalid no. of battle ships.");
		}
		return result;
	}

}
