package example.day10;

import java.util.List;
import java.util.stream.Collectors;

public class Exam3 {
    public static void main(String[] args) {

        // 람다표현식 , ( 매개변수 ) -> { 구현부 }
        // 스트림API: 데이터(매개변수) --> 중간연산 --> 최종출력

        List<Integer> number = List.of( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10); // 임의의 데이터를 담고 있는 리스트

        // [1] 리스트변수명.stream().forEach( );  , 중간연산 없이 바로 최종출력
        //매개변수에 반복변수를 하나씩 대입하여 return 없는 반복문
        number.stream().forEach( (x) -> {
            System.out.print( x*2 + "\t" );
        });
        System.out.println();
        // [2] 리스트변수명.stream().map( 중간 연산 ).collect( 최종출력 );
            // 매개변수에 반복변수를 하나씩 대입하여 return 있는 반복문, 반복 return 값을 .collect( Collectors.toXXX() ); 반환 받는
        List<Integer> result = number.stream().map( (x) -> x*2 ).collect(Collectors.toList());
        System.out.println("result = " + result);

        //[3] 리스트변수명.stream().map( 중간연산 ).forEach( 최종출력 );
        number.stream().map( (x) -> x*2).forEach( (y ) -> {
            System.out.println("result = " + y ); // 최종출력 : 중간연산 결과
        });

        //[4] 리스트변수명.stream().filter( 중간연산 ).forEach( 최종출력 );
        number.stream().filter(x -> x % 2 == 0).forEach( y -> System.out.println("result = " + y ));

        // [5]
        number.stream().sorted().forEach(y -> System.out.println("result = " + y));

        // [6]
        number.stream().distinct( ).collect(Collectors.toList());

        // [7]
        number.stream().limit(5 ).forEach(y -> System.out.println("result = " + y));

        /*
            스트림이란? 데이터의 연속적인 흐름
                - 데이터들 ---> 중간연산 ---> 최종연산
                - 중간연산은 여러개 가능
                - 최종연산은 반드시 1개 가능
            주요 연산
                - 중간 연산 : .map( ) .filter( ) .sorted( ) .distinct( ) .limit( )
                -  최종 연산 : forEach( ) collect( )
        */
    }
}
