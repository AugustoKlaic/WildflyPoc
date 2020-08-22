package wildflyRest.dto.output;

public class VoteResultOutput {

    private long yes;
    private long no;
    private long total;

    public VoteResultOutput(long yes, long no, long total) {
        this();
        this.yes = yes;
        this.no = no;
        this.total = total;
    }

    public VoteResultOutput() {
    }

    public long getYes() {
        return yes;
    }

    public void setYes(long yes) {
        this.yes = yes;
    }

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
