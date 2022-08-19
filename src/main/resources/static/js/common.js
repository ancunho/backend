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