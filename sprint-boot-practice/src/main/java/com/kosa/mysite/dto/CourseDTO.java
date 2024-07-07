package com.kosa.mysite.dto;

import lombok.Builder;
import lombok.Data;

public class CourseDTO {
	
	@Data
	@Builder
	public static class ResponseCourse {
		private String name;
		private String category;
		
		public ResponseCourse(String name, String category) {
			this.name = name;
			this.category = category;
		}
	}
	
	@Data
	@Builder
	public static class RequestCreateCourse {
		private String name;
		private String category;
		private Integer rating;
		private String description;
	}
	
}
