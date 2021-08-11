package com.athensoft.edusys.product.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.athensoft.edusys.error.exceptions.TopicAlreadyExistsException;
import com.athensoft.edusys.error.exceptions.TopicNotFoundException;
import com.athensoft.edusys.product.dao.TopicRepository;
import com.athensoft.edusys.product.entity.Topic;

@Service
public class TopicService {
	private final TopicRepository topicRepo;

	public TopicService(TopicRepository topicRepo) {
		this.topicRepo = topicRepo;
	}

	public List<Topic> getTopicList() {
		return topicRepo.findAll();
	}
	
	public Topic getTopicById(Integer topicId) {
		return topicRepo.findById(topicId).orElseThrow(() -> new TopicNotFoundException(topicId));
	}
	
	public ResponseEntity<Topic> createTopic(Topic topic){
		checkTopicAlreadyExistsException(topic.getTopicId());
		return new ResponseEntity<>(topicRepo.save(topic), HttpStatus.CREATED);
	}
	
	public ResponseEntity<Topic> updateTopic(Topic topic){
		checkTopicNotFoundException(topic.getTopicId());
		return ResponseEntity.ok(topicRepo.save(topic));
	}
	
	public ResponseEntity<Topic> deleteTopic(Topic topic){
		Integer topicId = topic.getTopicId();
		checkTopicNotFoundException(topicId);
		topicRepo.deleteById(topicId);
		return ResponseEntity.ok(topic);
	}
	
	public ResponseEntity<Topic> deleteTopicById(Integer topicId){
		checkTopicNotFoundException(topicId);
		Topic deletedTopic = getTopicById(topicId);
		topicRepo.deleteById(topicId);
		return ResponseEntity.ok(deletedTopic);
	}
	
	private void checkTopicAlreadyExistsException(Integer topicId) {
		if(topicRepo.existsById(topicId)) {
			throw new TopicAlreadyExistsException(topicId);
		}
	}
	
	private void checkTopicNotFoundException(Integer topicId) {
		if(!topicRepo.existsById(topicId)) {
			throw new TopicNotFoundException(topicId);
		}
	}
}
