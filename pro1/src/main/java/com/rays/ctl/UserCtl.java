package com.rays.ctl;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rays.attachment.AttachmentDTO;
import com.rays.attachment.AttachmentServiceInt;
import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.UserDTO;
import com.rays.form.UserForm;
import com.rays.service.UserServiceInt;

@RestController
@RequestMapping(value = "User")
public class UserCtl extends BaseCtl<UserForm, UserDTO, UserServiceInt> {

	@Autowired
	public AttachmentServiceInt as;

	@PostMapping("profilePic/{userId}")
	public ORSResponse upload(@PathVariable Long userId, @RequestParam("file") MultipartFile file,
			HttpServletRequest req) {

		UserDTO dto = baseService.findById(userId);
		AttachmentDTO doc = new AttachmentDTO(file);
		doc.setDescription("profile");
		doc.setUserId(userId);

		if(dto.getImageId() != null && dto.getImageId() > 0) {
			doc.setId(dto.getImageId());
		}

		Long imageId = as.save(doc);

		if (dto.getImageId() == null) {
			dto.setImageId(imageId);
			baseService.add(dto);
		}
		ORSResponse res = new ORSResponse(true);
		res.addResult("imageId", imageId);
		return res;

	}

	@GetMapping("profilePic/{userId}")
	public @ResponseBody void download(@PathVariable Long userId, HttpServletResponse resp) {

		UserDTO dto = baseService.findById(userId);
		AttachmentDTO attachmentDTO = as.findById(dto.getImageId());

		try {

			if (attachmentDTO != null) {
				resp.setContentType(attachmentDTO.getType());
				OutputStream out = resp.getOutputStream();
				out.write(attachmentDTO.getDoc());
				out.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
