var domain = "http://localhost:10001";
var storeId = 1;
window.T = {};
var url = function(name) {
  var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
  var r = window.location.search.substr(1).match(reg);
  if(r!=null)return  unescape(r[2]); return null;
};
T.p = url;