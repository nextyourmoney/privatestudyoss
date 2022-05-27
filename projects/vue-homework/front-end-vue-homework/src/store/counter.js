
export default {
    namespaced: true,

    state: {
        count: 0,
    },

    getters: {
        getCount(state, getters, rootState, rootGetters) {
            return state.count;
        },
    },

    mutations: {
        setCount(state, payload) {
            state.count += payload;
        },
    },

    actions: {
        setCountByAsync(context, payload) {
            new Promise((resolve, reject) => {
                //정상 실행 시 아래 코드가 동작한다.
                setTimeout(() => {
                    context.commit("setCount", payload.value);
                    resolve(payload.value);
                    //payload는 시간이다.
                }, payload.duration);
            })
                .then((data) => {
                    //mutation 사용을 위해서는 comiit을 사용해야 한다.
                    
                    console.log("count 상태 변경 성공");
                })
                .catch((error) => {
                    //예외가 발생해거나 reejct된 경우
                    console.log("에러");
                });
        }
    },

};
