package com.kosa.mysite.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kosa.mysite.dto.CourseDTO;
import com.kosa.mysite.dto.CourseDTO.Course;
import com.kosa.mysite.dto.CourseDTO.ResponseCourse;
import com.kosa.mysite.error.CustomException;
import com.kosa.mysite.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public Iterable<ResponseCourse> getAll() {
		return courseRepository.getAll();
	}

	@Override
	public CourseDTO.Course getById(Long id) {
		return courseRepository.getById(id)
				.orElseThrow(() -> new CustomException("존재하지 않는 게시물입니다.", HttpStatus.NOT_FOUND));
	}

	@Transactional
	@Override
	public void updateCourse(Long id, CourseDTO.Course course) {
		courseRepository.getById(id)
			.orElseThrow(() -> new CustomException("존재하지 않는 게시물입니다.", HttpStatus.NOT_FOUND));
		int result = courseRepository.updateCourse(id, course);
		if(result != 1) {
			throw new CustomException("올바른 요청이 아닙니다.", HttpStatus.BAD_REQUEST);
		}
	}

	@Transactional
	@Override
	public void deleteCourse(Long id) {
		courseRepository.getById(id)
					.orElseThrow(() -> new CustomException("이미 삭제된 게시물입니다.", HttpStatus.NOT_FOUND));
		courseRepository.deleteCourse(id);
	}

}
