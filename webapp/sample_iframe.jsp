<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
function callback(msg) {
	alert('call parent callback method');
    $('#content').text(msg);	
}
</script>
</head>
<body>
	<iframe style="width:0px; height:0px" src="/comet/iframe"></iframe>
    <div id="content"></div>
</body>
</html>