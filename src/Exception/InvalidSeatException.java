package Exception;

public class InvalidSeatException extends Exception{
	
	    private static String message;

		public InvalidSeatException(String string) {
	    	super(message);
	}
}

