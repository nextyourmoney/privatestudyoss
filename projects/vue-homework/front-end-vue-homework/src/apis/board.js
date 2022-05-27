import axios from "axios";

//게시물 목록 요청 //통신 모듈처럼사용된다
async function getBoardList(pageNo = 1) {
    let response = null;
    try {
        response = await axios.get("/board/list", { params: { pageNo: pageNo } });
        // console.log(response);
    } catch (error) {
        console.log(error);
    }
    if (response != null) {
        //json 리턴의 값이 data이다. 그 뭐냐 vue의 data값이다.
        return response.data;
    } else {
        return null;
    }
}

//게시물 쓰기
// 게시물 쓰기 (멀티 파트)
async function createBoard(multipartFormData) {
    let dbBoard = null;
    try {
        const response = await axios.post("/board/", multipartFormData);
        dbBoard = response.data;
    } catch (error) {
        console.log(error);
    }

    return dbBoard;
}

//게시물 가져오기
async function reaadBoard(bno, hit) {
    let board = null;
    try {
        const response = await axios.get(`/board/${bno}?hit=${hit}`);
        board = response.data;
    } catch (error) {
        console.log(error);
    }

    return board;
}

//파일 다운로드
async function downloadBoardAttach(bno) {
    let blob = null;

    try {
        const response = await axios.get(`/board/battach/${bno}`, { responseType: "blob" }); //blob타입의 데이터 타입이 들어가야 동작한다.는 조건
        blob = response.data;
    } catch (error) {
        console.log(error);
    }

    return blob;
}

//게시글 삭제
async function deleteBoard(bno) { 
    let result = null;

    try {
        const response = await axios.delete(`/board/${bno}`); 
        result = response.data.result; //spring에서  result라는 값으로 넘어가기 때문에 
    } catch (error) {
        console.log(error);
    }

    return result;


}

//내보내기
export default {
    getBoardList,
    createBoard,
    reaadBoard,
    downloadBoardAttach,
    deleteBoard,
};


