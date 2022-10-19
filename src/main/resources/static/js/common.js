var contextRootPath = "";

function StringBuffer() {
    this.__strings__ = new Array;
}

StringBuffer.prototype.append = function (str) {
    this.__strings__.push(str);
    return this;
};

StringBuffer.prototype.toString = function () {
    return this.__strings__.join("");
};

String.prototype.startWith = function(str) {
    var reg = new RegExp("^" + str);
    return reg.test(this);
};

String.prototype.endWith = function(str) {
    var reg = new RegExp(str + "$");
    return reg.test(this);
};

String.prototype.lpad = function(padLength, padString) {
    var s = this;
    while (s.length < padLength) {
        s = padString + "" + s;
    }
    return s;
};

String.prototype.rpad = function(padLength, padString) {
    var s = this;
    while (s.length < padLength) {
        s += padString + "";
    }
    return s;
};

String.prototype.replaceAll = function (regExp, replaceText) {
    var strOrigin = this;
    while (strOrigin.indexOf(regExp) > -1) {
        strOrigin = strOrigin.replace(regExp, replaceText);
    }
    return strOrigin;
};

String.prototype.left = function(pos) {
    if (pos <= 0) {
        return "";
    } else if (pos > this.length) {
        return this;
    } else {
        return this.substring(0, pos);
    }
};

String.prototype.right = function(pos) {
    if (pos <= 0) {
        return "";
    } else if (pos > this.length) {
        return this;
    } else {
        var iLen = this.length;
        return this.substring(iLen, iLen - pos);
    }
};

Array.prototype.put = function(value){
    var contain = false;
    for (var i = 0 ; i < this.length ; i++){
        if (this[i] == value){
            contain = true;
            break;
        }
    }
    if (! contain) {
        this.push(value);
    }
    return contain;
};

Array.prototype.del = function(value){
    for (var i = 0 ; i < this.length ; i++){
        if (this[i] == value){
            this.splice(i, 1);
        }
    }
};
// const axios = axios.create();
function BuzaRouter(url) {
    var $frmBUZACommon = $("#frmBUZACommon");
    if($frmBUZACommon.length < 1) {
        $frmBUZACommon = $("<form/>").attr({id:"frmBUZACommon", method:'POST'});
        $(document.body).append($frmBUZACommon);
    }
    $frmBUZACommon.empty();
    $frmBUZACommon.attr('target', '_self');
    $frmBUZACommon.attr('action', contextRootPath + url);

    $frmBUZACommon.submit();
}

let imageWhiteList = ["jpg", "jpeg", "png", "gif", "bmp", "JPG", "JPEG", "GIF", "BMP"];
let videoWhiteList = ["mp4", "avi", "3gp", "wma", "flv", "mpg", "mpeg", "mpe", "mov", "m4v", "vob", "dat", "mkv", "rm", "rmvb", "asf", "asx",
    "MP4", "AVI", "3GP", "WMA", "FLV", "MPG", "MPEG", "MPE", "MOV", "M4V", "VOB", "DAT", "MKV", "RM", "RMVB", "ASF", "ASX"
];
let audioWhiteList = ["mp3", "wav", "wma", "mp2", "flac", "midi", "ra", "ape", "aac", "cda", "mov",
    "MP3", "WAV", "WMA", "MP2", "FLAC", "MIDI", "RA", "APE", "AAC", "CDA", "MOV"
];

let fileWhiteList = ["pdf", "xls", "xlsx", "docx", "doc", "docm", "dotm", "txt", "hwp", "ppt", "pptx",
    "PDF", "XLS", "XLSX", "DOCX", "DOC", "DOCM", "DOTM", "TXT", "HWP", "PPT", "PPTX"
];

Tool = {
    /**
     * 空校验 null或""都返回true
     */
    isEmpty: function (obj) {
        if ((typeof obj == 'string')) {
            return !obj || obj.replace(/\s+/g, "") == ""
        } else {
            return (!obj || JSON.stringify(obj) === "{}" || obj.length === 0);
        }
    },

    /**
     * 非空校验
     */
    isNotEmpty: function (obj) {
        return !this.isEmpty(obj);
    },

    isNull: function(val) {
        if (val == null || typeof val == 'undefined' || val === '') {
            return true;
        } else {
            return false;
        }
    },

    isNotNull: function(val) {
        return !this.isNull(val);
    },

    /**
     * 长度校验
     */
    isLength: function (str, min, max) {
        return $.trim(str).length >= min && $.trim(str).length <= max;
    },

    /**
     * 时间格式化，date为空时取当前时间
     */
    dateFormat: function (format, date) {
        let result;
        if (!date) {
            date = new Date();
        }
        const option = {
            "y+": date.getFullYear().toString(),        // 年
            "M+": (date.getMonth() + 1).toString(),     // 月
            "d+": date.getDate().toString(),            // 日
            "h+": date.getHours().toString(),           // 时
            "m+": date.getMinutes().toString(),         // 分
            "s+": date.getSeconds().toString()          // 秒
        };
        for (let i in option) {
            result = new RegExp("(" + i + ")").exec(format);
            if (result) {
                format = format.replace(result[1], (result[1].length == 1) ? (option[i]) : (option[i].padStart(result[1].length, "0")))
            }
        }
        return format;
    },

    /**
     * 移除对象数组中的对象
     * @param array
     * @param obj
     * @returns {number}
     */
    removeObj: function (array, obj) {
        let index = -1;
        for (let i = 0; i < array.length; i++) {
            if (array[i] === obj) {
                array.splice(i, 1);
                index = i;
                break;
            }
        }
        return index;
    },

    /**
     * 10进制转62进制
     * @param number
     * @returns {string}
     * @private
     */
    _10to62: function (number) {
        let chars = '0123456789abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ';
        let radix = chars.length;
        let arr = [];
        do {
            let mod = number % radix;
            number = (number - mod) / radix;
            arr.unshift(chars[mod]);
        } while (number);
        return arr.join('');
    },

    /**
     * 保存登录用户信息
     */
    setLoginUser: function (loginUser) {
        SessionStorage.set(SESSION_KEY_LOGIN_USER, loginUser);
    },

    /**
     * 获取登录用户信息
     */
    getLoginUser: function () {
        return SessionStorage.get(SESSION_KEY_LOGIN_USER) || '';
    },

    /**
     * 保存到session storage
     * @param param_key
     * @param param_value
     */
    setStorageParam: function(param_key, param_value) {
        SessionStorage.set(param_key, param_value);
    },

    /**
     * 获取session storage值
     * @param param_key
     * @returns {any|string}
     */
    getStorageParam: function(param_key) {
        return SessionStorage.get(param_key) || '';
    },

    /**
     * 随机生成[len]长度的[radix]进制数
     * @param len
     * @param radix 默认62
     * @returns {string}
     */
    uuid: function (len, radix) {
        let chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
        let uuid = [];
        radix = radix || chars.length;

        for (let i = 0; i < len; i++) {
            uuid[i] = chars[0 | Math.random() * radix];
        }

        return uuid.join('');
    },

    /**
     * 数组转树
     * @param list
     * @param parentId
     */
    // listToTree: function(list, parentId = null) {
    //     return list.
    // }

}
