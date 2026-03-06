// 프론트
// index - 전체 조회, 등록
// detail - 개별 조회, 수정, 삭제
// write - 등록 페이지


// 1] 전체 게시물리스트 조회
const printBoardList = async () => {
    const boardTableDom = document.querySelector("#boardTable");
    boardTableDom.innerHTML = ''; // 초기화


    const response = await axios.get("/board");
    const data = response.data;
    console.log(data);

    let html = '';
    for (let i = 0; i <= data.length - 1; i++) {
        let board = data[i];
        html += `
        <tr>
            <td> ${board.bno} </td>
            <td> <a href="/종합예제10/detail.html?bno=${board.bno}"/> ${board.btitle} </a> </td>
            <td> ${board.bwriter} </td>
            <td> ${board.createDate} </td>
        </tr>
        `;
    }
    boardTableDom.innerHTML = html;
}
printBoardList();