package com.example.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class SendMessageController {
	@Autowired
	private UserSessionService userSessionService;
	
	@RequestMapping(method=RequestMethod.POST, value="/sendMessage")
	public String greeting(@RequestBody Message message) throws Exception {
        if(userSessionService.getUserSession(message.getName()).getSession() == null){
        	return "user is not online";
        }else{
        	WebSocketSession recieverSession;
            recieverSession = userSessionService.getUserSession(message.getName()).getSession();
            System.out.println(message.getMessage());
            recieverSession.sendMessage(new TextMessage(message.getMessage()));
            return "Message sent Successfully";
        }
    }
}
