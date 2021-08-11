package com.athensoft.edusys.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athensoft.edusys.product.entity.Topic;
import com.athensoft.edusys.product.service.TopicService;

@RestController
@RequestMapping("/edusys/product")
public class TopicController {
	private final TopicService topicService;
	
	public TopicController(TopicService topicService) {
		this.topicService = topicService;
	}
	
	@GetMapping("/topics")
	public ResponseEntity<List<Topic>> getDataListTopic(){
		return ResponseEntity.ok(topicService.getTopicList());
	}
	
	@GetMapping("/topics/{topicId}")
	public ResponseEntity<Topic> getDataTopic(@PathVariable Integer topicId){
		return ResponseEntity.ok(topicService.getTopicById(topicId));
	}
	
	@PostMapping("/topics")
	public ResponseEntity<Topic> createTopic(@RequestBody Topic topic){
		return topicService.createTopic(topic);
	}
	
	@PutMapping("/topics")
	public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic){
		return topicService.updateTopic(topic);
	}
	
	@DeleteMapping("/topics")
	public ResponseEntity<Topic> deleteTopic(@RequestBody Topic topic){
		return topicService.deleteTopic(topic);
	}
	
	@DeleteMapping("/topics/{topicId}")
	public ResponseEntity<Topic> deleteTopicById(@PathVariable Integer topicId){
		return topicService.deleteTopicById(topicId);
	}
}
