package 종합.예제9.model.dao;

import 종합.예제9.model.dto.BoardDto;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class BoardDao {
    public BoardDao(){ connect(); } //생성자만! 싱글톤은 날려도 됨 -> Component가 해줌
    // ====== 데이터베이스 연동 ====== //
    // 1) 연동할 db서버의 정보
    private String url = "jdbc:mysql://localhost:3306/boardservice9";
    private String user = "root"; private String password = "1234";
    // 2) 연동 인터페이스 변수
    private Connection conn;
    // 3) 연동 함수 선언, dao에 생성자에서 함수 실행 ( dao 싱글톤이 생성되면서 db에 연동 실행 )
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // mysql 라이브러리 객체 메모리할당/불러오기
            conn = DriverManager.getConnection( url, user, password ); // mysql 구현체로 db연동후 연동 인터페이스에 반환
            System.out.println("[준비] 데이터베이스 연동 성공");
        }catch ( Exception e){
            System.out.println("[경고] 데이터베이스 연동 실패 : 관리자에게 문의");
        }
    }

    // 1] 전체조회
    public List<BoardDto> findAll() {
        List<BoardDto> boardDtoList = new ArrayList<>();
        try {
            String sql = "select * from board";
            PreparedStatement ps = conn.prepareStatement( sql );
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){

                BoardDto boardDto = new BoardDto(
                        rs.getInt("bno"), rs.getString("bcontent"),
                        rs.getString("bwriter"), rs.getString("bdate"));
                boardDtoList.add(boardDto);

            }
        } catch (Exception e) { System.out.println(e); }
        return boardDtoList;
    }

    // 2] 게시물 등록
    public boolean write(BoardDto boardDto){
        try {
            String sql = "insert into board( bcontent , bwriter ) values( ? , ?)";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setString( 1, boardDto.getBcontent() );
            ps.setString( 2, boardDto.getBwriter() );

            int count = ps.executeUpdate();

            if(count == 1){ return true; }
            else{ return false; }
        } catch (Exception e) { System.out.println(e); }
        return false;
    }

    // 3] 게시물 개별 수정
    public boolean update(BoardDto boardDto){
        try {
            String sql = "update board set bcontent = ? where bno = ?";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setString( 1, boardDto.getBcontent() );
            ps.setInt( 2, boardDto.getBno() );

            int count = ps.executeUpdate();

            if(count == 1){ return true; }
            else{ return false; }
        } catch (Exception e) { System.out.println(e); }
        return false;
    }

    // 4] 게시물 삭제
    public boolean delete(int bno){
        try {
            String sql = "delete from board where bno = ?";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setInt( 1, bno );

            int count = ps.executeUpdate();

            if(count == 1){ return true; }
            else{ return false; }
        } catch (Exception e) { System.out.println(e); }
        return false;
    }

}
