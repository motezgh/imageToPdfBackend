package com.test.insertImageToPDF.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.insertImageToPDF.payload.request.InfoForm;
import com.test.insertImageToPDF.service.InfoService;

@CrossOrigin(origins = "*")
@RestController
public class InfoController {

	@Autowired
	private InfoService infoService;
	
	@PostMapping("/insertInfo")
	public void insertInfo(@RequestBody InfoForm infoForm) {
		infoService.insertInfo(infoForm);
	}
	
}
