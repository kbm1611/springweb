import axios from "axios";


export default function Write(props) {
    // [1] REST APU로 글쓰기 요청
    const boardWrite = async (e) =>{

        // 0) token 가져오기
        const token = localStorage.getItem( 'token' );

        e.preventDefault();
        // 1) 입력받은 값 가져오기
        const btitle = e.target.btitle.value;
        const bcontent = e.target.bcontent.value;
        const uploadFile = e.target.uploadFile.files[0];
        // value: 입력받은 자료, files : file type의 등록된 파일, files[0] : 선택된 1개 파일
        // 2) 객체 구성하지 않고 멀티(대용량)폼
        const formData = new FormData(); // 대용량 폼을 지원하는 객체
        formData.append( 'btitle', btitle ); // .aapned( 속성명 , 값 ) : 대용량폼에 속성 추가한다.
        formData.append( 'bcontent', bcontent );
        
        // 만약에 업로드 파일이 존재하면 추가
        if( uploadFile ) { formData.append( 'uploadFile', uploadFile ); }
        // 3) axios로 통신
        const response = await axios.post(
            "http://localhost:8080/api/board/addpost3", // axios 주소
             formData, // 전송할 대용량 객체
             { headers: {
                Authorization : `Bearer ${token}` // HTTP 요청 HEADER
             }}
         )

         const data = response.data;
         if( data ){
            alert('글 등록 성공!');
         }else{
            alert('글 쓰기 실패');
         }
    }

    return (
        <div>
            <h3> 글쓰기 페이지 </h3>
            <form onSubmit= { boardWrite } >
                제목 : <input name="btitle" type="text" placeholder="제목입력"/>
                내용 : <textarea name="bcontent"></textarea>
                파일 : <input name="uploadFile" type="file"/>
                <button type="submit" >등록</button>
            </form>
        </div>
    )
}