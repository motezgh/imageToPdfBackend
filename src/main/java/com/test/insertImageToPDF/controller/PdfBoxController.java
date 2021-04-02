package com.test.insertImageToPDF.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.insertImageToPDF.service.PdfBoxService;

@CrossOrigin(origins = "*")
@RestController
public class PdfBoxController {

	@Autowired
	private PdfBoxService pdfBoxService;
	
	@GetMapping(path="/pdfBox")
	public void savePdf() throws Exception {
		pdfBoxService.insertImagePdfBox();
	}
	
}
