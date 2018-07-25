/**
 * 
 */
package com.zentere.websocket.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zentere.websocket.model.Message;
import com.zentere.websocket.model.Messages;
import com.zentere.websocket.repository.MessageRepository;
import com.zentere.websocket.repository.UserRepository;
import com.zentere.websocket.service.MessageService;

/**
 * @author arivu
 *
 */
@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void saveMessage(Message message) {
		Messages messages = new Messages();
		messages.setMessage(message.getContent());
		messages.setUser(userRepository.findByUser(message.getSender()));
		messageRepository.save(messages);
	}

}
