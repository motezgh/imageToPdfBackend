package com.test.insertImageToPDF.service;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BadPdfFormatException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImage;
import com.itextpdf.text.pdf.PdfIndirectObject;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.test.insertImageToPDF.dao.TestRepo;
import com.test.insertImageToPDF.entities.Test;

@Service
public class ItextService {
	@Autowired
	private TestRepo testRepo;

	public void insertImage() throws IOException, DocumentException {
		
		Test test=testRepo.findById((long) 1).get();
		
		PdfReader reader = new PdfReader(System.getProperty("user.home")+"/testNGSign/pdf.pdf");
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(System.getProperty("user.home")+"/testNGSign/final.pdf"));
        Image image = Image.getInstance(System.getProperty("user.home")+"/testNGSign/image.jpg");
        PdfImage stream = new PdfImage(image, "", null);
        stream.put(new PdfName("ITXT_SpecialId"), new PdfName("123456789"));
        PdfIndirectObject ref = stamper.getWriter().addToBody(stream);
        image.setDirectReference(ref.getIndirectReference());
        image.setAbsolutePosition(test.getPositionX(), test.getPositionY());
        PdfContentByte over = stamper.getOverContent(test.getPositionPage());
        over.addImage(image);
        stamper.close();
        reader.close();
	}
	
}
