<template>
    <div>
        <Number label="발급파일일련번호" v-model="value.발급파일일련번호" :editMode="editMode"/>
        <String label="신청번호" v-model="value.신청번호" :editMode="editMode"/>
        <String label="파일Id" v-model="value.파일Id" :editMode="editMode"/>
        <String label="파일명" v-model="value.파일명" :editMode="editMode"/>
        <String label="파일경로명" v-model="value.파일경로명" :editMode="editMode"/>
        <String label="파일확장자명" v-model="value.파일확장자명" :editMode="editMode"/>
        <String label="파일크기" v-model="value.파일크기" :editMode="editMode"/>
        <String label="파일순서" v-model="value.파일순서" :editMode="editMode"/>
        <String label="Status" v-model="value.status" :editMode="editMode"/>
        <FileType offline label="fileType" v-model="value.fileType" :editMode="editMode" @change="change"/>

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
    name: 'Issurance',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "issurances"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
