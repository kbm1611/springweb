//등록

const onWrite = async () => {
    // 1. DOM 객체 가져오기
    const btitleDom = document.querySelector(" #btitle" );
    const bcontentDom = document.querySelector(" #bcontent" );
    const bwriterDom = document.querySelector( "#bwriter" );

    // 2. 가져온 DOM 객체 내 입력받은 값 꺼내기
    const btitle = btitleDom.value;
    const bcontent = bcontentDom.value;
    const bwriter = bwriterDom.value;

    // 3. 입력받은 값으로 객체 구성
    const obj = {
        "btitle" : btitle,
        "bcontent" : bcontent,
        "bwriter" : bwriter
    };

    // 4. AXIOS 이용하여 서버에게 저장 요청
    const response = await axios.post("/board", obj);   
    const data = response.data; //false, true
    if( data ){
        alert("등록 성공");
        // 입력상자에 입력한 값들 초기화
        btitleDom.value = ''; bcontentDom.value = ''; bwriterDom.value = '';
        location.href = "/종합예제10/index.html"; //목록으로
    }
    else{ alert("등록 실패: 관리자에게 문의"); }
}