package com.kosa.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.mysite.dto.CourseDTO;
import com.kosa.mysite.service.CourseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getCourseList(){
		return ResponseEntity.status(HttpStatus.OK)
							.body(courseService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCourseDetail(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK)
				.body(courseService.getById(id));
	}
	
	@PutMapping("/update/{id}")
	public void updateCourse(@PathVariable("id") Long id, @RequestBody CourseDTO.Course course){
		log.info("RequestBody 정보 : {}" , course.toString());
		courseService.updateCourse(id, course);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCourse(@PathVariable("id") Long id) {
		courseService.deleteCourse(id);
	}
	
}
