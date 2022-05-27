export default [
    {
        path: "/menu07/board/list",
        component: () => import(/*webpackChunkName: "menu07 */ "../views/menu07/board/List.vue"),
    },
    {
        path: "/menu07/exam07asynccontrol",
        component: () => import(/*webpackChunkName: "menu07 */ "../views/menu07/Exam07AsyncControl.vue"),
    },
    {
        path: "/menu07/board/writeform",
        component: () => import(/*webpackChunkName: "menu07 */ "../views/menu07/board/WriteForm.vue"),
    },
    {
        path: "/menu07/board/read",
        component: () => import(/*webpackChunkName: "menu07 */ "../views/menu07/board/Read.vue"),
    },
];