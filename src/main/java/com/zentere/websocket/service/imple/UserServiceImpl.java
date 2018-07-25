/**
 * 
 */
package com.zentere.websocket.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zentere.websocket.model.User;
import com.zentere.websocket.repository.UserRepository;
import com.zentere.websocket.service.UserService;

/**
 * @author arivu
 *
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void saveUser(User user) {
		if(userRepository.findByUser(user.getUser()) != null) {
			userRepository.save(user);
		}
	}

}
