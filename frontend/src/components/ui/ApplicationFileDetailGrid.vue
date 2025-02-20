<template>
    <div class="panel">
        <div class="label-title">{{label}}</div>
        <div class="table-responsive">
            <v-btn v-if="editMode" @click="addDetailRow()">추가</v-btn>
            <v-btn v-if="editMode" style="margin-left: 3px;" @click="detailDeleteRow()">삭제</v-btn>
            <v-table v-if="!editMode">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>파일유형코드</th>
                        <th>사용여부</th>
                        <th>등록일시</th>
                        <th>수정일시</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(detailVal, idx) in selectedRow.applicationFiles" :key="detailVal" >
                        <td class="font-semibold">{{ idx + 1 }}</td>
                        <td class="whitespace-nowrap">
                            <파일유형코드 v-model="detailVal.파일유형코드" :editMode="editMode"/>
                        </td>
                        <td class="whitespace-nowrap">{{ detailVal.사용여부 }}</td>
                        <td class="whitespace-nowrap">{{ detailVal.등록일시 }}</td>
                        <td class="whitespace-nowrap">{{ detailVal.수정일시 }}</td>
                        <td class="whitespace-nowrap">
                            <Icon icon="mi:delete" @click="deleteRow(detailVal)" />
                        </td>
                    </tr>
                </tbody>
            </v-table>
            <v-table v-else>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>파일유형코드</th>
                        <th>사용여부</th>
                        <th>등록일시</th>
                        <th>수정일시</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(addVal, idx) in newValue" :key="addVal" >
                        <td class="font-semibold">{{ idx + 1 }}</td>
                        <td class="whitespace-nowrap">
                            <파일유형코드 v-model="addVal.파일유형코드" :editMode="editMode"/>
                        </td>
                        <td class="whitespace-nowrap">
                            <Boolean style="margin-left: -5px; width: 150px;" :editMode="editMode" v-model="addVal.사용여부"/>
                        </td>
                        <td class="whitespace-nowrap">
                            <Date style="margin-left: -5px; width: 150px;" :editMode="editMode" v-model="addVal.등록일시"/>
                        </td>
                        <td class="whitespace-nowrap">
                            <Date style="margin-left: -5px; width: 150px;" :editMode="editMode" v-model="addVal.수정일시"/>
                        </td>
                    </tr>
                </tbody>
            </v-table>
        </div>
    </div>
</template>

<script>
import BaseDetailGrid from '../base-ui/BaseDetailGrid.vue';

export default {
    name: 'ApplicationFile',
    mixins: [BaseDetailGrid],
    components: {
    },
    props: {
        label: String,
        editMode: Boolean,
        selectedRow: Object,
    },
    data: ()=>({
    }),
    created(){
    },
    methods: {
    }
}
</script>
