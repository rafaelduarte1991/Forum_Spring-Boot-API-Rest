package com.forum.controller;

import java.net.URI;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.forum.controller.dto.TopicDetailsDto;
import com.forum.controller.dto.TopicDto;
import com.forum.controller.form.TopicForm;
import com.forum.controller.form.UpdateTopicForm;
import com.forum.model.Topic;
import com.forum.repository.CourseRepository;
import com.forum.repository.TopicRepository;

@RestController
@RequestMapping("/topics")
public class TopicsController {
	
	@Autowired
	public TopicRepository topicRepository;
	@Autowired
	public CourseRepository courseRepository;
	
	@GetMapping
	@Cacheable(value = "topicsList")
	public Page<TopicDto> topicsList(@RequestParam(required = false) String courseName, 
			@PageableDefault(sort = "creationDate", direction = Direction.DESC, page = 0, size = 10) Pageable pagination){
					
		if(courseName == null) {
			Page<Topic> topic = topicRepository.findAll(pagination);	 
			return TopicDto.convert(topic);
		} else { 
			Page<Topic> topic = topicRepository.findByCourseName(courseName, pagination);	
			return TopicDto.convert(topic); 
		}
	}
	@PostMapping
	@Transactional
	@CacheEvict(value = "topicsList", allEntries = true)
	public ResponseEntity<TopicDto> register (@RequestBody @Valid TopicForm form, UriComponentsBuilder uriBuilder) {
		Topic topic = form.convert(courseRepository);
		topicRepository.save(topic);
		
		URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicDto(topic));		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TopicDetailsDto> detail(@PathVariable Long id) {
		Optional<Topic> topic = topicRepository.findById(id);
		if(topic.isPresent()) {
		return ResponseEntity.ok(new TopicDetailsDto(topic.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "topicsList", allEntries = true)
	public ResponseEntity<TopicDto> update(@PathVariable Long id, @RequestBody @Valid UpdateTopicForm form) {
		Optional<Topic> optional = topicRepository.findById(id);
		if(optional.isPresent()) {
			Topic topic = form.update(id, topicRepository); 		
			return ResponseEntity.ok(new TopicDto(topic));	
		}
		return ResponseEntity.notFound().build();
	
			
	}
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "topicsList", allEntries = true)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Topic> topic = topicRepository.findById(id);
		if(topic.isPresent()) {
		topicRepository.deleteById(id);
		return ResponseEntity.ok().build();	
		}
		return ResponseEntity.notFound().build();
	}
}
