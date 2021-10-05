package com.forum.controller.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.forum.model.Topic;
import com.forum.repository.TopicRepository;
import com.sun.istack.NotNull;

public class UpdateTopicForm {
	
	@NotNull @NotEmpty @Length(min=5)
	private String title;
	@NotNull @NotEmpty @Length(min=10)
	private String message;
	
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
	public Topic update(Long id, TopicRepository topicRepository) {
		Topic topic = topicRepository.getOne(id); 
		topic.setTitle(this.title);
		topic.setMessage(this.message);	
		return topic;
	}

	
}
