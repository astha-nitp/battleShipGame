package com.game.console.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class ValidatorForColumnAndRowsTest {	
	
	public void TestRowValidColumnInvalid(){
		ValidatorForColumnAndRows validatorForColumnAndRows = new ValidatorForColumnAndRows('A', 10);
		Assert.assertFalse(validatorForColumnAndRows.isValid());
	}
	
	public void TestRowInvalidColumnValid(){
		ValidatorForColumnAndRows validatorForColumnAndRows = new ValidatorForColumnAndRows('a', 5);
		Assert.assertFalse(validatorForColumnAndRows.isValid());
	}
	
	public void TestRowColumnValid(){
		ValidatorForColumnAndRows validatorForColumnAndRows = new ValidatorForColumnAndRows('E', 5);
		Assert.assertTrue(validatorForColumnAndRows.isValid());
	}
}
