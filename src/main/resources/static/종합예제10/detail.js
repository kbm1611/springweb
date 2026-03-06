// 개별 조회 페이지

// 1] 개별 출력
const printBoard = async (bno) => {
    const detatilTableDom = document.querySelector("#boardDetail");

    const response = await axios.get(`/board/detail?bno=${bno}`);
    const data = response.data;
    console.log(data);

    let html = '';
    html += `
        제목: ${data.btitle} <br/>
        작성자: ${data.bwriter} <br/>
        내용/작성일: ${data.bcontent} / ${data.createDate}<br/>
        <button onclick="onDelete( ${data.bno} )">삭제</button> 
        <button onclick="onUpdate( ${data.bno} )">내용수정</button>
    `;
    detatilTableDom.innerHTML = html;
}

// 2] 개별 수정
const onUpdate = async (bno) => {
    const bwriter = prompt("작성자 이름을 입력하세요:");
    const btitle = prompt("수정 할 제목을 입력하세요:");
    const bcontent = prompt("수정 할 내용을 입력하세요:");

    const obj = {
        "bno" : bno,
        "bwriter" : bwriter,
        "btitle" : btitle,
        "bcontent" : bcontent,
    };

    const response = await axios.put("/board", obj);
    const data = response.data;
    if( data ){
        alert("수정 성공");
        printBoard(bno); // ****** 화면 새로고침 *******
    }
    else{ alert("수정 실패: 관리자에게 문의"); }
}

// 3] 개별 삭제
const onDelete= async (bno) => {

    const response = await axios.delete(`/board?bno=${bno}`);
    const data = response.data;

    if( data ){
        alert("삭제 성공");
        location.href = "/종합예제10/index.html";
    }
    else{ alert("삭제 실패: 관리자에게 문의"); }
}

// 페이지 로딩 시, 쿼리스트링으로 전달된 bno 값을 이용하여 개별 게시물 조회
const url = new URLSearchParams(location.search);
const bno = url.get("bno");
printBoard(bno);