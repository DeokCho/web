import axios from "axios";
import router from "@/router";

const state = {
    context: "http://localhost:5000/",
    bugsmusic: [],
    navermovie: [],
    count: 0
};
const actions = {
    async search({ commit }, searchWord) {

        switch (searchWord) {
            case '네이버영화' :
                alert("검색어: " + searchWord);
                axios
                    .get(state.context+`movie/list/0/${searchWord}`)
                    .then(({data})=>{
                        commit("MOVIE", data);
                        router.push("/movie");
                    })
                    .catch(()=>{})
                break
            case '벅스뮤직' :
                axios
                    .post(state.context + `bugsmusic`,searchWord, {
                        authorization: "JWT fefege..",
                        Accept: "application/json",
                        "Content-Type": "application/json"
                    })
                    .then(({ data }) => {
                        commit("SEARCH", data);
                        router.push("/retriever");
                    })
                    .catch(() => {
                        alert("통신 실패 !");
                    });
                break
        }




    }
};
const mutations = {
    SEARCH(state, data) {
        alert("뮤데이션에서 결과 수 : " + data.count);
        state.bugsmusic = [];
        state.count = data.count;
        data.list.forEach(item => {
            state.bugsmusic.push({
                seq: item.seq,
                artist: item.artists,
                title: item.title,
                thumbnail: item.thumbnail
            });
        });
    },

};
const getters = {
    bugsmusic: state => state.bugsmusic,
    count: state => state.count,
    navermovie : state => state.navermovie
};

export default {
    name: "crawling",
    namespaced: true,
    state,
    actions,
    mutations,
    getters
};