function checkForm() {
	var uid = $("input[name='uid']").val();
	if(isNullOrEmpty(uid)) {
		alert("请输入查询账号!");
		return false;
	}
	var uidReg = /\d+/;
	if(!uidReg.test(uid)) {
		alert("请输入合法账号!");
		return false;
	}
	return true;
}