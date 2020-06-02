import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import {store} from "./store";
import axios from "axios";
import vuex from "vuex";
import vuetify from "./plugins/vuetify";

Vue.config.productionTip = false;
Vue.use(vuex);
new Vue({
  router,
  store,
  axios,
  vuex,
  vuetify,
  render: h => h(App)
}).$mount("#app");



