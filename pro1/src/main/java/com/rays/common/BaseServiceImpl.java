package com.rays.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dto.UserDTO;

public class BaseServiceImpl<T extends BaseDTO, D extends BaseDAOInt<T>> implements BaseServiceInt<T> {

	@Autowired
	public D baseDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(T dto) {
		return baseDao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(T dto) {
		baseDao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public T findById(Long id) {
		return baseDao.findById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public long save(T dto) {
		Long id = dto.getId();
		if (id != null && id > 0) {
			update(dto);
		} else {
			id = add(dto);
		}
		return id;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List search(UserDTO dto) {
		return baseDao.search(dto);
	}

}
