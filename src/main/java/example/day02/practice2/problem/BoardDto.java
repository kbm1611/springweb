package example.day02.practice2.problem;

public class BoardDto {
    private int bno;
    private String bcontent;
    private String bwriter;
    public BoardDto(){}

    //문제 2~3번을 위한 생성자
    public BoardDto(int bno, String bcontent, String bwriter) {
        this.bno = bno;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
    }

    // 문제 1번을 위한 생성자
    public BoardDto(String bcontent, String bwriter) {
        this.bcontent = bcontent;
        this.bwriter = bwriter;
    }

    // 문제 5번을 위한 생성자
    public BoardDto(int bno, String bcontent) {
        this.bno = bno;
        this.bcontent = bcontent;
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

    public void setBno(int bno) {
        this.bno = bno;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public void setBwriter(String bwriter) {
        this.bwriter = bwriter;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", bcontent='" + bcontent + '\'' +
                ", bwriter='" + bwriter + '\'' +
                '}';
    }
}
