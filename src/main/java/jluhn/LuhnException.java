package jluhn;

public class LuhnException extends Exception {
	private static final long serialVersionUID = 1L;

	public LuhnException(String msg, Throwable cause){
		super(msg, cause);
	}
}
