package com.rays.common;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.rays.dto.UserDTO;

public abstract class BaseDAOImpl <T extends BaseDTO> implements BaseDAOInt<T>{

	public abstract Class<T> getDTO();
	
	@Autowired
	public EntityManager entity;
	
	
	@Override
	public long add(T dto) {
		entity.persist(dto);
		return dto.getId();
	}

	@Override
	public void update(T dto) {
  entity.merge(dto);		
	}

	@Override
	public T findById(Long id) {
	T dto =	entity.find(getDTO(), id);
		return dto;
	}

	
	public List search(UserDTO dto) {
	CriteriaBuilder builder = 	entity.getCriteriaBuilder();
	CriteriaQuery<UserDTO> cq =  builder.createQuery(UserDTO.class) ;
	Root<UserDTO> qRoot =  cq.from(UserDTO.class);
	cq.where(builder.like(qRoot.get("firstName"), dto.getFirstName()));
	TypedQuery<UserDTO> tq =   entity.createQuery(cq);
	List list =  tq.getResultList();
	return list;
		}
	}


