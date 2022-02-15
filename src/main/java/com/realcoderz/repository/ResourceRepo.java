package com.realcoderz.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.realcoderz.model.Resource;


public interface ResourceRepo extends CrudRepository<Resource, Resource.ResourceId> {
    Resource findByLanguageAndReference(String language, String reference);
    List<Resource> findByReference(String reference);
}