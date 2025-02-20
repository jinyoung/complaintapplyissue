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
                        <th>신청번호</th>
                        <th>서비스Id</th>
                        <th>유형일렬번호</th>
                        <th>연계인터페이스</th>
                        <th>송신데이터</th>
                        <th>수신데이터</th>
                        <th>결과코드</th>
                        <th>결과메시지</th>
                        <th>송신일시</th>
                        <th>수신일시</th>
                        <th>등록일시</th>
                        <th>수정일시</th>
                        <th>소관부처</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" :key="val" @click="changeSelectedRow(val)" :style="val === selectedRow ? 'background-color: #f0f3ff;':''">
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="신청번호">{{ val.신청번호 }}</td>
                            <td class="whitespace-nowrap" label="서비스Id">{{ val.서비스Id }}</td>
                            <td class="whitespace-nowrap" label="유형일렬번호">{{ val.유형일렬번호 }}</td>
                            <td class="whitespace-nowrap" label="연계인터페이스">{{ val.연계인터페이스 }}</td>
                            <td class="whitespace-nowrap" label="송신데이터">{{ val.송신데이터 }}</td>
                            <td class="whitespace-nowrap" label="수신데이터">{{ val.수신데이터 }}</td>
                            <td class="whitespace-nowrap" label="결과코드">{{ val.결과코드 }}</td>
                            <td class="whitespace-nowrap" label="결과메시지">{{ val.결과메시지 }}</td>
                            <td class="whitespace-nowrap" label="송신일시">{{ val.송신일시 }}</td>
                            <td class="whitespace-nowrap" label="수신일시">{{ val.수신일시 }}</td>
                            <td class="whitespace-nowrap" label="등록일시">{{ val.등록일시 }}</td>
                            <td class="whitespace-nowrap" label="수정일시">{{ val.수정일시 }}</td>
                            <td class="whitespace-nowrap" label="소관부처">
                                <소관부처Id :editMode="editMode" v-model="val.소관부처Id"></소관부처Id>
                            </td>
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
                        <div style="color:white; font-size:17px; font-weight:700;">Integration 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Integration :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">Integration 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="연계Id" v-model="selectedRow.연계Id" :editMode="true"/>
                            <String label="신청번호" v-model="selectedRow.신청번호" :editMode="true"/>
                            <String label="서비스Id" v-model="selectedRow.서비스Id" :editMode="true"/>
                            <String label="연계인터페이스" v-model="selectedRow.연계인터페이스" :editMode="true"/>
                            <String label="송신데이터" v-model="selectedRow.송신데이터" :editMode="true"/>
                            <String label="수신데이터" v-model="selectedRow.수신데이터" :editMode="true"/>
                            <String label="결과코드" v-model="selectedRow.결과코드" :editMode="true"/>
                            <String label="결과메시지" v-model="selectedRow.결과메시지" :editMode="true"/>
                            <Date label="송신일시" v-model="selectedRow.송신일시" :editMode="true"/>
                            <Date label="수신일시" v-model="selectedRow.수신일시" :editMode="true"/>
                            <Date label="등록일시" v-model="selectedRow.등록일시" :editMode="true"/>
                            <Date label="수정일시" v-model="selectedRow.수정일시" :editMode="true"/>
                            <TypeSequenceNo offline label="유형일렬번호" v-model="selectedRow.유형일렬번호" :editMode="true"/>
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
    name: 'integrationGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'integrations',
    }),
    watch: {
    },
    methods:{
    }
}

</script>