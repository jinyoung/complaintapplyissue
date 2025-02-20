<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '민원 신청' }" />
        <VerticalNavLink
            :item="{
                title: '민원접수',
                to: '/applications/complaints',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '발급 업무' }" />
        <VerticalNavLink
            :item="{
                title: '발급',
                to: '/issues/issurances',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '신청내역조회',
                to: '/issues/applicationStatusQueries',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '알림' }" />
        <VerticalNavLink
            :item="{
                title: '알림',
                to: '/alarms/알림',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '연계' }" />
        <VerticalNavLink
            :item="{
                title: '연계',
                to: '/integrations/integrations',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'Edms' }" />
        <VerticalNavLink
            :item="{
                title: 'Edms',
                to: '/edms/edms',
            }"
        />
    </ul>
</template>
