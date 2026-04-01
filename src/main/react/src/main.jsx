import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'

// createRoot(document.getElementById('root')).render(
//     <App />
// )

// chapter4 예제
// import Exam1 from './chapter4/Exam1.jsx'
// createRoot(document.querySelector('#root')).render(
//     <Exam2 />
// )
// chapter5 예제
// import Exam2 from './chapter5/Exam2.jsx'
// createRoot(document.querySelector('#root')).render(
//     <Exam2 />
// )
// chapter6 예제
// import Exam1 from './chapter6/Exam1.jsx'
// createRoot(document.querySelector('#root')).render(
//     <Exam2 />
// )

// chapter7 예제
// import Exam2 from './chapter7/Exam2.jsx'
// createRoot(document.querySelector('#root')).render(
//     <Exam2 />
// )

// chapter8 예제
// import Exam1 from './chapter8/Exam1.jsx'
// createRoot(document.querySelector('#root')).render(
//     <Exam1 />
// )

// chapter9 예제
// import Exam2 from './chapter9/Exam2.jsx'
// createRoot(document.querySelector('#root')).render(
//     <Exam2 />
// )

// // chapter10 예제
// import Exam1 from './chapter10/Exam1.jsx'
// createRoot(document.querySelector('#root')).render(
//     <Exam1 />
// )

// // chapter11 예제
// import Exam2 from './chapter11/Exam2.jsx'
// import {BrowserRouter} from 'react-router-dom'; // [1] 라이브러리 import하기
// // [2] 최초 렌더링 되는 컴포넌트에 BrowerRouter 감싸기.
// createRoot(document.querySelector('#root')).render(
//     <BrowserRouter>
//         <Exam2 />
//     </BrowserRouter>
// )

// // chapter12 예제
import Exam1 from './chapter12/Exam1.jsx'
import {BrowserRouter} from 'react-router-dom';
createRoot( root ).render(
    <BrowserRouter>
        <Exam1 />
    </BrowserRouter>
)