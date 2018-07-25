/**
 * 
 */
package com.zentere.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.zentere.websocket.model.Message;
import com.zentere.websocket.model.Messages;
import com.zentere.websocket.model.User;
import com.zentere.websocket.service.MessageService;
import com.zentere.websocket.service.UserService;
/**
 * @author arivu
 *
 */
@Controller
public class MessageController {

	@Autowired
	UserService userService;
	
	@Autowired
	MessageService messageService;
	
	User user;
	
	@MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
	public Message sendMessage(@Payload Message message) {
		messageService.saveMessage(message);
		return message;
	}
	
	@MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message addUser(@Payload Message message, 
                               SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        user = new User();
        user.setUser(message.getSender());
        userService.saveUser(user);
        return message;
    }

	
}
