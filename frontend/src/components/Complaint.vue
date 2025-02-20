<template>
    <div>
        <Number label="신청번호" v-model="value.신청번호" :editMode="editMode"/>
        <String label="서식일렬번호" v-model="value.서식일렬번호" :editMode="editMode"/>
        <String label="서비스id" v-model="value.서비스id" :editMode="editMode"/>
        <String label="서비스분류코드" v-model="value.서비스분류코드" :editMode="editMode"/>
        <String label="신청인명" v-model="value.신청인명" :editMode="editMode"/>
        <String label="주민등록번호" v-model="value.주민등록번호" :editMode="editMode"/>
        <String label="신청처리결과코드" v-model="value.신청처리결과코드" :editMode="editMode"/>
        <Date label="신청일시" v-model="value.신청일시" :editMode="editMode"/>
        <Date label="등록일시" v-model="value.등록일시" :editMode="editMode"/>
        <Date label="수정일시" v-model="value.수정일시" :editMode="editMode"/>
        <ReceiveMethod offline label="신청 수령 방법" v-model="value.신청수령방법" :editMode="editMode" @change="change"/>
        <ApplicationFile offline label="신청서 파일" v-model="value.applicationFile" :editMode="editMode" @change="change"/>

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
    name: 'Complaint',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "complaints"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
