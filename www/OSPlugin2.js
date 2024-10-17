const exec = require('cordova/exec');

var OSPlugin2 = {
    print: function (content, successCallback, errorCallback) {
        exec(successCallback, errorCallback, 'OSPlugin2', 'print', [content]);
    }
};

module.exports = OSPlugin2;
