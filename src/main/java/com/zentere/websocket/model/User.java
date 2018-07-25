/**
 * 
 */
package com.zentere.websocket.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author arivu
 *
 */
@Entity
@Table(name="tbl_user")
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String user;
	
	@OneToMany(mappedBy="user")
	private Set<Messages> messages;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Set<Messages> getMessages() {
		return messages;
	}

	public void setMessages(Set<Messages> messages) {
		this.messages = messages;
	}
	
	
}
