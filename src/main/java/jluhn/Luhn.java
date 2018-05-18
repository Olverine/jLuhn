package jluhn;

/**
 * 
 * This is a java implementation of the Luhn algorithm.
 * This class can be used to calculate a check digit as well as verifying a number sequence.
 * 
 * @author Oliver Norin
 *
 */
public class Luhn {
	
	/**
	 * calculate a check digit for a number sequence so that the sequence can
	 * be checked using the Luhn algorithm.
	 * @param num Number sequence as String. Only numerical characters are allowed. 
	 * @return check digit numerical value.
	 */
	public static int calculateCheckDigit(String num) {
		int sum = 0;
        for(int i = 0; i < num.length(); i++){
            String digit = String.valueOf(num.charAt(num.length() - 1 - i));
            int digitVal = 0;
    		try{
    			digitVal = (Integer.parseInt(digit) * (i % 2 == 1 ? 1 : 2));
    		} catch(NumberFormatException e){
    			throw createIllegalArgException(e, digit);
    		}
            digitVal -= digitVal > 9 ? 9 : 0;
            sum += digitVal;
        }
        return (10 - (sum % 10)) % 10;
	}
	
	/**
	 * calculate a check digit for a number sequence so that the sequence can
	 * be checked using the Luhn algorithm.
	 * @param num Number sequence as String.
	 * @param ignore Regex pattern. Everything that matches this pattern will be removed before calculating check digit.
	 * @return check digit numerical value.
	 */
    public static int calculateCheckDigit(String num, String ignore) {
    	num = num.replaceAll(ignore, "");
        return calculateCheckDigit(num);
    }
	
	/**
	 * Verify a number sequence using the Luhn algorithm.
	 * @param num Number sequence as String. Only numerical characters are allowed. 
	 * @return true if the number sequence is valid.
	 */
	public static boolean verify(String num) {
        int sum = 0;
        for(int i = 0; i < num.length(); i++){
            String digit = String.valueOf(num.charAt(num.length() - 1 - i));
            int digitVal = 0;
    		try{
    			digitVal = (Integer.parseInt(digit) * (i % 2 == 0 ? 1 : 2));
    		} catch(NumberFormatException e){
    			throw createIllegalArgException(e, digit);
    		}
            digitVal -= digitVal > 9 ? 9 : 0;
            sum += digitVal;
        }
        return sum % 10 == 0;
    }

	/**
	 * Verify a number sequence using the Luhn algorithm while ignoring certain characters.
	 * @param num Number sequence as String. 
	 * @param ignore Regex pattern. Everything that matches this pattern will be removed before verifying.
	 * @return true if the number sequence is valid.
	 */
    public static boolean verify(String num, String ignore) {
    	num = num.replaceAll(ignore, "");
        return verify(num);
    }
    
    private static IllegalArgumentException createIllegalArgException(NumberFormatException e, String digit){
    	StringBuffer strBuf = new StringBuffer("");
    	strBuf.append("The number sequence contains an illegal character: '");
    	strBuf.append(digit);
    	strBuf.append("'. ");
    	strBuf.append("Please consider ignoring this character.");
    	return new IllegalArgumentException(strBuf.toString(), e);
    }
}
