package com.calsoftdev.democontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.calsoftdev.model.Student;
import com.calsoftdev.repository.DBserviceRepository;

@RestController
@RequestMapping("/rest")
public class DBServiceController {
	
	private DBserviceRepository dbserviceRepository;

	public DBServiceController(DBserviceRepository dbserviceRepository) {
		super();
		this.dbserviceRepository = dbserviceRepository;
	}

	@GetMapping("/db")
	public List<Student> getName(){
		return dbserviceRepository.findByStudentId(5);
				//.stream().map(Student::getStudentName).collect(Collectors.toList());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Student> addStudentInfo(@RequestBody Student student){
		try {
			dbserviceRepository.save(student);
			return new ResponseEntity<Student>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.GONE);
		}
	}
}
