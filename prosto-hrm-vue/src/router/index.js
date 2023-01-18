import Vue from "vue";
import Router from "vue-router";
import Layout from "@/layout";

Vue.use(Router);

export const constantRoutes = [
    {
        path: "/",
        component: Layout,
        redirect: "/dashboard",
        children: [
            {
                path: "/dashboard",
                name: "Dashboard",
                component: () => import("@/views/dashboard/index.vue"),
                meta: { title: "Dashboard", icon: "dashboard" },
            },
        ],
    },
    {
        path: "/404",
        component: () => import("@/views/404"),
        hidden: true,
    },
    {
        path: "/login",
        name: "Login",
        component: () => import("@/views/login/index.vue"),
        hidden: true,
    },
];

/**
 * asyncRoutes
 * the routes that need to be dynamically loaded based on user roles
 */
export const asyncRoutes = [
    // 404 page must be placed at the end !!!
    { path: "*", redirect: "/404", hidden: true },
];

const createRouter = () =>
    new Router({
        // mode: 'history', // require service support
        scrollBehavior: () => ({ y: 0 }),
        routes: constantRoutes,
    });

const router = createRouter();

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
    const newRouter = createRouter();
    router.matcher = newRouter.matcher; // reset router
}

export default router;

// const routes = [
//     {
//         path: "/",
//         component: Layout,
//         redirect: "/dashboard",
//         children: [
//             {
//                 path: "/dashboard",
//                 name: "Dashboard",
//                 component: () => import("@/views/dashboard/index.vue"),
//                 meta: { title: "Dashboard", icon: "dashboard" },
//             },
//         ],
//     },
//     {
//         path: "/sys/login",
//         name: "Login",
//         component: () => import("@/views/login/index.vue"),
//         hidden: true,
//     },
// ];

// const router = new Router({
//     routes,
// });

// export default router;
