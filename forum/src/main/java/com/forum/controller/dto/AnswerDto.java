package com.forum.controller.dto;

import java.time.LocalDateTime;

import com.forum.model.Answer;

public class AnswerDto {
	
	private Long id;
	private String message;
	private LocalDateTime creationDate;
	private String authorName;
	
	public AnswerDto(Answer answer) {
		this.id = answer.getId();
		this.message = answer.getMessage();
		this.creationDate = answer.getCreationDate();
		this.authorName = answer.getAuthor().getName();
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public String getAuthorName() {
		return authorName;
	}
	
}
