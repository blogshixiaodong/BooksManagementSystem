function getBookList() {
	$.ajax({
		url: "BookListController",
		//dataType: "json",
		success: function(responseText) {
			var domList = $('#bookList');
			$("#bookList").html("");
			//JSON对象转JavaScript对象
			var json = JSON.parse(responseText);
			for(var i = 0; i < json.length; i++) {
				//获取节点模板，定义在index.jsp
				var tr = $("#fileListTrTemp").html();
				domList.append(tr);
				var index = 0;
				//通过父节点修改DOM
				tr = $("#bookList").children("tr")[i];
				for(var field in json[i]) {
					$(tr).children("td")[index].innerText = json[i][field];
					index++;
				}
				
				//设置链接
				//$(tr).find(".downloadFile").attr("href", "servlet/FileDownload?fileName=" + json[i].fileName + "." + json[i].fileType);
				//$(tr).find(".deleteFile").attr("href", "servlet/FileDelete?fileId=" + json[i].fileId);
				
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
			alert(textStatus);
		}
	});
};