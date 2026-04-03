import axios from "axios";


export default function SignUp(props){
    // [1] REST API에게 AXIOS로 통신하기
    const signup = async( e ) => {
        e.preventDefault(); // form 마크업의 기본 이벤트 제거
        // 1) 입력받은 값 가져오기
        const mid = e.target.newMid.value;
        const mpwd = e.target.newMpwd.value;
        const mname = e.target.newMname.value;
        // 2) 객체 구성 : 전송할 내용
        const obj = { mid, mpwd, mname };
        // 3) axios 동기 통신
        const response = await axios.post("http://localhost:8080/api/member/signup", obj);

        // 4) 결과 확인
        const data = response.data;
        if(data){
            alert('회원가입 성공');
            location.href="/member/login"; // 로그인 페이지로 이동
        }else{
            alert('회원가입 실패');
        }
    }

    return(<>
        <div>
            <h3> 회원가입 페이지 </h3>
            <form onSubmit={signup} > {/* 통신함수 연동 */}
                생성할 아이디 : <input name="newMid" placeholder="아이디 입력" /> <br />
                생성할 비밀번호 : <input name="newMpwd" type="password" placeholder="비밀번호 입력" /> <br />
                생성할 닉네임 : <input name="newMname" placeholder="닉네임 입력" /> <br />
                <button type="submit"> 회원가입 </button>
                 {/* submit : 현재 form 안에 있는 마크업들 전송 이벤트 */}
             </form>
        </div>
    </>)
}