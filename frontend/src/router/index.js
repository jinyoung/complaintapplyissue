import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/applications/complaints',
      component: () => import('../components/ui/ComplaintGrid.vue'),
    },
    {
      path: '/issues/issurances',
      component: () => import('../components/ui/IssuranceGrid.vue'),
    },
    {
      path: '/issues/applicationStatusQueries',
      component: () => import('../components/ApplicationStatusQueryView.vue'),
    },
    {
      path: '/alarms/알림',
      component: () => import('../components/ui/알림Grid.vue'),
    },
    {
      path: '/integrations/integrations',
      component: () => import('../components/ui/IntegrationGrid.vue'),
    },
    {
      path: '/edms/edms',
      component: () => import('../components/ui/EdmsGrid.vue'),
    },
  ],
})

export default router;
