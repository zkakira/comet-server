<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (this.readyState > 2) {
			var response = this.responseText;
			var content = document.getElementById('content')
			content.innerHTMl = '';
			content.innerHTML = response;
		}
	}
	
	xhr.open("get", "/comet/xhrstreaming", true);
	xhr.send();
</script>
</head>
<body>
    <div id="content"></div>
</body>
</html>