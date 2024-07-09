package com.kosa.mysite.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	
	@Data
	public static class Course {
		private String name;
		private String category;
		private Integer rating;
		private String description;
		
		public Course(@JsonProperty("name") String name, @JsonProperty("category") String category, 
				@JsonProperty("rating") Integer rating, @JsonProperty("description") String description) {
            this.name = name;
            this.category = category;
            this.rating = rating;
            this.description = description;
        }
	}
	
}
