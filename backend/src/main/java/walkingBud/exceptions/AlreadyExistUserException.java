package walkingBud.exceptions;

public class AlreadyExistUserException extends RuntimeException {

    public AlreadyExistUserException() {
        super("User already exists");
    }
}
