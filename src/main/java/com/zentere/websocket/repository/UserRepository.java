/**
 * 
 */
package com.zentere.websocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zentere.websocket.model.User;

/**
 * @author arivu
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{
	public User findByUser(String userName);
}
