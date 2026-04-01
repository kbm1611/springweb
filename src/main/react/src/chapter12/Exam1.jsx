import { Route, Routes } from "react-router-dom";
import TopNavi from "./components/TopNavi";
import LifeCycle from "./components/LifeCycle";

export default function Exam1(props){
    return (<>
        <TopNavi></TopNavi>
        <Routes>
            <Route path = '/' element={<LifeCycle />} />
            {/* <Route path = '/local' element={<LocalJsonFetcher />} /> */}
            {/* <Route path = '/external' element={<ExternalApiFetcher />} /> */}
        </Routes>
    </>)
}