import Vue from "vue"
import Vuex from "vuex"
import crawling from "./crawling"
import search from "./search"
Vue.use(Vuex)
export const store = new Vuex.Store({
    modules: {
        crawling, search
    }
})