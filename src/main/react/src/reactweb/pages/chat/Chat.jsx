import axios from "axios"
import { useEffect, useState, useRef } from "react"

// [6] npm i @stomp/stompjs 설치
// [7] stomp 클라이언트 객체 import
import { Client } from '@stomp/stompjs'


export default function Chat(props) {

    // [8] Client 객체를 저장하는 (레퍼런스)변수, useRef vs useState
    // useRef = 특정한 상태/값 저장하고 화면 렌더링에 영향을 주지 않는 저장소.
    // useState = 렌더링에 영향을 줌.
    // useRef = { current : null } , userRef 객체내 current 속성을 갖는다.
    const client = useRef(null);

    // [4] 로그인 정보 상태 변수
    const [loginUser, setLoginUser] = useState(null);

    // [3] AXIOS 회원정보 불러오기 함수
    const getMyInfo = async () => {
        try {
            const response = await axios.get(
                "http://localhost:8080/api/member3/my/info",
                { withCredentials: true })
            setLoginUser(response.data || null); // *단축평가: 조건 && 참, 조건 || 거짓
        } catch (e) {
            console.log(e);
        }
    }

    // [14] 서버에게 받은 메시지들을 저장하는 상태변수
    const [messages, setMessages] = useState([]);

    // [5] 해당 컴포넌트 생명주기 1번
    useEffect(() => {
        getMyInfo(); // 로그인 정보 가져오기

        // [9] 웹소켓 연결하기 , new Client( { } )
        const stomp = new Client({
            brokerURL: "ws://localhost:8080/ws",
            reconnectDelay: 5000, //연동 실패시 5초 마다 재연동
            onConnect: () => {
                console.log('소켓 연결 성공');

                // [13] 메시지 구독( 서버 -> 클라이언트 )
                // stomp.subscribe( "구독주소", (받은메시지) => {} );
                stomp.subscribe("/topic/message", (msg) => {
                    console.log(msg);
                    // 1) 서버에 받은 메시지를 JSON 으로 변환, **AXIOS는 자동**
                    const data = JSON.parse(msg.body); // JSON.parse( 문자 ): 문자->JSON / JSON.stringify( 객체 ): 객체 -> 문자
                    // 2) 서버에 받은 메시지를 상태변수에 대입한다.
                    messages.push(data);
                    setMessages([...messages]); // 얕은 비교하기 때문에 ...객체 복사
                }); // 구독주소는 스프링의 소켓컨트롤러( @SendTo )에서 설정한 주소
            }
        });

        // [10] 웹소켓 실행
        stomp.activate();

        // [11] 웹소켓을 안전하게 useRef에 보관한다.
        client.current = stomp;

        // [12] 컴포넌트 언마운트 될 때
        return () => {
            // 언마운트(화면에서 컴포넌트 사라짐 ) 실행문;
            stomp.deactivate(); //안전하게 소캣 닫기
        }

    }, [])



    // [2] 입력받은 값을 저장하는 상태변수
    const [sendMsg, setSendMsg] = useState('');

    // [1] 전송 버튼 클릭시 입력받은 값 가져오기 = 서버에게 채팅 메시지 보내기
    const sendMessage = () => {
        // 1) 입력받은 값 확인하기
        console.log('입력받은 값: ', sendMsg);
        // 2) 만약에 입력한 값이 없으면 메시지 전송 안하기.
        if (sendMsg == '') {
            alert('메시지 입력하세요.'); return;
        }
        // [16] 서버에 보낼 메시지 구성( 현재 로그인한 사용자 이름, input박스 안의 메시지)
        const obj = { sender: loginUser.mname, message: sendMsg }

        // [15] 연동된 소켓에 메시지 보내기, useRef의 상태값 호출, .current
        // stomp.publish( { } )
        client.current.publish({
            destination: "/app/chat", // 메시지를 받을 서버의 주소, 스프링 소켓컨트롤러(@MessageMapping) 주소
            body: JSON.stringify(obj) // 보낼 메시지를 JSON형식의 문자열 타입, AXIOS 자동
        }); // client.current == stomp(웹소켓) [11] 보관했기 때문에.
        setSendMsg(''); // *) 메시지 전송 후 입력상자 , 초기화
    }
    return (
        <div>
            <h3> 채팅 </h3>
            <div className="contents">
                {
                    messages.map((msg) => {
                        return (
                            <div className="msgbox">
                                {loginUser && loginUser.mname == msg.sender ?
                                        (<>
                                            <div className="msg" style={ {textAlign : "right" } }> {msg.message} </div>
                                            <br/>
                                        </>) :
                                        (<>
                                            <div className="sender"> {msg.sender} </div>
                                            <div className="msg"> {msg.message} </div>
                                            <br/>
                                        </>)
                                }
                            </div>
                        )

                    })
                }


            </div>
            {/* 입력상자 value 속성에 상태변수 대입시 입력이 불가능(입력되지만렌더링이 안된 상태)하다. */}
            {/* 상태변수는 렌더링 해야한다. 방안] onChange = { }*/}
            <input value={sendMsg} onChange={(e) => { setSendMsg(e.target.value) }} />
            <button onClick={sendMessage}> 전송 </button>
        </div>
    )
}