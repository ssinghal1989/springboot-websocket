package com.example.websocket;

import org.springframework.web.socket.WebSocketSession;

public class UserSession {
	
	private String username;
	private WebSocketSession session;
	
	public UserSession() {
	}
	
	public UserSession(String username, WebSocketSession session) {
		super();
		this.username = username;
		this.session = session;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public WebSocketSession getSession() {
		return session;
	}
	public void setSession(WebSocketSession session) {
		this.session = session;
	}

}
