import { useEffect, useState } from 'react';
import {Link} from 'react-router-dom';
import axios from 'axios';


export default function Header(props){

    // [2] 로그인 상태 저장하는 상태변수
    const [ isLogin, setIsLogin ] = useState( false ); // 초기값은 false

    // [3] 로그인 중인 회원 정보 담는 상태변수
    const [ userInfo, setUserInfo ] = useState( null ); // 초기값은 null = 비로그인 상태

    // [1] 로그인 상태에 따라 메뉴 분기
    const getMyInfo = async () =>{
        // 1) 로그인 시 localStorage 저장한 token 가져오기 , .setItem , .getItem
        const token = localStorage.getItem( 'token' );
        // 2) 만약에 token이 없으면 함수 종료 , 로그인상태 false
        if( !token ){ setIsLogin( false ); return; }
        // 3) 헤더에 표시할 로그인된 유저 아이디 가져오기
        const response = await axios.get(
            "http://localhost:8080/api/member2/myinfo",
            { headers :{
                Authorization : `Bearer ${token}` // headers : { 속성명 : 값 }
                // * axios 특징 : Content-Type : application/json이 기본 값
                // 만약에 Content-Type이 json 아닌경우 명시한다.
            } }
        )
        // 4) 통신 결과 분기
        const data = response.data;
        console.log( data );
        if( data || data != false ){
            setIsLogin( true ); // 로그인 상태 변경
            setUserInfo( data ); // 응답 받은 자료(회원 정보)를 저장
        }else{
            setIsLogin( false ); // 비로그인 상태 변경
        }
    }

    // [4] 헤더가 열리면 최초 1번 실행 , 로그인상태(백엔드 검증해야한다. )
    useEffect( ()=>{ getMyInfo(); }, [] )

    // [5] 로그아웃
    const logout = () =>{
        // 1) localStroage에서 token 제거 , removeItem()
        localStorage.removeItem( 'token' );
        // 2) 로그인 상태 변경
        setIsLogin( false );
        alert('로그아웃'); location.href('/');
    }

    // JS 삼항연산자 , 조건 ? 참 : 거짓
    // Js 단축평가 , 조건&& 실행문 , 조건이 참이면 실행문 거짓이면 생략
    return (
        <div>
            {/* 로그인 상태에 따른 메뉴 분기 */}
            <Link to = '/'> 홈 </Link>

            {!isLogin ? (<>
                <Link to='/member/login'> 로그인 </Link>
                <Link to='/member/signup'> 회원가입 </Link>
            </>) : (<>
                <span> {userInfo.mid} 님 </span>
                <Link to='/member/page'> 내정보 </Link>
                <Link to='/board/write'> 글쓰기 </Link>
                <button onClick={ logout }> 로그아웃 </button>
            </>)}
            <hr/>
        </div>
    )
}