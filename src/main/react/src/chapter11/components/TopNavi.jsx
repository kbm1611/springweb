import { Link, NavLink } from 'react-router-dom'; // Link, NavLink 컴포넌트 임포트

export default function topNavi(props) { // 상단메뉴/바 = 헤더메뉴 컴포넌트
    return (
        <nav>
            <a href = "/"> Home </a>
            <NavLink to = "/intro"> 인트로 </NavLink>
            <NavLink to = "/intro/router"> Router관련Hook </NavLink>
            <Link to = "/xyz"> 잘못된URL </Link>
        </nav>
    )
}