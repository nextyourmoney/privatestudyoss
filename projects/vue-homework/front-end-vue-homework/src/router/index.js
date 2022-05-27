import { createRouter, createWebHashHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import AboutView from "../views/AboutView.vue";
import menu01 from "./menu01";
import menu02 from "./menu02";
import menu03 from './menu03';
import menu04 from './menu04';
import menu05 from './menu05';
import menu06 from './menu06';
import menu07 from './menu07';
// import Exam01View from "../views/menu01/Exam01View.vue";
// import Exam02View from "../views/menu01/Exam02View";

const routes = [
    {
        path: "/",
        name: "home",
        component: HomeView,
    },
    {
        path: "/about",
        name: "about",
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        //component: AboutView
        component: () => import(/*webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  ...menu01,
  ...menu02,
  ...menu03,
  ...menu04,
  ...menu05,
  ...menu06,
  ...menu07
];

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
