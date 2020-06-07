import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../components/Home";
import Soccer from "../components/Soccer";
import Movie from "../components/Movie";
import Music from "../components/Music";
import MovieDetail from "../components/MovieDetail";

Vue.use(VueRouter);
export default new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes: [
        { path: "/", component: Home },
        { path: "/Soccer", component: Soccer },
        { path: "/Movie", component: Movie },
        { path: "/Music", component: Music },
        { path: "/MovieDetail", component: MovieDetail }
    ]
});