console.log("index.js open"); //확인

// 요청 프로세스 : HTML -> JS(AXIOS) -> SPRING( Controller --> DAO ) -> MYSQL

// 1] 전체 조회 , 실행조건 : JS가 열렸을 때, 수정/등록/삭제 성공했을 때

// function onWrite() { }
const onFindAll = async ( ) => {
    // 1. 어디에    , doument.querySelector( 출력 할 위치 )
    const tbody = document.querySelector("#boardTable tbody");
    // 2. 무엇을    , 출력 할 내용물 정의
    let html = "";

        // 동기화 : 1. 현재 함수명 앞에 async 키워드 부인다. 2. axios 앞에 await 키워드 붙인다.
        const response = await axios.get("/board");
        const data = response.data;
        for(let i = 0; i <= data.length - 1; i++){
            let board = data[i];
            html += `
            <tr>
                <td> ${ board.bno } </td> <td> ${ board.bcontent } </td>
                <td> ${board.bwriter} </td> <td> ${ board.bdate } </td>
                <td> <button onclick="onDelete( ${board.bno} )">삭제</button>
                <button onclick="onUpdate( ${board.bno} )">내용수정</button> </td> 
            </tr>
            `;
        }
    // 3. 출력 , innerHtml, 출력할 위치에 내용 대입한다.
    tbody.innerHTML = html;
}
onFindAll( );

// 2] 등록 -> 등록 버튼 누를 시
const onWrite = async () => {
    // 1. DOM 객체 가져오기
    const bcontentDom = document.querySelector(" #bcontent" );
    const bwriterDom = document.querySelector( "#bwriter" );
    
    // 2. 가져온 DOM 객체 내 입력받은 값 꺼내기
    const bcontent = bcontentDom.value;
    const bwriter = bwriterDom.value;

    // 3. 입력받은 값으로 객체 구성
    const obj = {
        "bcontent" : bcontent,
        "bwriter" : bwriter
    };

    // 4. (1개월 차) 배열에 저장 -> (3개월 차) AXIOS 이용하여 서버에게 저장 요청한다.
    const response = await axios.post("/board", obj);
    const data = response.data; //false, true
    if( data ){
        alert("등록 성공");
        bcontentDom.value = ''; bwriterDom.value = ''; // 입력상자에 입력한 값들 초기화
        onFindAll(); // ****** 화면 새로고침 *******
    }
    else{ alert("등록 실패: 관리자에게 문의"); }

}

// 3] 개별 수정 -> 수정 버튼 누를 시
const onUpdate = async (bno) => {

    const bcontent = prompt("수정 할 내용을 입력하세요:");

    const obj = {
        "bno" : bno,
        "bcontent" : bcontent
    };

    const response = await axios.put("/board", obj);
    const data = response.data; //false, true

    if( data ){
        alert("수정 성공");
        onFindAll(); // ****** 화면 새로고침 *******
    }
    else{ alert("수정 실패: 관리자에게 문의"); }
}

// 4] 개별 삭제 -> 삭제 버튼 누를 시
const onDelete= async (bno) => {
    const response = await axios.delete(`/board?bno=${bno}`);
    const data = response.data; //false, true

    if( data ){
        alert("삭제 성공");
        onFindAll(); // ****** 화면 새로고침 *******
    }
    else{ alert("삭제 실패: 관리자에게 문의"); }
}