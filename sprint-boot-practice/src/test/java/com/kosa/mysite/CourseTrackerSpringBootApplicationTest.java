package com.kosa.mysite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.kosa.mysite.dto.CourseDTO;
import com.kosa.mysite.entity.Course;
import com.kosa.mysite.repository.CourseRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class CourseTrackerSpringBootApplicationTest {

	@Autowired
	private CourseRepository courseRepository;
	
	@Transactional
	@Test
	public void createCourseTest() {
		CourseDTO.RequestCreateCourse course = CourseDTO.RequestCreateCourse.builder()
									.category("test_spring_boot")
									.description("test_spring_boot")
									.name("test_spring_boot")
									.rating(5)
									.build();
		log.info("생성 요청 : courseDTO => {}",course.toString());
		courseRepository.save(new Course(course));
		Course c = courseRepository.findById(15L).get();
		assertThat(c.getName()).isEqualTo("test_spring_boot");
	}
	
	@Test
	public void getCoursesByCategory() {
		Iterable<Course> courses = courseRepository.findAllByCategory("test_spring_boot");
		assertThat(courses).hasSize(2);
	}
	
	@Test
	public void getCourseList() {
		Iterable<CourseDTO.ResponseCourse> courses = courseRepository.getAll();
		assertThat(courses).hasSize(7);
	}
	
}
