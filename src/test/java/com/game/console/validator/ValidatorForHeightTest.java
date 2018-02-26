package com.game.console.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class ValidatorForHeightTest {


	public void shipHeightValid(){
		String[] input = {"P", "1", "2", "D1"};
		ValidatorForHeight validatorForHeight = new ValidatorForHeight(2, input,'E');
		Assert.assertTrue(validatorForHeight.isValid());
	}
	
	public void shipHeightInvalid(){
		String[] input = {"P", "1", "8", "D1"};
		ValidatorForHeight validatorForHeight = new ValidatorForHeight(2, input,'E');
		Assert.assertFalse(validatorForHeight.isValid());
	}
	
}
