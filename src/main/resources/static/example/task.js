console.log("task.js exe");

// [1] 타입: JS는 동적타입이므로
    // 1. 기본 자료
console.log( 3 ); console.log( true ); console.log( 3.14 ); console.log( "안녕" );
    // 2. 배열
console.log( [3,true,3.14,"안녕"] );
    // 3. 객체/JSON
console.log( { "name" : "유재석" , "age" : 40 } )
    // 4. 함수
function func1( ){ }
// [2] 다양한 함수 형식
function func2( ) { } // 선언적 함수     - 1개월차
function ( ) { } // 익명 함수
( ) => { } // 화살표(람다표현식) 함수     - 3개월차 ( 리액트 표현 )
// [3] 화살표 함수는 익명이므로 변수에 저장한다.
const func3 = ( ) => { }