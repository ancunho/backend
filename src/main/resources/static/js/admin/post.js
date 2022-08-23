
/**
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
            axios.post(contextRootPath + "/api/post/proc", this.form)
                .then(res => {
                    var data = res.data;
                    if (data.code !== 0) {
                        swal("Error", data.msg, "error")
                            .then((value => {
                               console.log("error");
                                _this.form.postTitle = '';
                                editor.setHtml('');
                            }));
                        return;
                    } else {
                        swal("Success Save!", data.msg, "success")
                            .then(value => {
                                console.log("success");
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
