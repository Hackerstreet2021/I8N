package com.realcoderz.service;

import java.util.List;

import com.realcoderz.model.Language;

public interface LanguageService {
	
	List<Language> findAll();
	Language findById(String id);
	Language save(Language language);
	void deleteById(String id);
	Language findByIsDefault(Boolean isDefault);
}
