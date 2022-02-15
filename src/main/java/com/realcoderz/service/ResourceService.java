package com.realcoderz.service;

import java.util.List;

import com.realcoderz.model.Resource;


public interface ResourceService {
	
	List<Resource> findAll();

	Resource findById(Resource.ResourceId resourceId);

	Resource save(Resource resource);

	void deleteById(Resource.ResourceId resourceId);

	Resource findByLanguageAndReference(String language, String reference);

	List<Resource> findByReference(String reference);

}
