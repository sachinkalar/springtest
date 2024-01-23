package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.BaseServiceInt;
import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserDTO,UserDAOInt> implements UserServiceInt{

	}
