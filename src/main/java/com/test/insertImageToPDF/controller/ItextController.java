package com.test.insertImageToPDF.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;
import com.test.insertImageToPDF.service.ItextService;

@CrossOrigin(origins = "*")
@RestController
public class ItextController {

	@Autowired
	private ItextService service;
	
	@GetMapping(path="/pdf")
	public void savePdf() throws IOException, DocumentException {
		service.insertImage();
	}
	
}
