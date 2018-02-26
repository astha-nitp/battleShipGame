package com.game.console.utils;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class UtilitiesTest {
	
	@BeforeMethod
	public void Setup() {
		
	}
	
	public void testConvertLetterToIntValidCase() {
		Assert.assertEquals(Utilities.convertLetterToInt('H'),8);
	}
	
	public void testConvertLetterToIntInvalidCase() {
		Assert.assertEquals(Utilities.convertLetterToInt('h'),-1);
	}
	
	public void testConvertLetterToIntInvalidCase2() {
		Assert.assertEquals(Utilities.convertLetterToInt('*'),-1);
	}

}
