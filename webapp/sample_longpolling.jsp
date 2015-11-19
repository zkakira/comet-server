<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
var script = document.createElement('script');
script.type = 'text/javascript';
script.src = 'http://localhost:8080/comet/longpolling?callback=callback';
$('head').append(script);	
});

function callback(msg) {
    $('#content').text('called from the server : ' + msg);
}
</script>
</head>
<body>
    longpolling sample
	<div id="content"></div>
</body>
</html>