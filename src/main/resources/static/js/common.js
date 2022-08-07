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

function gfn_Alert(content, paramFunc) {
    if (content.length > 400) {
        content = content.substring(0, 400) + "...";
    }

    if (typeof paramFunc !== undefined) {
        swal({
            title: "提示"
            ,text: content
            ,html: true
            ,confirmButtonText: "确认"
        });
    } else {
        swal({
            title: "提示"
            ,text: content
            ,html: true
            ,confirmButtonText: "确认"
        }, function() {
            if (typeof paramFunc !== undefined) {
                paramFunc();
            }
        });
    }
}

function gfn_Confirm(msg, paramFunc) {
    if (top != self) {
        top.swal({
            title: "确认"
            , text: msg
            , html: true
            , type: "warning"
            , showCancelButton: true
            , cancelButtonText: "取消"
            , confirmButtonColor: "#DD6B55"
            , confirmButtonText: "确认"
            , closeOnConfirm: true
        }, function (isConfirm) {
            if (isConfirm && typeof paramFunc != "undefined") {
                paramFunc();
            }
        });
    } else {
        swal({
            title: "确认"
            , text: msg
            , html: true
            , type: "warning"
            , showCancelButton: true
            , cancelButtonText: "取消"
            , confirmButtonColor: "#DD6B55"
            , confirmButtonText: "确认"
            , closeOnConfirm: true
        }, function (isConfirm) {
            if (isConfirm && typeof paramFunc != "undefined") {
                paramFunc();
            }
        });
    }
}

