package com.realcoderz.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.realcoderz.model.Resource;
import com.realcoderz.repository.ResourceRepo;
import com.realcoderz.service.ResourceService;

@Service
@CacheConfig(cacheNames = { "resources-cache" })
public class ResourceServiceImpl implements ResourceService {

    //private static final Logger LOGGER = LoggerFactory.getLogger(ResourceServiceImpl.class);

    @Autowired
    private ResourceRepo resourcerepo;

    @Cacheable
    @Override
    public List<Resource> findAll() {
	//LOGGER.info("Cacheable all");
	return (List<Resource>) resourcerepo.findAll();
    }

    @Cacheable
    @Override
    public Resource findById(Resource.ResourceId resourceId) {
	//LOGGER.info("Cacheable resourceId=[{}]", resourceId);
	return resourcerepo.findById(resourceId).orElse(null);
    }

    @Override
    public Resource save(Resource resource) {
	return resourcerepo.save(resource);
    }

    @Override
    public void deleteById(Resource.ResourceId resourceId) {
    	resourcerepo.deleteById(resourceId);
    }

    @Cacheable
    @Override
    public Resource findByLanguageAndReference(String language, String reference) {
	//LOGGER.info("Cacheable language=[{}], reference=[{}]", language, reference);
	return resourcerepo.findByLanguageAndReference(language, reference);
    }

    @Cacheable
    @Override
    public List<Resource> findByReference(String reference) {
	//LOGGER.info("Cacheable reference=[{}]", reference);
	return resourcerepo.findByReference(reference);
    }

}
