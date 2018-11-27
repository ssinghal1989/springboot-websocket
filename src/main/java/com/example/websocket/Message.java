package com.example.websocket;

public class Message {

    private String name;
    
    private String message;

    public String getMessage() {
		return message;
	}

	public void setMesssage(String messsage) {
		this.message = messsage;
	}

	public Message() {
    }

    public Message(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
