package com.example.websocket;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

@Component
public class SocketHandler extends TextWebSocketHandler {
	
	public SocketHandler(){
	}
	
	public SocketHandler(UserSessionService userSessionService){
		this.userSessionService = userSessionService;
	}
	
//	@Autowired
	UserSessionService userSessionService; //  this is the service which am injecting
	
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {
		Map<String, String> value = new Gson().fromJson(message.getPayload(), Map.class);
		if(value.get("action").equals("register")){
			Map<String, String> payload = new Gson().fromJson(value.get("payload"), Map.class);
			UserSession userSession = new UserSession(payload.get("username").toString(),session);
			userSessionService.addUserSession(userSession); // here i am getting null pointer exception
			System.out.println(userSessionService);
		}
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception{
		userSessionService.deleteUserSession(session);
	}
}