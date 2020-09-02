package wildflyRest.vote;

public class UniqueVoteException extends Exception {
    private static final long serialVersionUID = -7974483157222488930L;

    public UniqueVoteException(String message) {
        super(message);
    }
}
