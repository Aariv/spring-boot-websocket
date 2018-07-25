/**
 * 
 */
package com.zentere.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.zentere.websocket.model.Message;

/**
 * @author arivu
 *
 */
@Component
public class WebsocketEventListner {

	 @Autowired
	    private SimpMessageSendingOperations messagingTemplate;

	    @EventListener
	    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
	    }

	    @EventListener
	    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
	        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

	        String username = (String) headerAccessor.getSessionAttributes().get("username");
	        if(username != null) {

	            Message message = new Message();
	            message.setType(Message.MessageType.LEAVE);
	            message.setSender(username);

	            messagingTemplate.convertAndSend("/topic/public", message);
	        }
	    }
}
