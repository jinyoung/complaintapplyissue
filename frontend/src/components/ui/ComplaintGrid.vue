<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>서식일렬번호</th>
                        <th>서비스id</th>
                        <th>서비스분류코드</th>
                        <th>신청인명</th>
                        <th>주민등록번호</th>
                        <th>신청처리결과코드</th>
                        <th>신청일시</th>
                        <th>등록일시</th>
                        <th>수정일시</th>
                        <th>신청 수령 방법</th>
                        <th>신청서 파일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" :key="val" @click="changeSelectedRow(val)" :style="val === selectedRow ? 'background-color: #f0f3ff;':''">
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="서식일렬번호">{{ val.서식일렬번호 }}</td>
                            <td class="whitespace-nowrap" label="서비스id">{{ val.서비스id }}</td>
                            <td class="whitespace-nowrap" label="서비스분류코드">{{ val.서비스분류코드 }}</td>
                            <td class="whitespace-nowrap" label="신청인명">{{ val.신청인명 }}</td>
                            <td class="whitespace-nowrap" label="주민등록번호">{{ val.주민등록번호 }}</td>
                            <td class="whitespace-nowrap" label="신청처리결과코드">{{ val.신청처리결과코드 }}</td>
                            <td class="whitespace-nowrap" label="신청일시">{{ val.신청일시 }}</td>
                            <td class="whitespace-nowrap" label="등록일시">{{ val.등록일시 }}</td>
                            <td class="whitespace-nowrap" label="수정일시">{{ val.수정일시 }}</td>
                            <v-row class="ma-0 pa-4 align-center">
                                <v-spacer></v-spacer>
                                <Icon style="cursor: pointer;" icon="mi:delete" @click="deleteRow(val)" />
                            </v-row>
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Complaint 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Complaint :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Complaint 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="신청번호" v-model="selectedRow.신청번호" :editMode="true"/>
                            <String label="서식일렬번호" v-model="selectedRow.서식일렬번호" :editMode="true"/>
                            <String label="서비스id" v-model="selectedRow.서비스id" :editMode="true"/>
                            <String label="서비스분류코드" v-model="selectedRow.서비스분류코드" :editMode="true"/>
                            <String label="신청인명" v-model="selectedRow.신청인명" :editMode="true"/>
                            <String label="주민등록번호" v-model="selectedRow.주민등록번호" :editMode="true"/>
                            <String label="신청처리결과코드" v-model="selectedRow.신청처리결과코드" :editMode="true"/>
                            <Date label="신청일시" v-model="selectedRow.신청일시" :editMode="true"/>
                            <Date label="등록일시" v-model="selectedRow.등록일시" :editMode="true"/>
                            <Date label="수정일시" v-model="selectedRow.수정일시" :editMode="true"/>
                            <ReceiveMethod offline label="신청 수령 방법" v-model="selectedRow.신청수령방법" :editMode="true"/>
                            <ApplicationFile offline label="신청서 파일" v-model="selectedRow.applicationFile" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'


export default {
    name: 'complaintGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'complaints',
    }),
    watch: {
    },
    methods:{
    }
}

</script>