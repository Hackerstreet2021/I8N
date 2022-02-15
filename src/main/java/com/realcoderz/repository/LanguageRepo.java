package com.realcoderz.repository;

import org.springframework.data.repository.CrudRepository;

import com.realcoderz.model.Language;


public interface LanguageRepo extends CrudRepository<Language, String> {
    Language findByIsDefault(Boolean isDefault);
}
