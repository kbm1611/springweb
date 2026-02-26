
// 출석 등록
const obj1 = {"ano" : 2,"studentName" : "홍길동", "date" : "2026-02-26", "status" : "출석"};
const func1 = async( ) => {
    try{
        const response =
            await axios.post("/day03/practice3/attendance", obj1)
        console.log( response.data );
    }catch( e ){ console.log(e); }
}

// 출석 전체 조회
const func2 = async( ) => {
    try{
        const response =
            await axios.get("/day03/practice3/attendance")
        console.log( response.data );
    }catch( e ){ console.log(e); }
}

// 출석 개별 조회
const func3 = async( ) => {
    try{
        const response =
            await axios.get("/day03/practice3/attendance/detail?ano=1")
        console.log( response.data );
    }catch( e ){ console.log(e); }
}

// 출석 삭제
const func4 = async( ) => {
    try{
        const response =
            await axios.delete("/day03/practice3/attendance?ano=1")
        console.log( response.data );
    }catch( e ){ console.log(e); }
}

// 출석 수정
const obj2 = {"ano" : 1, "status" : "지각"};
const func5 = async( ) => {
    try{
        const response =
            await axios.put("/day03/practice3/attendance", obj2)
        console.log( response.data );
    }catch( e ){ console.log(e); }
}