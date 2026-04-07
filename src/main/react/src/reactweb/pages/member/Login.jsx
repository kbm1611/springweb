import axios from 'axios';

export default function Login( props ){

    // [1] REST API에게 AXIOS로 통신하기
    const login = async( e ) => {
        e.preventDefault(); // form 마크업의 기본 이벤트 제거
        // 1) 입력받은 값 가져오기
        const mid = e.target.mid.value;
        const mpwd = e.target.mpwd.value;
        // 2) 객체 구성 : 전송할 내용
        const obj = { mid, mpwd };
        // 3) axios 동기 통신
        const response = await axios.post("http://localhost:8080/api/member3/login",
            obj , // 통신할 서버에게 전송할 값(변수)
            { withCredentials : true } // 통신할 서버에게 쿠키값 통신
        );
        // 4) 인증 결과 확인 ( HTTP headers 에 Authorization 속성 확인 )
        // let token = response.headers['authorization'];
        // // 5) 인증 결과 분기
        // if(token && token.startsWith("Bearer ") ){ // Bearer 뒤로 띄어쓰기 주이
        //     token = token.substring(7);
        // }
        if(response.data == true){
            /* 페이지 이동하기 전에 localStorage에 토큰 저장, 예] 글쓰기할 경우 token이 필요하다. */
            // localStorage.setItem( "token", token ); // token 이라는 이름으로 서버로 부터 받은 token 저장
            alert('로그인성공');
            location.href="/"; // 메인페이지 이동, 주의할점 : navigate 대신에 location
        }else{
            alert('로그인 실패');
        }
    }

    return(<>
        <div>
            <h3> 로그인 페이지 </h3>
            <form onSubmit={login} > {/* 통신함수 연동 */}
                아이디 : <input name="mid" placeholder="아이디 입력" /> <br/>
                비밀번호 : <input name="mpwd" type="password" placeholder="비밀번호 입력" /> <br />
                <button type="submit"> 로그인 </button>
                 {/* submit : 현재 form 안에 있는 마크업들 전송 이벤트 */}
             </form>
        </div>
    </>)
}