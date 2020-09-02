package wildflyRest.cpfValidator;

public class InvalidCpfException extends Exception {
    private static final long serialVersionUID = -1744010522564134650L;

    public InvalidCpfException(String message) {
        super(message);
    }

}
