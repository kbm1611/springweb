import { Route, Routes } from "react-router-dom";
import TopNavi from "./components/TopNavi";
import Home from "./components/Home";
import NotFound from "./components/NotFound";
import CommonLayOut from "./components/CommonLayOut";
import LayoutIndex from "./components/LayoutIndex";
import RouterHooks from "./components/RouteHooks";

// Exam2.jsx
export default function Exam2( props ){
    return(<>
        <TopNavi></TopNavi>
        <Routes>
            <Route path = '/' element={ <Home /> } /> {/* 라우터 설정 */}
            {/* 중텁 라우터 */}
            <Route path="/intro" element={ <CommonLayOut />}>
                <Route index element={ <LayoutIndex/> } />
                <Route path="router" element={<RouterHooks />} />
            </Route>
            <Route path = '*' element={ <NotFound /> } /> {/* 라우터 설정 */}
        </Routes>
    </>)
}