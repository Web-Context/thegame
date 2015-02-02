/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.webcontext.apps.thegame.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * User for the TheGame application. this entity is used to identitied user
 * account on the web site.
 * 
 * @author Frédéric Delorme<frederic.delorme@web-context.com>
 *
 */
@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table(name = "GAMEUSERS", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements Serializable {

	@Id 
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String username;

	@Size(min = 1, max = 40)
	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String firstname;

	@Size(min = 1, max = 40)
	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String lastname;
	
	@NotNull
	@Size(min = 8, max = 25)
	private String password;

	@NotNull
	@NotEmpty
	@Email
	private String email;

	@NotNull
	@Size(min = 10, max = 12)
	@Digits(fraction = 0, integer = 12)
	@Column(name = "phone_number")
	private String phoneNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (username != null)
			builder.append("username=").append(username).append(", ");
		if (firstname != null)
			builder.append("firstname=").append(firstname).append(", ");
		if (lastname != null)
			builder.append("lastname=").append(lastname).append(", ");
		if (password != null)
			builder.append("password=").append(password).append(", ");
		if (email != null)
			builder.append("email=").append(email).append(", ");
		if (phoneNumber != null)
			builder.append("phoneNumber=").append(phoneNumber);
		builder.append("]");
		return builder.toString();
	}


}
