package exceptions;

public class InvalidUserInputException extends RuntimeException{
    public InvalidUserInputException(Throwable e) {
        super(e);
    }
}
