package com.test.insertImageToPDF.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.test.insertImageToPDF.dao.TestRepo;
import com.test.insertImageToPDF.entities.Test;

@Service
public class FileService {
	
	@Autowired
	private TestRepo testRepo;

	public void save(MultipartFile file) throws IOException {
      
			Test test=testRepo.findById((long) 1).get();
		
			test.setPdfUrl("pdf.pdf");
			Files.write(Paths.get(System.getProperty("user.home")+"/testNGSign/"+test.getPdfUrl()), file.getBytes());
            
            testRepo.save(test);
        
    }
	
}
