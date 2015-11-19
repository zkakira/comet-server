<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
var socket;
if ('WebSocket' in window) {
	socket = new WebSocket('ws://localhost:8080/comet/websocket');
	socket.onopen = function (event) {
        $('#messages').append(event.data + '<br />');
    }
	socket.onmessage = function (event) {
		 $('#messages').append(event.data + '<br />');
	}
	socket.onclose = function (event) {
		 $('#messages').append('connection closed<br />');
    }
}
function send() {
	socket.send('message~~~');
}
function close() {
	socket.close();
}
</script>
</head>
<body>
    <button type="button" onclick="send();">send</button>, 
    <button type="button" onclick="close();">close</button>
    <div id='messages'> </div>
</body>
</html>