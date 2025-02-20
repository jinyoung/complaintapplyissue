<template>

    <div>
        <div class="detail-title">
        RequiredDocument
        </div>
        <v-col>
            <String label="파일id" v-model="value.파일id" :editMode="editMode"/>
            <String label="파일명" v-model="value.파일명" :editMode="editMode"/>
            <String label="파일경로명" v-model="value.파일경로명" :editMode="editMode"/>
            <String label="파일확장자명" v-model="value.파일확장자명" :editMode="editMode"/>
            <String label="파일크기" v-model="value.파일크기" :editMode="editMode"/>
            <String label="파일순서" v-model="value.파일순서" :editMode="editMode"/>
            <Boolean label="사용여부" v-model="value.사용여부" :editMode="editMode"/>
            <FileType offline label="fileType" v-model="value.fileType" :editMode="editMode" @change="change"/>
        </v-col>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </div>
</template>

<script>
import BaseEntity from './base-ui/BaseEntity.vue'
import BasePicker from './base-ui/BasePicker.vue'

export default {
    name: 'RequiredDocument',
    mixins:[BaseEntity],
    components:{
        BasePicker
    },
    data: () => ({
        path: 'RequiredDocuments',
    }),
    props: {
    },
    watch: {
        value(val){
            this.value = val;
            this.change();
        },
    },
    async created(){
        this.value = this.modelValue
        if (this.value && this.value.id !== undefined) {
            this.value = await this.repository.findById(this.value.id)
        }
    },
    methods: {
        pick(val){
            this.value = val;
            this.change();
        },
    }
}
</script>

