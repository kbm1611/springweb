
// 컴포넌트 만드는 방법
// 1. 해당 폴더를 오른쪽 클릭 -> [new file]
// 2. 첫글자가 대문자로 시작하는 .jsx 파일확장자로 생성한다.
// 예] Exam1.jsx
// 4. 컴포넌트 내 return ( <> JSX문법 </> )

// (1) FrontComp 컴포넌트 생성
function FrontComp(props) {
    const liRows = []; // 빈 배열 선언
    for (let i = 0; i < props.prosData1.length; i++) {
        liRows.push(
            <li key={i}>{props.prosData1[i]}</li>); // 배열에 요소 추가
    }
    return (<>
        <li> {props.frTitle} </li>
        <ul>
            {liRows}
        </ul>
    </>);
}

const BackComp = ({ prosData2, baTitle }) => {
    const { a, b } = { a: 1, b: 2 }; // 구조분해, 즉] 객체 내 값들을 각 변수로 분해
    console.log(a); // 구조분해 한 변수를 사용한다.

    const liRows = []
    let keyCnt = 0;
    for (let row of prosData2) {
        liRows.push(
            <li key={keyCnt++}>{row}</li>
        );
    }
    return (<>
        <li> {baTitle} </li>
        <ul>
            {liRows}
        </ul>
    </>);
}
function MyComponent(props) {
    // props에 존재하지 않은 속성명은 출력되지 않는다. < 상위 컴포넌트에서 전달받은 속성명과 속성값만 사용가능. >
    return (<>
        <p> {props.p1}, {props.p2}, {props.p3}, {props.p4}, {props.p5} </p>
    </>);
}

/* (2) 구조분해 사용하여 필요한 속성만 받기 */
function MyComponent2( { p1, p3 } ){
    return (<>
        <p> {p1}, {p3} </p>
    </>);
}

function Exam1() {

    const frontData = ['HTML', 'CSS3', 'JavaScript', 'JQuery'];
    const backData = ['Java', 'Oracle', 'JSP', 'Spring Boot'];

    return (<>
        <h3> props 객체 p.90 </h3>
        <MyComponent p1 = {"HTML"} p2 = {"CSS"} p3 = {"JavaScript"} p4 = {"JQuery"} />
        <MyComponent2 p1 = {"HTML"} p2 = {"CSS"} p3 = {"JavaScript"} p4 = {"JQuery"} />

        <h3> 프롭스 예제 p.87 </h3>
        <ol>
            <FrontComp frTitle="프론트엔드" prosData1={frontData} />
            <BackComp baTitle="백엔드" prosData2={backData} />
        </ol>

    </>);
}
export default Exam1; // 내보내기