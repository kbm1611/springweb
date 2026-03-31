
// 컴포넌트 생성 : export default function 컴포넌트명( props ) { return JSX문법 }

import { useState } from "react"

// 컴포넌트2
const TopComp = ({MyData}) =>{
    // const 상수 , let 변수
    // ( 매개변수 ) => { } 화살표함수 , function( 매개변수 ){ } 익명함수 vs function 함수명( 매개변수 ) { } 선언적함수
    // {MyData} : 구조분해 : 상위컴포넌트로부터 props 객체를 구조화 해서 변수로 받기( props객체 내 MyData 속성값 변수로 받기 )
    // return : 함수의 반환값
    // 리액트JSX return : JSX 반환
    // JSX이란? HTML + JS 조합된 문법
    // JSX 주석? {/* 주석 */}
    // JAVA MAP , 배열/리스트.stream.map( (반복변수) -> { } ) collector
    // JS MAP , 배열/리스트.map( ( 반복변수 ) => { } ) 리턴문에서 반환값이 필요하기 때문에
        // FOREACH( return X ) VS MAP( return O )
        // JSX 문법에서 반복된 자료를 HTML로 구성하여 반환하는 구조 다수 , MAP이 많이 활용됨.
    return (<>
        {/*주석처리*/}
        <ol>
            <li>프론트엔드</li>
            <ul>
                {MyData.front.map( (item, i) => <li key = { i } > {item} </li>)}
            </ul>
            <li>백엔드</li>
            <ul>
                {MyData.back.map((item, i) => <li key={i}> {item} </li>)}
            </ul>
        </ol>
    </>)

}

export default function Exam1( props ){
    const [ MyData , setMyData ] = useState( {
         front : [ 'HTML' , 'CSS3', 'JavaScript', 'Jquery' ],
         back : [ 'Java', 'Oracle', 'JSP', 'Spring Boot' ]
        })
    // 예] const [ a , b ] = { a : 1 , b : 2 }
    // a에는 1, b에는 2
    // userState 훅(hook : 갈고리-연결 상태/값/데이터 <-- 갈고리 --> 컴포넌트 )
        // 즉] 상태(state)가 (*주소/참조)값 변경되면 컴포넌트 렌더링 된다.
        // const [ 상태명 , set상태명 ] = useState( 초기값 );
    // 리터럴 : 키보드로부터 입력받은 상수 자료
        // let  a = 3; 주소값 2개(상수에 대한 주소, 변수에 대한 주소)
    
    // 1] 렌더링 안되는 코드
    const addFront = ( ) => {MyData.front.push( 'React' ); setMyData( MyData ); } // 상태는 값변경 감지 하지 않고 상태의 주소값 변경을 감지한다.( 얕은 비교 )

    // 2] 렌더링 되는 코드 , ... { 기존객체 } , [ ...기존배열 ] , { ...기존객체 , 속성명.값 } , [ ...기존배열 , 값 ]
    const addBack = ( ) => { const newBack = [ ...MyData.back , 'Node.js'  ];
        const newMyData = { ...MyData , back : newBack };
        setMyData( newMyData );
    }

    return <>
        <h2> Chapter 10 </h2>
        <TopComp MyData = { MyData } />
        <button type="button" onClick={ addFront }> 프론트추가 </button>
        <button type="button" onClick={ addBack }> 백엔드추가 </button>
    </>
}
// onclick : HTML코드 , onClick : JSX코드(가상DOM)
// 리액트가 가상DOM을 사용하는 이유 : HTML이 객체지향이 아니라서 HTML를 객체지향으로 만든 구조 JSX
// DOM : document object model : html 마크업들을 객체지향