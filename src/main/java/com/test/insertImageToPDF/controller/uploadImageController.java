package com.test.insertImageToPDF.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.insertImageToPDF.service.ImageService;

@CrossOrigin(origins = "*")
@RestController
public class uploadImageController {

	@Autowired
	private ImageService imageService;
	
	@PostMapping(path="/uploadImage")
	public void uploadPhoto(@RequestParam("file") MultipartFile file) throws IOException {
		imageService.save(file);
	}
	
}
