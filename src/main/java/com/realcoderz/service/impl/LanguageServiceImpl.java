package com.realcoderz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.realcoderz.model.Language;
import com.realcoderz.repository.LanguageRepo;
import com.realcoderz.service.LanguageService;

@Service
@CacheConfig(cacheNames = { "languages-cache" })
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepo languageRepo;

    @Cacheable
    @Override
    public List<Language> findAll() {
	return (List<Language>) languageRepo.findAll();
    }

    @Cacheable
    @Override
    public Language findById(String id) {
	return languageRepo.findById(id).orElse(null);
    }

    @Override
    public Language save(Language language) {
	return languageRepo.save(language);
    }

    @Override
    public void deleteById(String id) {
    	languageRepo.deleteById(id);
    }

    @Override
    public Language findByIsDefault(Boolean isDefault) {
	return languageRepo.findByIsDefault(isDefault);
    }

}
