package jluhn;

import org.junit.Test;
import org.junit.Assert;

public class TestCheckDigit {
	
	@Test
	public void testCalculateCheckDigit() {
		String[] testNumbers = new String[] {
				"811218987",
				"448501020083410",
				"353727730565675",
				"501842171462047"
		};
		
		for(String num : testNumbers){
			int digit = Luhn.calculateCheckDigit(num);
			boolean valid = Luhn.verify(num + digit);
			Assert.assertTrue(valid);
		}
	}
	
	@Test
	public void testIgnoreCharacterAndCalculateCheckDigit() {
		String number = "811218-987";
		int digit = Luhn.calculateCheckDigit(number, "-");
		boolean valid = Luhn.verify(number + digit, "-");
		Assert.assertTrue(valid);
	}
	
	@Test
	public void testCalculateCheckDigitWithIllegalChars()  {
		String[] testNumbers = new String[] {
				"811218-987",
				"4485 0102 0083 410",
				"INVALID",
				"5018.4217.1462.047"
		};
		
		for(String number : testNumbers) {
			try {
				Luhn.calculateCheckDigit(number);
				Assert.fail("No exception caught!");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (Exception e) {
				Assert.fail("Exception was not of the expected type!");
			}
		}
	}
}
