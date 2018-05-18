package jluhn;

public class Luhn {
	
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

    public static boolean verify(String num, String ignore) {
    	num = num.replaceAll(ignore, "");
        return verify(num);
    }
    
    private static IllegalArgumentException createIllegalArgException(NumberFormatException e, String digit){
    	StringBuffer strBuf = new StringBuffer("");
    	strBuf.append("The number can not be verified since it contains an illegal character: '");
    	strBuf.append(digit);
    	strBuf.append("'. ");
    	strBuf.append("Please consider ignoring this character.");
    	return new IllegalArgumentException(strBuf.toString(), e);
    }
}
