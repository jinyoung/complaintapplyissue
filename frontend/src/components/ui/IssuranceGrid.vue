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
            <ApplicationStatusQuery @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></ApplicationStatusQuery>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>신청번호</th>
                        <th>파일Id</th>
                        <th>파일명</th>
                        <th>파일경로명</th>
                        <th>파일확장자명</th>
                        <th>파일크기</th>
                        <th>파일순서</th>
                        <th>fileType</th>
                        <th>Status</th>
                        <th>문서변환솔루션</th>
                        <th>WebViewer</th>
                        <th>민원접수</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" :key="val" @click="changeSelectedRow(val)" :style="val === selectedRow ? 'background-color: #f0f3ff;':''">
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="신청번호">{{ val.신청번호 }}</td>
                            <td class="whitespace-nowrap" label="파일Id">{{ val.파일Id }}</td>
                            <td class="whitespace-nowrap" label="파일명">{{ val.파일명 }}</td>
                            <td class="whitespace-nowrap" label="파일경로명">{{ val.파일경로명 }}</td>
                            <td class="whitespace-nowrap" label="파일확장자명">{{ val.파일확장자명 }}</td>
                            <td class="whitespace-nowrap" label="파일크기">{{ val.파일크기 }}</td>
                            <td class="whitespace-nowrap" label="파일순서">{{ val.파일순서 }}</td>
                            <td class="whitespace-nowrap" label="fileType">{{ val.fileType }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="문서변환솔루션">
                                <문서변환솔루션Id :editMode="editMode" v-model="val.문서변환솔루션Id"></문서변환솔루션Id>
                            </td>
                            <td class="whitespace-nowrap" label="WebViewer">
                                <WebViewerId :editMode="editMode" v-model="val.webViewerId"></WebViewerId>
                            </td>
                            <td class="whitespace-nowrap" label="민원접수">
                                <ComplaintId :editMode="editMode" v-model="val.complaintId"></ComplaintId>
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
                        <div style="color:white; font-size:17px; font-weight:700;">Issurance 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Issurance :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">Issurance 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="발급파일일련번호" v-model="selectedRow.발급파일일련번호" :editMode="true"/>
                            <String label="신청번호" v-model="selectedRow.신청번호" :editMode="true"/>
                            <String label="파일Id" v-model="selectedRow.파일Id" :editMode="true"/>
                            <String label="파일명" v-model="selectedRow.파일명" :editMode="true"/>
                            <String label="파일경로명" v-model="selectedRow.파일경로명" :editMode="true"/>
                            <String label="파일확장자명" v-model="selectedRow.파일확장자명" :editMode="true"/>
                            <String label="파일크기" v-model="selectedRow.파일크기" :editMode="true"/>
                            <String label="파일순서" v-model="selectedRow.파일순서" :editMode="true"/>
                            <String label="Status" v-model="selectedRow.status" :editMode="true"/>
                            <FileType offline label="fileType" v-model="selectedRow.fileType" :editMode="true"/>
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
    name: 'issuranceGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'issurances',
    }),
    watch: {
    },
    methods:{
    }
}

</script>