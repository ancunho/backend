
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
                <el-button slot="trigger" type="primary">1. 选取文件</el-button>
                <el-button style="margin-left: 10px;" type="success" v-on:click="handleSubmitUpload">2. 上传到服务器</el-button>
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
            imgDeleteURL: '/api/file/handle/single/image/delete',
            imgUploadURL: '/api/file/handle/multie/image/upload',
            imgDetailURL: '/api/file/handle/info',
            initDataListURL: '/api/file/handle/list',
            arrInitData: [],
            isDrawerVisible: false,
            fileId: '',
            itemDetail: {},
            loadingDrawer: false,
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

            };

            axios.post(_this.initDataListURL + '?page=' + _this.currentPage + "&limit=" + _this.pageSize,params)
                .then(res => {
                    if (res.data.status === 200) {
                        _this.arrInitData = res.data.data;
                        _this.total = res.data.count;
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
        handleSubmitUpload() {
            let _this = this;
            const isLt1M = _this.fileList.every(file => file.size / 1024 / 1024 < 1);
            if (!isLt1M) {
                _this.$message.error("请检查，上传文件大小不能超过1MB!");
                return;
            }

            _this.fileData = new FormData();
            _this.$refs.upload.submit();
            _this.handleRequest(_this.fileData);
        },
        handleRequest(params) {
            console.log(params)
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
    }
})
