var exec = require("cordova/exec");

var sms = {
  send: function(success, fail, number, text){
    exec(success, fail, "Sms", "send", [number, text]);
  }
};