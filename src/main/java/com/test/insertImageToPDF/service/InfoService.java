package com.test.insertImageToPDF.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.insertImageToPDF.dao.TestRepo;
import com.test.insertImageToPDF.entities.Test;
import com.test.insertImageToPDF.payload.request.InfoForm;

@Service
public class InfoService {

	@Autowired
	private TestRepo testRepo;
	
	public void insertInfo(InfoForm infoForm) {
		Test test=testRepo.findById((long)1).get();
		test.setPositionPage(infoForm.getPage());
		test.setPositionX(infoForm.getX());
		test.setPositionY(infoForm.getY());
		testRepo.save(test);
	}
	
}
