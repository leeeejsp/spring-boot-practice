package com.kosa.mysite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
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
	
	@Query("select new com.kosa.mysite.dto.CourseDTO$Course(c.name, c.category, c.rating, c.description) from Course c where c.id=:id")
	Optional<CourseDTO.Course> getById(@Param("id") Long id);
	
	@Modifying
	@Query("update Course c set c.name=:#{#course.name}, c.category=:#{#course.category}, c.rating=:#{#course.rating}, c.description=:#{#course.description} where c.id=:id")
	int updateCourse(@Param("id") Long id, @Param("course") CourseDTO.Course course);
	
	@Modifying
	@Query("delete from Course c where c.id=:id")
	void deleteCourse(@Param("id") Long id);
}
