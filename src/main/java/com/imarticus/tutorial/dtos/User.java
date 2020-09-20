package com.imarticus.tutorial.dtos;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class User {

	public User() {
		
	}
	public User( String username,String password) {
		super();
		this.password = password;
		this.username = username;
		this.created = new Date();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(hidden = true)
	private Long id;
	

	@CreationTimestamp
	@ApiModelProperty(hidden = true)
	private Date created;

	
	

	@ApiModelProperty(example = "admin@imarticus.com")	
	private String username;
	
	@ApiModelProperty( example = "admin")
	private String password;

	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}
