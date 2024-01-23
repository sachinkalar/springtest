package com.rays.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rays.dto.UserDTO;

public class BaseCtl<F extends BaseForm, T extends BaseDTO, S extends BaseServiceInt<T>> {

	@Autowired
	public S baseService;

	@PostMapping("save")
	public ORSResponse save(@RequestBody F form) {
		ORSResponse res = new ORSResponse(true);
		T dto = (T) form.getDto();
		baseService.add(dto);
		res.addData(dto);
		res.addMessage("registered..");
		return res;

	}

	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable Long id) {
		ORSResponse res = new ORSResponse(true);
		T dto = baseService.findById(id);
		res.addData(dto);
		return res;

	}

	@PostMapping("search")
	public ORSResponse search(@RequestBody F form) {
		ORSResponse res = new ORSResponse(true);
		UserDTO dto = (UserDTO) form.getDto();

		res.addData(baseService.search(dto));
		return res;
	}
}
