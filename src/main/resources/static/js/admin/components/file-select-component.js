
var childTestComponent =  Vue.extend({
    template: `
            <div>
                <p>{{ count }}</p>
                <el-button type="primary" v-on:click="handleCountPlus">plus</el-button>
            </div>
            `,
    data() {
        return {
            count: 0,
        }
    },
    methods: {
        handleCountPlus() {
            this.count++
        }
    }
});

// File Upload Component
var fileUploadAndListComponent = Vue.extend({
    template: `
    <div class="" style="padding: 0 30px;">
            <!-- Top File Upload Box Start -->
            <div style="margin-bottom: 40px;">
                <span>1. Type: </span>
                <el-radio v-on:change="handleRadioTypeChange" v-model="uploadType" style="margin-right: 0px;" label="image" border>Image</el-radio>
                <el-radio v-on:change="handleRadioTypeChange" v-model="uploadType" style="margin-right: 0px;" label="video" border>Video</el-radio>
                <el-radio v-on:change="handleRadioTypeChange" v-model="uploadType" style="margin-right: 0px;" label="audio" border>Audio</el-radio>
                <el-radio v-on:change="handleRadioTypeChange" v-model="uploadType" label="file" border>File</el-radio>
            </div>
            <el-upload
                    class="upload-demo"
                    ref="upload"
                    action="#this"
                    v-bind:file-list="fileList"
                    v-bind:limit="5"
                    multiple
                    v-bind:auto-upload="false"
                    v-bind:on-change="handleOnChange"
                    v-bind:on-exceed="handleOnExceed"
                    v-bind:http-request="handleOnUpload"
            >
                <el-button slot="trigger" type="primary">2. 选取文件</el-button>
                <el-button style="margin-left: 10px;" type="success" v-on:click="handleSubmitUpload">3. 上传到服务器</el-button>
                <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
            </el-upload>
            <!-- // Top File Upload Box End -->
            <!--  paging start  -->
            <el-row style="margin: 2rem 0;">
                <el-col v-bind:span="12" v-bind:offset="6">
                    <el-pagination
                            v-on:size-change="handleSizeChange"
                            v-on:current-change="handleCurrentChange"
                            v-bind:current-page="currentPage"
                            v-bind:page-sizes="pageSizes"
                            v-bind:page-size="pageSize"
                            layout="total, sizes, prev, pager, next, jumper"
                            v-bind:total="total">
                    </el-pagination>
                </el-col>
            </el-row>
            <!--  // paging end  -->
            <!-- Result List Start -->
            <el-row v-bind:gutter="20">
                <el-col v-bind:lg="4" v-bind:xs="12" v-bind:sm="6" v-bind:md="6" v-for="item in arrInitData" v-bind:key="item.fileId" style="margin-bottom: 20px;">
                    <el-card v-bind:body-style="{ padding: '0px' }" shadow="hover">
                        <el-image style="width: 100%; height: 200px" v-bind:src="item.fileUrl" fit="contain"></el-image>
                        <div style="padding: 14px;">
                            <span style="font-size: .7rem; height: 30px; line-height: 25px; display: inline-block; overflow-y: hidden">{{ item.fileOriginName }}</span>
                            <div class="bottom clearfix">
                                <!--                                <time class="time">{{ item.fileName }}</time>-->
                                <el-button type="text" class="button" v-on:click="handleOpenDrawer(item.fileId)">查看详细</el-button>
                                <el-button type="text" class="button" v-on:click="emitfile(item)">选择</el-button>
                            </div>
                        </div>
                    </el-card>
                </el-col>
            </el-row>
            <!-- // Result List End -->
            <!--  paging start  -->
            <el-row style="margin: 2rem 0;">
                <el-col v-bind:span="12" v-bind:offset="6">
                    <el-pagination
                            v-on:size-change="handleSizeChange"
                            v-on:current-change="handleCurrentChange"
                            v-bind:current-page="currentPage"
                            v-bind:page-sizes="pageSizes"
                            v-bind:page-size="pageSize"
                            layout="total, sizes, prev, pager, next, jumper"
                            v-bind:total="total">
                    </el-pagination>
                </el-col>
            </el-row>
            <!--  // paging end  -->
            <!--  // drawer start  -->
            <el-drawer
                    v-loading="loadingDrawer"
                    :append-to-body="true"
                    title="图片详细信息"
                    v-bind:visible.sync="isDrawerVisible"
                    direction="rtl"
                    size="100%"
                    v-bind:close-on-press-escape="false"
            >
                <p>fileId : {{ itemDetail.fileId }}</p>
                <p>fileType : {{ itemDetail.fileType || '' }}</p>
                <p>filePurpose : {{ itemDetail.filePurpose || '-' }}</p>
                <p>fileOriginName : {{ itemDetail.fileOriginName }}</p>
                <p>fileName : {{ itemDetail.fileName }}</p>
                <p>filePath : {{ itemDetail.filePath }}</p>
                <p>fileBucketName : {{ itemDetail.fileBucketName }}</p>
                <p>fileBucketObject : {{ itemDetail.fileBucketObject }}</p>
                <p>fileSize : {{ itemDetail.fileSize }}</p>
                <p>status : {{ itemDetail.status }}</p>
                <p>fileExtention : {{ itemDetail.fileExtention }}</p>
                <p>fileUrl : {{ itemDetail.fileUrl }}</p>
            </el-drawer>
            <!--  // drawer end  -->
            
            
        </div>
    `,
    data() {
        return {
            currentDate: new Date(),
            loading: false,
            currentPage: 1, //page
            pageSize: 18, //limit
            pageSizes: [18, 36, 96],
            total: 100,

            fileList: [],
            fileData: '', // 文件上传数据（多文件合一）
            imgDeleteURL: contextRootPath + '/api/file/handle/single/image/delete.do',
            imgUploadURL: contextRootPath + '/api/file/handle/multie/image/upload.do',
            imgDetailURL: contextRootPath + '/api/file/handle/info.do',
            initDataListURL: contextRootPath + '/api/file/handle/list.do',
            arrInitData: [],
            isDrawerVisible: false,
            fileId: '',
            itemDetail: {},
            loadingDrawer: false,

            uploadType: 'image',
        }
    },
    mounted() {
        let _this = this;
        _this.initMainList();
    },
    methods: {
        handleSizeChange(limit) {
            this.currentPage = 1;
            this.pageSize = limit;
            this.initMainList();
        },
        handleCurrentChange(page) {
            this.currentPage = page;
            this.initMainList();
        },
        initMainList() {
            let _this = this;
            let params = {
                fileType: _this.uploadType
            };

            axios.post(_this.initDataListURL + '?page=' + _this.currentPage + "&limit=" + _this.pageSize,params)
                .then(res => {
                    if (res.data.status === 200) {
                        _this.arrInitData = res.data.data;
                        _this.total = res.data.total;
                    } else {
                        _this.$message.error(res.data.msg);
                    }
                    _this.loading = false;
                })
                .catch(res => {
                    _this.$message.error("Fail!!!!!!")
                    _this.loading = false;
                });
        },
        handleRadioTypeChange(aaa) {
            this.initMainList();
        },
        handleOnChange(file, fileList) {
            let _this = this;
            let existsFile = fileList.slice(0, fileList.length - 1).find(f => f.name === file.name);
            if (existsFile) {
                _this.$message.error("当前文件已经存在!");
                fileList.pop();
            }

            _this.fileList = fileList;
        },
        handleOnExceed() {
            this.$message.warning(`当前限制选择 5 个文件`)
        },
        handleOnUpload(file) {
            let _this = this;
            _this.fileData.append("imageFiles", file.file);
        },
        //上传文件
        async handleSubmitUpload() {
            let _this = this;

            // File Type Check
            var typeErrorFlag = '';
            for (var i = 0; i < _this.fileList.length; i++) {
                var file = _this.fileList[i];
                const fileSuffix = file.raw.name.substring(file.raw.name.lastIndexOf(".") + 1);
                if (_this.uploadType === 'image') {
                    if (imageWhiteList.indexOf(fileSuffix) === -1) {
                        // _this.$alert("업로드 가능한 이미지 파일형식: " + imageWhiteList);
                        // _this.fileList = [];
                        typeErrorFlag = 'imageError';
                    }
                } else if (_this.uploadType === 'video') {
                    if (videoWhiteList.indexOf(fileSuffix) === -1) {
                        // _this.$alert("업로드 가능한 동영상 파일형식: " + videoWhiteList);
                        // _this.fileList = [];
                        typeErrorFlag = 'videoError';
                    }
                } else if (_this.uploadType === 'audio') {
                    if (audioWhiteList.indexOf(fileSuffix) === -1) {
                        // _this.$alert("업로드 가능한 오디오 파일형식: " + audioWhiteList);
                        // _this.fileList = [];
                        typeErrorFlag = 'audioError';
                    }
                } else if (_this.uploadType === 'file') {
                    if (audioWhiteList.indexOf(fileSuffix) === -1) {
                        // _this.$alert("업로드 가능한 오디오 파일형식: " + audioWhiteList);
                        // _this.fileList = [];
                        typeErrorFlag = 'fileError';
                    }
                }
            }

            if (typeErrorFlag === 'imageError') {
                _this.$alert("업로드 가능한 이미지 파일형식: " + imageWhiteList);
                _this.fileList = [];
                return;
            } else if (typeErrorFlag === 'videoError') {
                _this.$alert("업로드 가능한 동영상 파일형식: " + videoWhiteList);
                _this.fileList = [];
                return;
            } else if (typeErrorFlag === 'audioError') {
                _this.$alert("업로드 가능한 오디오 파일형식: " + audioWhiteList);
                _this.fileList = [];
                return;
            } else if (typeErrorFlag === 'fileError') {
                _this.$alert("업로드 가능한 파일형식: " + fileWhiteList);
                _this.fileList = [];
                return;
            }

            let fileSize = 1; //image size --- MB
            if (_this.uploadType === 'image') {
                fileSize = 2;
            } else if (_this.uploadType === 'video' || _this.uploadType === 'audio') {
                fileSize = 103;
            } else if (_this.uploadType === 'file') {
                fileSize = 20;
            }

            const isLt1M = _this.fileList.every(file => file.size / 1024 / 1024 < fileSize);
            if (!isLt1M) {
                _this.$message.error("请检查，上传文件大小不能超过1MB!");
                return;
            }

            _this.fileData = new FormData();
            _this.fileData.append("fileType", _this.uploadType); // 파일 형식
            _this.$refs.upload.submit();
            await _this.handleRequest(_this.fileData);
        },
        handleRequest(params) {
            let _this = this;
            _this.loading = true;
            var instance_files = axios.create({
                headers: {
                    'content-type': 'multipart/form-data',
                    "Request-Source": "client"
                }
            });
            instance_files
                .post(_this.imgUploadURL, params)
                .then(res => {
                    if (res.data.code === 0) {
                        _this.$message.success(res.data.msg);
                        _this.fileList = [];
                    } else {
                        _this.$message.error(res.data.msg);
                    }
                    _this.initMainList();
                })
                .catch(response => {
                    _this.$message.error("上传失败， 请重试或联系管理员");
                    _this.loading = false;
                });
        },
        handleOpenDrawer(fileId) {
            let _this = this;
            _this.fileId = fileId;
            _this.isDrawerVisible = true;
            _this.loadingDrawer = true;
            axios.get(_this.imgDetailURL + '?fileId=' + _this.fileId)
                .then(res => {
                    _this.loadingDrawer = false;
                    if (res.data.status === 200) {
                        _this.itemDetail = res.data.data;
                    } else {
                        _this.$message.error(res.data.msg);
                    }

                })
                .catch(res => {

                });
        },
        emitfile(item) {
            let _this = this;
            _this.$emit("emitfile", item);

        },
        handleDialogClose(done) {
            this.$confirm('确认关闭？')
                .then(_ => {
                    done();
                })
                .catch(_ => {});
        }
    }
})


// Post Modify Component

// var postModifyComponent = Vue.extend({
//     template: `
//
//     `
// })
