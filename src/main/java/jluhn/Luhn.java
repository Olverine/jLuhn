package jluhn;

public class Luhn {
	
	public static boolean verify(String text) throws LuhnException{
        int sum = 0;
        for(int i = 0; i < text.length(); i++){
            String digit = String.valueOf(text.charAt(text.length() - 1 - i));
            int digitVal = 0;
    		try{
    			digitVal = (Integer.parseInt(digit) * (i % 2 == 0 ? 1 : 2));
    		} catch(NumberFormatException e){
    			throw createVerificationExcpetion(e, digit);
    		}
            digitVal -= digitVal > 9 ? 9 : 0;
            sum += digitVal;
        }
        return sum % 10 == 0;
    }

    public static boolean verify(String text, String ignore) throws LuhnException{
        text = text.replaceAll(ignore, "");
        return verify(text);
    }
    
    private static LuhnException createVerificationExcpetion(NumberFormatException e, String digit){
    	StringBuffer strBuf = new StringBuffer("");
    	strBuf.append("The number can not be verified since it contains an illegal character: '");
    	strBuf.append(digit);
    	strBuf.append("'. ");
    	strBuf.append("Please consider ignoring this character.");
    	return new LuhnException(strBuf.toString(), e);
    }
}
