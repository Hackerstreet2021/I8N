package com.realcoderz.config;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class CustomLocaleResolver extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {
	
	    

	
	@Override	
    public Locale resolveLocale(HttpServletRequest request) {		
        String headerLang = request.getHeader("Accept-Language");        
        return null == headerLang || headerLang.isEmpty()
                ? Locale.getDefault()
                : Locale.forLanguageTag(headerLang);
    }
	
	
	
	@Bean	
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		/* Passing basename sould match to the properties file basename */
		messageSource.setBasename("message");
		
		return messageSource;
	}
	
 
}
