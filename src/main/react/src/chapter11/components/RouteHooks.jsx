import { useSearchParams } from "react-router-dom";


export default function RouterHooks(props){

    // [1] useSearchParams 훅 선언한다 vs const bno = new URLserachParams( location.search ) 이유 : URL 상의 쿼리스트링 값 가져오기
    const [ searchParams, setSerchParams ] = useSearchParams();
    const mode = searchParams.get( 'mode' ); // 쿼리스트링내 mode변수명 값 가져오기
    const pageNum = searchParams.get( 'pageNum' ); // 쿼리스트링내 pageNum 변수명 값 가져오기

    // [2] changeMode
    const changeMode = ( ) =>{
        //만약에 mode가 list이면 view 변경 아니면 list로 변경
        const nextMode = ( mode == 'list' ) ? 'view' : 'list';
        setSerchParams({ mode: nextMode, pageNum });
    }

    // [3] nextPage, 만약에 pageNum가 null이면
    const nextPage = ( )=>{
        let pageTemp = (pageNum == null || isNaN( pageNum )) ? 1 : parseInt( pageNum ) + 1;
        setSerchParams( {mode : mode, pageNum : pageTemp } );
    }

    // [4] prevPage, 만약에 
    const prevPage = ( ) =>{
        let pageTemp = (pageNum == null || isNaN(pageNum)) ? 1 : parseInt(pageNum) - 1;
        setSerchParams( {mode : mode, pageNum : pageTemp });
    }

    return(<>
        <h2> 라우터 관련 Hook </h2>
        <div>
            <ul>
                <li>URL : {location.pathname} </li>
                <li>쿼리스트링 : {location.search}</li>
                <li>mode : {mode}</li>
                <li>pageNum : {pageNum}</li>
            </ul>
            <button onClick={changeMode}>mode변경</button>
            <button onClick={prevPage}>이전</button>
            <button onClick={nextPage}>다음</button>
        </div>
    </>)
}