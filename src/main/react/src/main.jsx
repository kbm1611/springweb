import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'

// createRoot(document.getElementById('root')).render(
//     <App />
// )

/// chapter4 예제
import Exam2 from './chapter5/Exam2.jsx'
createRoot(document.querySelector('#root')).render(
    <Exam2 />
)