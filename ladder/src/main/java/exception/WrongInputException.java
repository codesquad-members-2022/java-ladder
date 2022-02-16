package exception;

public class WrongInputException extends RuntimeException{

    public WrongInputException() {
        super();
    }

    public WrongInputException(String message) {
        super(message);
    }
}
