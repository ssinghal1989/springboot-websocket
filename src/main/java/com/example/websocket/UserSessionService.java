package com.example.websocket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

@Service
public class UserSessionService {
	
	private List<UserSession> userSessions = new ArrayList<>(Arrays.asList());
	
	public void addUserSession(UserSession userSession){
		userSessions.add(userSession);
		System.out.println(userSessions);
	}
	
	public UserSession getUserSession(String username){
		if(userSessions.stream().filter(us -> us.getUsername().equals(username)).findFirst().isPresent()){
			return userSessions.stream().filter(us -> us.getUsername().equals(username)).findFirst().get();
		}else{
			return new UserSession();
		}
		
	}
	
	public void deleteUserSession(WebSocketSession webSocketSession){
		if(!userSessions.isEmpty()){
			userSessions.removeIf(us -> us.getSession().equals(webSocketSession));
			System.out.println(userSessions);
		}
		
	}
	
	public String getUserName(WebSocketSession webSocketSession){
		if(userSessions.stream().filter(us -> us.getSession().equals(webSocketSession)).findFirst().isPresent()){
			return userSessions.stream().filter(us -> us.getSession().equals(webSocketSession)).findFirst().get().getUsername();
		}else{
			return "No User found";
		}
	}
	
	public List<UserSession> getAllUserSessions(){
		return userSessions;
	}
}
