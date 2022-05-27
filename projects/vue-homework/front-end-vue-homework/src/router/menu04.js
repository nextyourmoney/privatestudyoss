export default [
    {
        path: "/menu04/exam01props",
        component: () => import(/*webpackChunkName: "menu02" */ "../views/menu04/Exam01Props"),
    },
    {
        path: "/menu04/exam02eventemit",
        component: () => import(/*webpackChunkName: "menu02" */ "../views/menu04/Exam02EventEmit"),
    },
    {
        path: "/menu04/exam03provideinject",
        component: () => import(/*webpackChunkName: "menu02" */ "../views/menu04/Exam03ProvideInject"),
    },
];