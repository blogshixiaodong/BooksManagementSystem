function checkForm() {
	var username = $("input[name='username']").val();
	var password = $("input[name='password']").val();
	if(isNullOrEmpty(username)) {
		alert("请填写账号!");
		return false;
	}
	if(isNullOrEmpty(password)) {
		alert("请填写密码!");
		return false;
	}
	return true;
}