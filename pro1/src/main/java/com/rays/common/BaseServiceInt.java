package com.rays.common;

import java.util.List;

import com.rays.dto.UserDTO;

public interface BaseServiceInt<T extends BaseDTO> {
	
	public long add(T dto);
	public void update(T dto);
	public T findById(Long id);
	public long save(T dto);
	public List search(UserDTO dto);

}
