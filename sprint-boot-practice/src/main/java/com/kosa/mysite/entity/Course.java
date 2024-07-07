package com.kosa.mysite.entity;

import com.kosa.mysite.dto.CourseDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "COURSES")
@SequenceGenerator(
		name = "SEQ_COURSE_GEN",
		sequenceName = "SEQ_COURSE",
		initialValue = 1,
		allocationSize = 1
		)
public class Course {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COURSE_GEN")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "RATING")
	private Integer rating;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	public Course(CourseDTO.RequestCreateCourse requestCourseDTO) {
		this.name = requestCourseDTO.getName();
		this.category = requestCourseDTO.getCategory();
		this.rating = requestCourseDTO.getRating();
		this.description = requestCourseDTO.getDescription();
	}
	
	public Course() {}
}
