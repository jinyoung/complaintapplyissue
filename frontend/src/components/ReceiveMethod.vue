<template>

    <div>
        <div class="detail-title">
        ReceiveMethod
        </div>
        <v-col>
            <String label="수령방법코드" v-model="value.수령방법코드" :editMode="editMode"/>
            <String label="수령방법명" v-model="value.수령방법명" :editMode="editMode"/>
            <String label="수령방법구분명" v-model="value.수령방법구분명" :editMode="editMode"/>
            <String label="등록자Id" v-model="value.등록자Id" :editMode="editMode"/>
            <Date label="등록일시" v-model="value.등록일시" :editMode="editMode"/>
            <String label="수령자Id" v-model="value.수령자Id" :editMode="editMode"/>
            <Date label="수령일시" v-model="value.수령일시" :editMode="editMode"/>
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
    name: 'ReceiveMethod',
    mixins:[BaseEntity],
    components:{
        BasePicker
    },
    data: () => ({
        path: 'ReceiveMethods',
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

