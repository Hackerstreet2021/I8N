package com.realcoderz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.realcoderz.service.I18nResourcesService;
import com.realcoderz.utils.I18nModule;


@Configuration
public class AppConfig {
    @Bean
    I18nModule i18nModule(I18nResourcesService i18nResourcesService) {
	return new I18nModule(i18nResourcesService);
    }
}
