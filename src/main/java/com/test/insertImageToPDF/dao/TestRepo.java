package com.test.insertImageToPDF.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.insertImageToPDF.entities.Test;

public interface TestRepo extends JpaRepository<Test, Long>{

}
