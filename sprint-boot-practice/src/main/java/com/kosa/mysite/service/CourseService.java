package com.kosa.mysite.service;

import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.kosa.mysite.dto.CourseDTO;

public interface CourseService {

	Iterable<CourseDTO.ResponseCourse> getAll();
	CourseDTO.Course getById(@Param("id") Long id);
	void updateCourse(@Param("id") Long id, @Param("course") CourseDTO.Course course);
	void deleteCourse(@Param("id") Long id);
}
