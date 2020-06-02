import axios from "axios"
import router from "@/router"

const state ={
    context : "http://localhost:5000/",
    soccer : [],
    movies : [],
    musics : [],
    pager : {}
}

const actions = {
    async find({commit}, searchWord) {
        alert('>>>'+searchWord)
        commit("TEST",searchWord)
        switch(searchWord){
            case '영화': router.push("/Movie")
                break
            case '음악': router.push("/Soccer")
                break
            case '축구': router.push("/Soccer")
                break
        }

        axios.get(state.context + `soccer/`+searchWord)
            .then(({data}) => {
                commit("SEARCH", data);
                router.push("/Home")
            })
            .catch(() => {
                alert("축구 실패");
            })



    },
    async movieList({commit}, pageNumber, searchWord){
        axios.get(state.context + "movie/list/0/none")
            .then(({data}) => {
                commit("SEARCH", data);
                router.push("/Home")
            })
            .catch(() => {
                alert("영화 통신 실패");
            })
    }


}

const mutations = {
    SEARCH(){
        alert('뮤테이션 진입')
    },
    TEST(state, data){
        alert(`test${data}`)
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