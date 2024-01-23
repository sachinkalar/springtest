package com.rays.attachment;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;

@Repository
public class AttachmentDAOImpl extends BaseDAOImpl<AttachmentDTO> implements AttachmentDAOInt{

	@Override
	public Class<AttachmentDTO> getDTO() {
		// TODO Auto-generated method stub
		return AttachmentDTO.class;
	}

}
