
/**
 * Create Post js
 * Init Data
 * @returns {{editor: null, lstPostType: *[], editorData: string, form: {isJoin: boolean, eventDateRange: string, postContent: string, postType: string, postPrice: number, eventEndTime: string, postTitle: string, eventStartTime: string, postId: string, type: *[], isNeedPay: boolean, status: string}, save(): void, loading: boolean}}
 */
function initData() {
    return {
        form: {
            postId: '',
            postTitle: '',
            postContent: '',
            postType: '',
            eventStartTime: '',
            eventEndTime: '',
            isJoin: false,
            isNeedPay: false,
            postPrice: 0,
            type: [],
            status: '1',
            eventDateRange: ''
        },
        lstPostType: [],
        editor: null,
        editorData: '',
        loading: true,
        save() {
            const _this = this;
            _this.form.postContent = editor.getHtml();
            _this.form.postType = '01';
            axios.post(contextRootPath + "/api/post/proc.do", this.form)
                .then(res => {
                    var data = res.data;
                    if (data.code !== 0) {
                        swal({
                            title: "Error!",
                            text: data.msg,
                            icon: "error",
                            closeOnClickOutside: false,
                        }).then(value => {
                            console.log("error");
                            _this.form.postTitle = '';
                            editor.setHtml('');
                        });
                        return;
                    } else {
                        swal({
                            title: "Success Save!",
                            text: data.msg,
                            icon: "success",
                            closeOnClickOutside: false,
                        }).then(value => {
                                _this.form.postTitle = '';
                                editor.setHtml('');
                            });
                    }

                })
                .catch(error => {
                    console.log(error);
                });
        }
    }
}

function initPostIndex() {
    return {
        itemList: [],
        modifyItem: {},
        loading: true,
        currentPage: 1, //page
        pageSize: 5, //limit
        pageSizes: [5, 15, 30, 50],
        total: 100,
        isModalVisible: false,
        buzaModalTitle: 'Modal',
        getPostList() {
            const _this = this;
            axios.post(contextRootPath + "/api/post/list.do?page=1&limit=2", {})
                .then(res => {
                    var data = res.data;
                    if (data.code !== 0) {
                        swal({
                            title: "Error!", text: data.msg, icon: "error", closeOnClickOutside: false,
                        }).then(value => {
                            _this.form.postTitle = '';
                            editor.setHtml('');
                        });
                        return;
                    } else {
                        console.log(data);
                    }

                })
                .catch(error => {
                    console.log(error);
                });
        },

    }
}
