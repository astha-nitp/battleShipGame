package com.game.console.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class ValidatorForShiptypeTest {

	
	public void shipTypeValid(){
		String[] input = {"P", "1", "2", "D1"};
		ValidatorShipType validatorForShiptype = new ValidatorShipType(2, input);
		Assert.assertTrue(validatorForShiptype.isValid());
	}
	
	public void shipTypeInvalid(){
		String[] input = {"z", "1", "2", "D1"};
		ValidatorShipType validatorForShiptype = new ValidatorShipType(2, input);
		Assert.assertFalse(validatorForShiptype.isValid());
	}
}
