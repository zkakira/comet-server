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
	$('#submit').click(function() { 
	   callPiggyback();  
	});
});

function callPiggyback() {
	$.get('/comet/piggyback', function(data) { 
        data = $.parseJSON(data);
        
        var valid = data.formValid; 
        
        // process validation results 
        if (valid == true) {
            // then process the other part of the response (events) 
            processEvents(data);    
        }
    });
}

function processEvents(data) {
	if (data.events == 'update') {
		$("#content").text("Data: " + data.content);		
	} else if (events = 'delete') {
		$("#content").text();
	} else {
		callPiggyback();
	}
}
</script>
</head>
<body>
<div id="content"></div>
<button id="submit" type="submit">submit</button>
</body>
</html>