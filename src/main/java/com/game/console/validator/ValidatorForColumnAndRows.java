package com.game.console.validator;
public class ValidatorForColumnAndRows implements IValidator {

	private char rows;
	private int cols;

	public ValidatorForColumnAndRows(char rows, int cols) {
		this.rows = rows;
		this.cols = cols;
	}

	
	public boolean isValid() {
		boolean result = false;
		if(rows >= 'A' && rows<='Z'){
			if(cols >= 1 && cols <= 9){
				result =  true;
			}
			else
			{
				System.out.println( "Size of Battle area is invalid");
			}	
		}
		return result;
	}

}
