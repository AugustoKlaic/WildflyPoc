package wildflyRest.session;

public class SessionClosedException extends Exception{
    private static final long serialVersionUID = 7471865031832996129L;

    public SessionClosedException(String message) {
        super(message);
    }
}
