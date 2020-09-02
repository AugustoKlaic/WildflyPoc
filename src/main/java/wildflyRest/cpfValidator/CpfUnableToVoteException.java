package wildflyRest.cpfValidator;

public class CpfUnableToVoteException extends Exception {

    private static final long serialVersionUID = 646732744556009877L;

    public CpfUnableToVoteException(String message) {
        super(message);
    }

}
