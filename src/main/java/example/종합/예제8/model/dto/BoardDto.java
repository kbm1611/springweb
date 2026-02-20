package example.종합.예제8.model.dto;

public class BoardDto {
    int bno;
    String bcontent;
    String bwriter;
    String bdate;

    public BoardDto(){}
    public BoardDto(int bno, String bcontent, String bwriter, String bdate) {
        this.bno = bno;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
        this.bdate = bdate;
    }

    public int getBno() {
        return bno;
    }

    public String getBcontent() {
        return bcontent;
    }

    public String getBwriter() {
        return bwriter;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public void setBwriter(String bwriter) {
        this.bwriter = bwriter;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", bcontent='" + bcontent + '\'' +
                ", bwriter='" + bwriter + '\'' +
                ", bdate='" + bdate + '\'' +
                '}';
    }
}
