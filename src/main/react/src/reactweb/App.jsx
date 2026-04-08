import { Route, Routes } from 'react-router-dom';
import Login from './pages/member/Login';
import Write from './pages/board/Write';
import Header from './components/Header';
import Signup from './pages/member/Singup';
import Board from './pages/board/Board';
import View from './pages/board/View';
import Chat from './pages/chat/Chat';


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
                <Route path='board' element={ <Board />} />
                <Route path='/board/view' element={ <View />} />
                <Route path='/chat' element={ <Chat />} />
            </Routes>
            {/* 푸터 */}
        </div>
    )
}