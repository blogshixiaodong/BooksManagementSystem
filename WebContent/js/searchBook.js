function checkForm() {
	var bid = $("input[name='bid']").val();
	var bname = $("input[name='bname']").val();
	var author = $("input[name='author']").val();
	var press = $("input[name='press']").val();
	var publishTime = $("input[name='publishTime']").val();
	
	if(isNullOrEmpty(bid) && isNullOrEmpty(bname) && isNullOrEmpty(author) && isNullOrEmpty(press) && isNullOrEmpty(publishTime)) {
		alert("请至少输入一项查询条件!");
		return false;
	}
	var bidReg = /[0-9]+/;
	if(!isNullOrEmpty(bid) && !bidReg.test(bid)) {
		alert("请输入合法图书编号!");
		return false;
	}
	var timeReg = /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
	if(isNullOrEmpty(publishTime) == false && timeReg.test(publishTime) == false) {
		alert("请输入合法日期!");
		return false;
	}
	return true;
	
}