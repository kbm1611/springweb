import { useEffect, useState } from "react"
import axios from "axios";

function RandomUser(props){
    const[myJson, setMyJson] = useState({results:[]});

    const axiosApi = async() =>{
        const response = await axios.get('https://api.randomuser.me?results=10'); // 10개 데이터 요청
        const data = response.data;
        console.log( data );
        setMyJson( data );
    }

    useEffect( () => {
        axiosApi(); // 마운트 : 서버로부터 정보를 요청하자. 주로 REST API (AXIOS)
    }, []); // 딱 한 번만 실행

    let trTag = myJson.results.map((data) => {
        return(
            <tr key={data.login.md5}>
                <td><img src={data.picture.thumbnail} alt={data.login.username} /></td>
                <td><a href='/' onClick={(e)=>{
                    e.preventDefault();
                    props.onProfile(data);
                }}>{data.login.username}</a>
                </td>
                <td>{data.name.title} {data.name.first} {data.name.last}</td>
                <td>{data.nat}</td>
                <td>{data.email}</td>
            </tr>
        );
    });
    return(
        <div>
            <table border='1'>
                <thead>
                    <tr>
                        <th>사진</th><th>로그인</th><th>이름</th>
                        <th>국가</th><th>Email</th>
                    </tr>
                </thead>
                <tbody>{trTag}</tbody>
            </table>
        </div>
    );
}
// ExternalApiFetcher.jsx
export default function ExternalApiFetcher(props){
    return (<>
        <h2> 외부 서버 통신 </h2>
        <RandomUser onProfile={(data)=>{
            console.log(data);
            let info = `전화번호:${data.cell}
            성별:${data.gender}
            username:${data.login.username}
            password:${data.login.password}`;
            alert(info); // 경고창으로 내용 출력
        }}></RandomUser>
    </>);
}