package com.calsoftdev.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calsoftdev.model.Student;

public interface DBserviceRepository extends JpaRepository<Student, Integer>{
	public ArrayList<Student> findByStudentId(Integer id);
}
