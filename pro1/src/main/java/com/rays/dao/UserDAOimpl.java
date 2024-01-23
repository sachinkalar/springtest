package com.rays.dao;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.BaseDAOInt;
import com.rays.dto.UserDTO;

@Repository
public class UserDAOimpl extends BaseDAOImpl<UserDTO> implements UserDAOInt{

	@Override
	public Class<UserDTO> getDTO() {
		// TODO Auto-generated method stub
		return UserDTO.class;
	}

}
