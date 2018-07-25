/**
 * 
 */
package com.zentere.websocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zentere.websocket.model.Messages;

/**
 * @author arivu
 *
 */
public interface MessageRepository extends JpaRepository<Messages, Long>{

}
