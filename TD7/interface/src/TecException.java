package tec;

public class TecException extends Exception{
    TecException(String message) {
	super(message);
    }
    
    TecException(Exception e) {
	super(e);
    }
}
