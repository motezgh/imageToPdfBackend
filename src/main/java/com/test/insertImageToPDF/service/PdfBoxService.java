package com.test.insertImageToPDF.service;

import java.io.File;
import java.io.IOException;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.insertImageToPDF.dao.TestRepo;
import com.test.insertImageToPDF.entities.Test;

@Service
public class PdfBoxService {

	@Autowired
	private TestRepo testRepo;
	
	public void insertImagePdfBox() throws IOException, Exception {
		Test test=testRepo.findById((long) 1).get();
		PDDocument doc = PDDocument.load(new File(System.getProperty("user.home")+"/testNGSign/pdf.pdf"));
		PDPage page = doc.getPage(test.getPositionPage()-1);
		PDImageXObject pdImage = PDImageXObject.createFromFile(System.getProperty("user.home")+"/testNGSign/image.jpg", doc);
		try(PDPageContentStream contentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, true, true))
		{
			float scale = 1f;
			contentStream.drawImage(pdImage, test.getPositionX(), test.getPositionY(), pdImage.getWidth() * scale, pdImage.getHeight() * scale);
		}
		doc.save(System.getProperty("user.home")+"/testNGSign/final.pdf");
	}
	
}
