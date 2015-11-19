package com.skplanet.comet;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocketEndpoint {
	@OnOpen
	public void handleOpen(Session session) throws IOException {
		System.out.println(session.getId() + " client is now connected...");
		session.getBasicRemote().sendText("Connected Established");
	}
	
	@OnMessage
	public String handleMessage(String message, Session session){
		System.out.println("receive from client : " + message);
		String replyMessage = "echo " + message;
		System.out.println("send to client : "+replyMessage);
		return replyMessage;
	}
	
	@OnClose
	public void handleClose(){
		System.out.println("client is now disconnected...");
	}
	
	@OnError
	public void handleError(Throwable t){
		t.printStackTrace();
	}
}
