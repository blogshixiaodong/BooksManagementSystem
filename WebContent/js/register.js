function checkForm() {
	var username = $("input[name='username']").val();
	var sex = $("input[name='sex']:checked").val();
	var age = $("input[name='age']").val();
	var password = $("input[name='password']").val();
	var repassword = $("input[name='repassword']").val();
	if(isNullOrEmpty(username)) {
		alert("请填写用户名!");
		return false;
	}
	if(isNullOrEmpty(sex)) {
		alert("请选择性别!");
		return false;
	}
	if(isNull(age)) {
		alert("请填写年龄!");
		return false;
	} else {
		var reg = /^\d*$/;
		if(!reg.test(age)) {
			alert("请填写合法年龄!");
			return false;
		}
	}
	if(isNullOrEmpty(password)) {
		alert("请填写密码!");
		return false;
	}
	if(isNullOrEmpty(repassword)) {
		alert("请填写确认密码!");
		return false;
	}
	if(password != repassword) {
		alert("两次密码不同!");
		return false;
	}
	return true;
}