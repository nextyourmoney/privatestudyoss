import { createStore } from 'vuex'
//store 생성 및 내보내기
export default createStore({
  //루트 상태 정의
  state: {
    userId: ""
  },
  //루트 상태 값을 읽는 메소드(getter) 정의
  getters: {
    getUserId(state, getters, rootState, rootGetters) {
      return state.userId;
    }
  },
  //루트 상태 값을 변화시키는 메소드(setter) 정의(동기 방식)
  mutations: {
    setUserId(state, payload) {
      state.userId = payload;
    }
  },
  //비동기 작업을 실행하고 결과에 따라 상태 값을 변화시키는 메소드
  actions: {
    //payload: {userId:"xxxx", duration:3000}
    setUserIdByAsync(context, payload) {
      new Promise((resolve, reject) => {
        //시간을 요하는 작업(주로 Back-end로 데이터 요청)
        setTimeout(() => {
          //성공적으로 응답을 얻었을 경우
          resolve(payload.userId);
        }, payload.duration);
      })
        .then((data) => {
          //resolve가 되었을 경우 mutations을 이용해서 상태값 변경
          context.commit("setUserId", data);
          console.log("userId 상태 변경 성공");
        })
        .catch((error) => {
          //예외가 발생했거나, reject된경우
          console.log("userId 상태 변경 실패");
        });
    }
  }
})
