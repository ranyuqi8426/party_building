var PublicUrl = "http://192.168.21.75:8080/party_building/";
//判空方法
function notNull(Str){
	if(Str==null || Str == ""){
		return true;
	}else{
		return false;
	}
}

function setStatusbarRed(){
    // 设置系统状态栏背景色为红色
    plus.navigator.setStatusBarBackground("#AC3039");
}

//错误处理
function errWork(){
	mui.toast('服务异常请重新打开或联系我们');
	plus.webview.currentWebview().close();
}
//时间格式化 年-月-日  时：分：秒
function datetimeformat(str) {
	var date = new Date(str);
	var year = date.getFullYear();
	var mon = date.getMonth() + 1;
	var day = date.getDate();
	var hh = date.getHours();
	var mm = date.getMinutes()
	var ss = date.getSeconds();
	return year.toString() + "-" + (mon < 10 ? "0" + mon : mon) + "-" + (day < 10 ? "0" + day : day) + " " + (hh < 10 ? "0" + hh : hh) + ":" + (mm < 10 ? "0" + mm : mm) + ":" + (ss < 10 ? "0" + ss : ss)
}
//时间格式化 年月日
function dateformat(str) {
	var date = new Date(str);
	var year = date.getFullYear();
	var mon = date.getMonth() + 1;
	var day = date.getDate();

	return year.toString() + (mon < 10 ? "0" + mon : mon) + (day < 10 ? "0" + day : day);
}
//时间格式化 年-月-日
function dateformat2(str) {
	var date = new Date(str);
	var year = date.getFullYear();
	var mon = date.getMonth() + 1;
	var day = date.getDate();

	return year.toString() + "-" + (mon < 10 ? "0" + mon : mon) + "-" + (day < 10 ? "0" + day : day)
}
//时间格式化 年-月-日
function dateformat3(str) {
	var date = new Date(str);
	var year = date.getFullYear();
	var mon = date.getMonth() + 1;

	return year.toString() + "年" + (mon < 10 ? "0" + mon : mon) + "月";
}








//获取用户信息
function getUserInfo(){
	var userInfo = localStorage.getItem('userInfo') || '[]';
	var uif = JSON.parse(userInfo);
	return uif;
}

var user_id = "";
var user_cd = "";
var user_nm = "";
var user_nicknm = "";
var user_tel = "";
var user_profilepic = "";
var role_id = "";
//获取用户信息  直接使用
function getUserInfoUse(){
	var userInfo = localStorage.getItem('user_info') || '[]';
	var uif = JSON.parse(userInfo);
	 user_id = uif.user_id || "";
	 user_cd = uif.user_cd || "";
	 user_nm = uif.user_nm || "";
	 user_nicknm = uif.user_nicknm || "";
	 user_tel = uif.user_tel || "";
	 user_profilepic = uif.user_profilepic || "";
	 role_id = uif.role_id || "";
}
mui.ajaxSettings.beforeSend = function(xhr, setting) { 
		console.log('beforeSend:::' + JSON.stringify(setting));
	};
function getPos() {
				plus.geolocation.getCurrentPosition(geoInf, function(e) {
					mui.toast("获取位置信息失败");
				}, {
					geocode: false
				});
			}