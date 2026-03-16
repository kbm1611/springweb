package example.day10;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exam4 {
    public static void main(String[] args) {

        // 메소드 레퍼런스 API : 이미 정의된 메소드를 참조하여 사용하는 표현식
        // [1] 일반메소드 , member.add( 3, 4 )
        // [2] 람다메소드 , ( 3, 4 ) -> { }
        // [3] 레퍼런스API , member ::add( 3 , 4 )

        // [1] static 정적메소드 예시
        Integer.parseInt( "10" ); // Integer.parseInt( 문자 ); 문자->정수 타입 함수

        Function<String, Integer> function = Integer :: parseInt; // 콜론 ; 세미콜론
        function.apply("10");

        // [2] 일반 메소드 예시
        List<String> names = List.of("유재석", "강호동", "신동엽", "서장훈"); // 샘플
            // 2-1 for문
        for(int i = 0; i < names.size(); i++) System.out.println("[2-1]: " + names.get(i) );
            // 2-2 forEach문
        names.stream().forEach( (x) -> {
            System.out.println("[2-2]: " + x);
        });
            // 2-3 forEach문 + 래퍼런스API
        names.stream().forEach( System.out::println );

        // [3] 생성자 예시
            // 3-1 for 문
        for(int i = 0; i < names.size(); i++){
            Post post = new Post( names.get(i) );
        }
            // 3-2 forEach문
        names.stream().forEach((x) -> { new Post( x ); });
            // 3-3 forEach문 + 래퍼런스API
        names.stream().forEach( Post::new );
            // ** 활용
        //
        List<Post> postList = names.stream().map(Post::new).collect(Collectors.toList());
    }
}
class Post{
    String name;
    Post(String name){
        this.name = name;
    }
}
/*
    List<BoardDto> list = entityList.stream().amp( entity :: toDto ).collect( Collectors.toList() );
*/
