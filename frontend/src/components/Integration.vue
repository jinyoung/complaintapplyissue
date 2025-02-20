<template>
    <div>
        <Number label="연계Id" v-model="value.연계Id" :editMode="editMode"/>
        <String label="신청번호" v-model="value.신청번호" :editMode="editMode"/>
        <String label="서비스Id" v-model="value.서비스Id" :editMode="editMode"/>
        <String label="연계인터페이스" v-model="value.연계인터페이스" :editMode="editMode"/>
        <String label="송신데이터" v-model="value.송신데이터" :editMode="editMode"/>
        <String label="수신데이터" v-model="value.수신데이터" :editMode="editMode"/>
        <String label="결과코드" v-model="value.결과코드" :editMode="editMode"/>
        <String label="결과메시지" v-model="value.결과메시지" :editMode="editMode"/>
        <Date label="송신일시" v-model="value.송신일시" :editMode="editMode"/>
        <Date label="수신일시" v-model="value.수신일시" :editMode="editMode"/>
        <Date label="등록일시" v-model="value.등록일시" :editMode="editMode"/>
        <Date label="수정일시" v-model="value.수정일시" :editMode="editMode"/>
        <TypeSequenceNo offline label="유형일렬번호" v-model="value.유형일렬번호" :editMode="editMode" @change="change"/>

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
    name: 'Integration',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "integrations"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
