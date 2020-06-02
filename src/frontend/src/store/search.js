import axios from "axios"

const state ={
    context : "http://localhost:5000/",
    soccer : []
}

const actions = {
    async find({commit}, searchWord) {

        axios.get(state.context + `soccer/`+searchWord)
            .then(({data}) => {
                commit("SEARCH", data);
                router.push("/Home")
            })
            .catch(() => {
                alert("축구 실패");
            })



    }


}

const mutations = {
    SEARCH(){
        alert('뮤테이션 진입')
    }
}

const getters = {

}

export default {
    name: "search",
    namespaced : true,
    state,
    actions,
    mutations,
    getters
}