package com.kosa.mysite.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kosa.mysite.dto.CourseDTO;
import com.kosa.mysite.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{

	@Query("select c from Course c where c.category=:category")
	Iterable<Course> findAllByCategory(@Param("category") String category);
	
	@Query("select new com.kosa.mysite.dto.CourseDTO$ResponseCourse(c.name, c.category) from Course c")
	Iterable<CourseDTO.ResponseCourse> getAll();
	
	
}
