<template>
    <div>
        <String label="민원id" v-model="value.민원id" :editMode="editMode"/>
        <String label="민원접수번호" v-model="value.민원접수번호" :editMode="editMode"/>
        <String label="신청알림발송여부" v-model="value.신청알림발송여부" :editMode="editMode"/>
        <String label="처리알림발송여부" v-model="value.처리알림발송여부" :editMode="editMode"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>

import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: '알림',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "알림"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
