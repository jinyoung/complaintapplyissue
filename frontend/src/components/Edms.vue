<template>
    <div>
        <String label="신청번호" v-model="value.신청번호" :editMode="editMode"/>
        <String label="파일id" v-model="value.파일id" :editMode="editMode"/>
        <String label="파일명" v-model="value.파일명" :editMode="editMode"/>
        <Boolean label="저장유무" v-model="value.저장유무" :editMode="editMode"/>

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
    name: 'Edms',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "edms"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
