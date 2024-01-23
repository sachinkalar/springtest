package com.rays.form;

import javax.persistence.Column;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.UserDTO;

public class UserForm extends BaseForm {

	@Column(name = "FIRST_NAME",length = 50)
	private String firstName;

	
	@Column(name = "LAST_NAME",length = 50)
	private String lastName;

	
	@Column(name = "LOGIN",length = 50)
	private String login;

	
	@Column(name = "PASSWORD",length = 50)
	private String password;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public BaseDTO getDto() {

		UserDTO dto = initDTO(new UserDTO());

		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setLogin(login);
		dto.setPassword(password);
		dto.setId(id);

		return dto;
	}
}
