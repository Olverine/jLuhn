package jluhn;

import org.junit.Test;
import org.junit.Assert;

public class TestVerify {
	
	@Test
	public void testVerifyValidNumbers() {
		String[] testNumbers = new String[] {
				"8112189876",
				"4485010200834104",
				"3537277305656753",
				"5018421714620470"
		};
		
		for(String number : testNumbers) {
			boolean valid = Luhn.verify(number);
			Assert.assertTrue(number + " is valid but was determined to be invalid", valid);
		}
	}
	
	@Test
	public void testVerifyInvalidNumbers()  {
		String[] testNumbers = new String[] {
				"8112189874",
				"4485010200834101",
				"3537277305656752",
				"5018421714620476"
		};
		
		for(String number : testNumbers) {
			boolean valid = Luhn.verify(number);
			Assert.assertFalse(number + " is invalid but was determined to be valid", valid);
		}
	}
	
	@Test
	public void testIgnoreCharacterAndVerify() {
		String number = "811218-9876";
		boolean valid = Luhn.verify(number, "-");
		Assert.assertTrue(number + " is valid but was determined to be invalid", valid);
	}
	
	@Test
	public void testIllegalChars(){
		String[] testNumbers = new String[] {
				"811218-9876",
				"4485 0102 0083 4104",
				"INVALID",
				"5018.4217.1462.0470"
		};
		
		for(String number : testNumbers) {
			try {
				Luhn.verify(number);
				Assert.fail("No exception caught!");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (Exception e) {
				Assert.fail("Exception was not of the expected type!");
			}
		}
	}
	
}
