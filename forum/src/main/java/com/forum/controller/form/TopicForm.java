package com.forum.controller.form;

import com.forum.model.Course;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import com.forum.model.Topic;
import com.forum.repository.CourseRepository;
import com.sun.istack.NotNull;

public class TopicForm {
	
	@NotNull @NotEmpty @Length(min=5)
	private String title;
	@NotNull @NotEmpty @Length(min=10)
	private String message;
	@NotNull @NotEmpty
	private String courseName;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) { 
		this.title = title;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Topic convert(CourseRepository courseRepository) {
		Course course = courseRepository.findByName(courseName);
		return new Topic(title, message, course);
	}

	
}
