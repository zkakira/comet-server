<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    setInterval(function() {
    $.get("/comet/polling", function(data, status) {
            $("#content").text("Data: " + data + "\nStatus: " + status);
        });
	}, 1000);
});
</script>
</head>
<body>
<div id="content"></div>
</body>
</html>