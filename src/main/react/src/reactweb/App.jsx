import { Route, Routes } from 'react-router-dom';
import Login from './pages/member/Login';
import Write from './pages/board/Write';
import Header from './components/Header';
import Signup from './pages/member/Singup';


export default function App(props){
    return(
        <div>
            {/* 헤더 */}
            <Header />
            <Routes>
                {/* 본문들 */}
                <Route path="/member/login" element={<Login />} />
                <Route path='/member/signup' element={<Signup />} />
                <Route path='/board/write' element={<Write />} />
            </Routes>
            {/* 푸터 */}
        </div>
    )
}