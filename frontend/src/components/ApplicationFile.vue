<template>

    <div>
        <div class="detail-title">
        ApplicationFile
        </div>
        <v-col>
            <String label="파일Id" v-model="value.파일Id" :editMode="editMode"/>
            <String label="파일명" v-model="value.파일명" :editMode="editMode"/>
            <String label="파일확장자명" v-model="value.파일확장자명" :editMode="editMode"/>
            <파일유형코드 offline label="파일유형코드" v-model="value.파일유형코드" :editMode="editMode" @change="change"/>
            <String label="파일순서" v-model="value.파일순서" :editMode="editMode"/>
            <Boolean label="사용여부" v-model="value.사용여부" :editMode="editMode"/>
            <Date label="등록일시" v-model="value.등록일시" :editMode="editMode"/>
            <Date label="수정일시" v-model="value.수정일시" :editMode="editMode"/>
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
    name: 'ApplicationFile',
    mixins:[BaseEntity],
    components:{
        BasePicker
    },
    data: () => ({
        path: 'ApplicationFiles',
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

