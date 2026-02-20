package example.종합.예제8.model.dao;

import example.종합.예제8.model.dto.BoardDto;

import java.sql.*;
import java.util.ArrayList;

public class BoardDao {
    private BoardDao(){
        connect();
    }
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){ return instance; }

    // ====== 데이터베이스 연동 ====== //
        // 1) 연동할 db서버의 정보
    private String url = "jdbc:mysql://localhost:3306/boardservice7";
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

    // [1] 게시물 등록
    public boolean write(String bcontent, String bwriter){
        try{
            // 1) SQL 작성한다. 저장 -> C -> INSERT , ?와일드카드 기호로 변수값이 들어갈 자리 뜻한다.
            String sql = "insert into board( bcontent , bwriter ) values( ?, ? )";
            // 2) 연동된(Conn) 인터페이스에 SQL 기재한다. 반환 preparedStatement 준비된
            PreparedStatement ps = conn.prepareStatement( sql );
            // 3) SQL 기재된(PS) 인터페이스에 매개변수 대입
            ps.setString( 1, bcontent ); // ps.set타입명( ?순서번호 , 값);
            ps.setString( 2, bwriter );
            // 4) 매개변수까지 대입하여 준비가 끝났으면 sql 실행 , ps.executeUpdate();
            int count = ps.executeUpdate();
            // 5) SQL 실행 후 반영된 레코드 수에 따른 결과 제어
            if( count == 1 ){ return true; } // 등록한 레코드 수가 1이면 등록 성공
            else{ return false; } // 아니면 실패
        }catch ( SQLException e){
            System.out.println("[시스템오류] SQL 문법 문제 발생");
        }
        return false; //실패
    }

    // [4] 게시물 삭제 dao
    public boolean delete( int bno ){
        try{
            // 1] SQL 작성한다, ?는 매개변수 값이 들어갈 자리
            String sql = "delete from board where bno = ?";
            // 2] 연동된[conn] 인터페이스에 SQL 기재한다. + 일반예외
            PreparedStatement ps = conn.prepareStatement( sql );
            // 3] ?와일드카드에 매개변수 대입, ps.setXXX( ?순서번호, 값 )
            ps.setInt( 1, bno );
            // 4] SQL 실행한다. , 실행 후 반영된 레코드 수
            int count = ps.executeUpdate();

            // 5] 결과
            if( count == 1 ){ return true; } // 등록한 레코드 수가 1이면 등록 성공
            else{ return false; } // 아니면 실패
        }catch ( SQLException e){
            System.out.println("[시스템오류] SQL 문법 문제 발생");
        }
        return false;
    }
    // [3] 게시물 수정 dao
    public boolean update( int bno, String bcontent ){

        try{
            String sql = "update board set bcontent = ? where bno = ?";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setString( 1, bcontent );
            ps.setInt( 2, bno );

            int count = ps.executeUpdate();

            if( count == 1 ){ return true; } // 등록한 레코드 수가 1이면 등록 성공
            else{ return false; } // 아니면 실패
        }catch ( SQLException e ){
            System.out.println("[시스템오류] SQL 문법 문제 발생");
        }
        return false;
    }

    // [2] 게시물 전체 조회 dao
    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> boards = new ArrayList<>();
        try{
            String sql = "select * from board";
            PreparedStatement ps = conn.prepareStatement( sql );
            // 3] SQL 매개변수 대입 -> ? 없으므로 생략
            ResultSet rs = ps.executeQuery(); // 4] sql 실행 후 몇개 조회 했는지가 아닌 조회 결과 테이블 제어
            // executeUpdate():insert/update/delete vs executeQuery() : select
            // ResultSet : select 결과물을 제어하는 인터페이스 , rs.next() : 조회 결과에서 다음레코드 이동
                // rs.next() : 조회 결과에서 다음 레코드 1번 이동, 만약에 레코드가 10개이면 next 10번
            while( rs.next() ){ // while( 논리 ) { } 반복문
                // rs.get타입명( 속성명 ) : 현재 레코드의 속성 값 호출
                int bno = rs.getInt( "bno"); String bcontent = rs.getString("bcontent");
                String bwriter = rs.getString("bwriter"); String bdate = rs.getString("bdate");
                // DTO 만들기
                BoardDto boardDto = new BoardDto(bno, bcontent, bwriter, bdate);
                // 리스트(배열) 저장
                boards.add( boardDto );
            }
            if( boards != null){ return boards; }
            else{ return null; }
        }catch ( SQLException e){
            System.out.println("[시스템오류] SQL 문법 문제 발생");
        }
        return boards;
    }
}
