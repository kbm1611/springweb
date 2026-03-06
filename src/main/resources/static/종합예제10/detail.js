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
        "bno": bno,
        "bwriter": bwriter,
        "btitle": btitle,
        "bcontent": bcontent,
    };

    const response = await axios.put("/board", obj);
    const data = response.data;
    if (data) {
        alert("수정 성공");
        printBoard(bno); // ****** 화면 새로고침 *******
    }
    else { alert("수정 실패: 관리자에게 문의"); }
}

// 3] 개별 삭제
const onDelete = async (bno) => {

    const response = await axios.delete(`/board?bno=${bno}`);
    const data = response.data;

    if (data) {
        alert("삭제 성공");
        location.href = "/종합예제10/index.html";
    }
    else { alert("삭제 실패: 관리자에게 문의"); }
}

const printReply = async () => {
    const replyBoxDom = document.querySelector("#replyBox");

    let html = `
    <div>
            댓글작성자 : <input id="cwriter" /> <br />
            댓글내용 : <textarea id="ccontent"></textarea> <br />
            <button onclick="onReplyWrite(${bno})"> 댓글등록 </button>
        </div>
        <table>
            <th> 작성자 </th> <th> 내용 </th> <th> 작성일 </th> <th> 비고 </th>
            <tbody id="replyTable">
            </tbody>
        </table>`;
    replyBoxDom.innerHTML = html;
    printReplyList(bno);
}

// 4] 댓글 출력
const printReplyList = async (bno) => {
    const replyTableDom = document.querySelector("#replyTable");

    const response = await axios.get(`/comment?bno=${bno}`);
    const data = response.data;

    let html = '';
    for (let i = 0; i <= data.length - 1; i++) {
        let comment = data[i];
        html += `
        <tr>
            <td> ${comment.cwriter} </td>
            <td> ${comment.ccontent} </td>
            <td> ${comment.createDate} </td>
            <td> <button onclick="onDeleteReply( ${comment.cno} )">삭제</button>
            <button onclick="onUpdateReply( ${comment.cno} )">수정</button> </td>
        </tr>
        `;
    }
    replyTableDom.innerHTML += html;
}

// 5] 댓글 등록
const onReplyWrite = async () => {
    const cwriterDom = document.querySelector("#cwriter");
    const ccontentDom = document.querySelector("#ccontent");
    const cwriter = cwriterDom.value;
    const ccontent = ccontentDom.value;

    const obj = {
        "bno": bno,
        "cwriter": cwriter,
        "ccontent": ccontent
    };

    const response = await axios.post("/comment", obj);
    const data = response.data;
    if (data) {
        alert("댓글 등록 성공")
        cwriterDom.value = ''; ccontentDom.value = '';
        printReply();
    } else {
        alert("댓글 등록 실패: 관리자에게 문의");
    }
}

// 6] 댓글 삭제
const onDeleteReply = async (cno) => {
    const response = await axios.delete(`/comment?cno=${cno}`)
    const data = response.data;
    if (data) {
        alert("댓글 삭제 성공");
        printReply();
    } else {
        alert("댓글 삭제 실패: 관리자에게 문의");
    }
}

// 7] 댓글 수정
const onUpdateReply = async (cno) => {
    const ccontent = prompt("수정 할 댓글 내용을 입력하세요:");
    const cwriter = prompt("수정 할 댓글 작성자 이름을 입력하세요:");

    const obj = {
        "cno": cno,
        "ccontent": ccontent,
        "cwriter": cwriter
    };

    const response = await axios.put("/comment", obj);
    const data = response.data;
    if (data) {
        alert("댓글 수정 성공")
        printReply();
    } else {
        alert("댓글 수정 실패: 관리자에게 문의");
    }
}

// 페이지 로딩 시, 쿼리스트링으로 전달된 bno 값을 이용하여 개별 게시물 조회
const url = new URLSearchParams(location.search);
const bno = url.get("bno");
printBoard(bno);
printReply(bno);