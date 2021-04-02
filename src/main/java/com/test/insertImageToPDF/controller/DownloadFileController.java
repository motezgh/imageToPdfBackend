package com.test.insertImageToPDF.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*")
@RestController
public class DownloadFileController {

	@Autowired
	private HttpServletResponse httpServletResponse;
	
	@GetMapping("/download")
	 public void getResource(HttpServletResponse response) throws ResourceNotFoundException, IOException {

	    
	    File downloadFile= new File(System.getProperty("user.home")+"/testNGSign/final.pdf");

	    byte[] isr = Files.readAllBytes(downloadFile.toPath());
	    
	    ByteArrayOutputStream out = new ByteArrayOutputStream(isr.length);
	    out.write(isr, 0, isr.length);

	    response.setContentType("application/pdf");
	    // Use 'inline' for preview and 'attachement' for download in browser.
	    response.addHeader("Content-Disposition", "inline; filename=final.pdf" );

	    OutputStream os;
	    try {
	        os = httpServletResponse.getOutputStream();
	        out.writeTo(os);
	        os.flush();
	        os.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    /*HttpHeaders respHeaders = new HttpHeaders();
	    respHeaders.setContentLength(isr.length);
	    respHeaders.setContentType(new MediaType("text", "json"));
	    respHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
	    respHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=final.pdf" );
	    
	    return new ResponseEntity<byte[]>(isr,respHeaders, HttpStatus.OK);*/

	 }
	
}
