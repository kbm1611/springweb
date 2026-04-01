import { useEffect, useState } from "react";
import axios from 'axios';

const GlobalTop = (props) =>{
    console.log("[1] 컴포넌트 실행 ");

    const [ myList, setMyList ] = useState( [ ] ); // 빈배열을 갖는 상태 변수

    // [1] AXIOS 사용하기 , 설치 : npm-i axios, import axios from 'axios';
    const axios1 = async() => {

        // 내부 파일과 통신
        const response = await axios.get( './json/myData.json' );
        const result = response.data;
        setMyList( result );
    }

    // (1) useEffect ( () => { } ) : 최초실행, 렌더링할때마다 실행
    // (2) useEffect ( () => { }, [ ]) : 최초실행
    // (3) useEffect ( () => { }, [ 상태변수1, 상태변수2 ] ) : 최초실행, 특정상태변수가 변경될 때 마다
    useEffect( () =>{ 
        console.log('[3]useEffect 실행')
        axios1();
    }, [ ])

    // [3] 현재 상태(myList => json => axios ) 정보를 반복하여 html 구성 함수
    // 리스트/배열변수명.map( (반복변수) => { return (<> JSX </> ) } ) // 주로 HTML 구성할 때 사용한다.
    let listTag = myList.map( (data) =>{
        // 첫번째 반복 data = {"num": 1 ... "cell" : "(02) 235-1111"}
        return(
            <li key={data.id}>
                <a href={ data.id } data-id={data.num} onClick={(e) =>{
                    e.preventDefault();
                    props.myLinkClick( e.target.dataset.id );
                }}> { data.id } </a>
            </li>
        )
    });
    // 변수예측 listTag = <li> <a> yu </a> </li>

    console.log('[2] return 실행');
    return (
        <nav>
            <ul>
                {listTag}
            </ul>
        </nav>
    );
}

const ContentBody = (props)=>{
    return(
        <div>
            <h2>{props.myResult.name}</h2>
            <ul>
                <li>num : {props.myResult.num} </li>
                <li>id : {props.myResult.id} </li>
                <li>cell : {props.myResult.cell} </li>
                <li>description : {props.myResult.description} </li>
            </ul>
        </div>
    );
}

export default function LocalJsonFetcher(props){
    const [myResult, setMyResult] = useState({});
    return(<>
    <h2>내부 서버 통신</h2>
    <GlobalTop myLinkClick={async(num)=>{
        console.log('클릭', num);

        // fetch 대신에 axios
        const response = await axios.get(`./json/dto${num}.json`);
        const result = response.data;

        setMyResult( result );
    }}></GlobalTop>
    <ContentBody myResult={myResult}></ContentBody>
    </>)
}

