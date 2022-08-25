
/**
 * Create Setting js
 * Init Data
 */
function initCommonCodeIndex() {
    return {
        itemList: [],
        item: {},
        loading: true,
        pageParam: {
            pageCount: 1,
            page: 1, //page
            limit: 5, //limit
            pageSizes: [15, 30, 50, 100],
            total: 100,
        },
        isModalVisible: false,
        buzaModalTitle: 'Modal',
        save() {
            const _this = this;
            console.log(_this.item);
            axios.post(contextRootPath + "/api/common_code/proc.do", _this.item)
                .then(res => {
                    var data = res.data;
                    if (data.code !== 0) {
                        swal({
                            title: "Error!", text: data.msg, icon: "error", closeOnClickOutside: false,
                        }).then(value => {
                            _this.item = {};
                        });
                        return;
                    }
                    swal({
                        title: "Success Save!", text: data.msg, icon: "success", closeOnClickOutside: false,
                    }).then(value => {
                        _this.item = {};
                        _this.getMainList();
                    });

                })
                .catch(error => {
                    console.log(error);
                });
        },
        getMainList() {
            const _this = this;
            axios.get(contextRootPath + "/api/common_code/list.do?page=" + _this.pageParam.page + "&limit=" + _this.pageParam.limit)
                .then(res => {
                    var data = res.data;
                    if (data.code !== 0) {
                        swal({
                            title: "Error!", text: data.msg, icon: "error", closeOnClickOutside: false,
                        }).then(value => {

                        });
                        return;
                    } else {
                        _this.itemList = data.data;
                        _this.pageParam.total = data.total;
                        _this.handlePaginationInit();
                    }

                })
                .catch(error => {
                    console.log(error);
                });
        },
        handlePaginationInit() {
            var _this = this;
            _this.pageParam.pageCount = Math.ceil(_this.pageParam.total / _this.pageParam.limit);
        },
        handleChangeCurrentPage(page) {
            var _this = this;
            _this.pageParam.page = page;
            _this.getMainList();
        }
    }
}


