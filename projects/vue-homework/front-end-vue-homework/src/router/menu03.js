export default [
    {
        path: "/menu03/exam01eventhandling",
        component: () => import(/*webpackChunkName: "menu02" */ "../views/menu03/Exam01EventHandling.vue"),
    },
    {
        path: "/menu03/exam02watch",
        component: () => import(/*webpackChunkName: "menu02" */ "../views/menu03/Exam02Watch.vue"),
    },
];