package com.game.console.validator;
import java.util.ArrayList;
import java.util.List;

import com.game.console.utils.Utilities;

public class ValidtionUtil {
	
	
	public static boolean validateInputs(String[] inputs) {
		boolean result = false;
        String fieldsize = inputs[0];
		String[] dimensions = fieldsize.split(" ");
		char rows = dimensions[1].charAt(0);
		int cols = Integer.parseInt(dimensions[0]);
		int noOfships = Integer.parseInt(inputs[1]);
		int rowInInt = Utilities.convertLetterToInt(rows);
		List<IValidator> list = new ArrayList<IValidator>();
		
		list.add(new ValidatorForColumnAndRows(rows,cols));
		list.add(new ValidatorforNoOfShips(noOfships,rowInInt,cols));
		list.add(new ValidatorShipType(noOfships, inputs));
		list.add(new ValidatorForWidth(noOfships, inputs,cols));
		list.add(new ValidatorForHeight(noOfships, inputs, rows));
//		boolean isvalid;
		for(IValidator valid:list){
			if(!valid.isValid()){
			 break;
			}else
				result = true;	
		}

		return result;
		
	}

	
}
