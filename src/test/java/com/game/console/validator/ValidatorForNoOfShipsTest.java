package com.game.console.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class ValidatorForNoOfShipsTest {

	public void noOfShipsValid(){
		ValidatorforNoOfShips validatorforNoOfShips = new ValidatorforNoOfShips(2, 5,5);
		Assert.assertTrue(validatorforNoOfShips.isValid());
	}
	
	public void noOfShipsInvalid(){
		ValidatorforNoOfShips validatorforNoOfShips = new ValidatorforNoOfShips(30, 5,5);
		Assert.assertFalse(validatorforNoOfShips.isValid());
	}
	
}
