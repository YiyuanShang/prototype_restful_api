package com.athensoft.edusys.academic.service;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.athensoft.edusys.product.dao.TopicRepository;
import com.athensoft.edusys.product.entity.Topic;
import com.athensoft.edusys.product.service.TopicService;

@Converter
public class TopicConverter implements AttributeConverter<Topic, Integer> {
	private final TopicService topicService;
	
	public TopicConverter(TopicService topicService) {
		this.topicService = topicService;
	}
	
	@Override
	public Integer convertToDatabaseColumn(Topic topic) {
		if (topic == null) {
			return null;
		}
		return topic.getTopicId();
	}

	@Override
	public Topic convertToEntityAttribute(Integer topicId) {
		if (topicId == null || topicId <= 0) {
			return null;
		}
		return topicService.getTopicById(topicId);
	}

}
