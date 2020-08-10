package wildflyRest.dto.output;

public class VoteResultOutput {

    private Integer yes;
    private Integer no;
    private Integer total;

    public VoteResultOutput(Integer yes, Integer no, Integer total) {
        this();
        this.yes = yes;
        this.no = no;
        this.total = total;
    }

    public VoteResultOutput() {
    }

    public Integer getYes() {
        return yes;
    }

    public void setYes(Integer yes) {
        this.yes = yes;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
