import { Outlet } from "react-router-dom";

export default function CommonLayOut(props){
    return(
        <div>
            <header style={{ background: 'lightgray' , padding: '10px' }}>
                Outlet 컴포넌트 알아보기
            </header>
            <article>
                <Outlet /> {/*자식 컴포넌트가 들어갈 자리*/}
            </article>
            <footer style={{ background: 'lightgray' , padding: '10px' }}>
                공통 레이아웃
            </footer>
        </div>
    )
}