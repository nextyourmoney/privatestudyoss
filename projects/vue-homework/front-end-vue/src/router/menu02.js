export default [
    {
        path: "/menu02/exam01binding",
        component: () => import(/*webpackChunkName: "menu02" */ "../views/menu02/Exam01Binding.vue"),
    },
    {
        path: "/menu02/exam02refdata",
        component: () => import(/*webpackChunkName: "menu02" */ "../views/menu02/Exam02RefData.vue"),
    },
    {
        path: "/menu02/exam03reactivedata",
        component: () => import(/*webpackChunkName: "menu02" */ "../views/menu02/Exam03ReactiveData.vue"),
    },
    {
        path: "/menu02/exam04attributebinding",
        component: () => import(/*webpackChunkName: "menu02" */ "../views/menu02/Exam04AttributeBinding"),
    },
    {
        path: "/menu02/exam05formbinding",
        component: () => import(/*webpackChunkName: "menu02" */ "../views/menu02/Exam05FormBinding.vue"),
    },
    {
        path: "/menu02/exam06listrendering",
        component: () => import(/*webpackChunkName: "menu02" */ "../views/menu02/Exam06ListRendering.vue"),
    },
    {
        path: "/menu02/exam07computedbinding",
        component: () => import(/*webpackChunkName: "menu02" */ "../views/menu02/Exam07ComputiedBinding.vue"),
    },
    // {
    //     path: "/menu02/exam08slot",
    //     component: () => import(/*webpackChunkName: "menu02" */ "../views/menu02/Exam08Slot"),
    // },
];