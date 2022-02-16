package com.realcoderz.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realcoderz.response.PageResponse;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")

public class PageController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/msg")
	public PageResponse getMessage() {

		LOGGER.info("Inside PageController.getMessage()");

		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT,
				LocaleContextHolder.getLocale());
		
//		
//		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyy hh:mm:ss a");	
//		String strDate = sdf.format(new Date());
		
		TimeZone timezone=TimeZone.getTimeZone("IST");
		df.setTimeZone(timezone);		
		String strDate = df.format(new Date());
		
		LOGGER.info("Formatting Date according to particular Locale");

		

		PageResponse pr = new PageResponse(
				messageSource.getMessage("application.header", null, LocaleContextHolder.getLocale()),
				messageSource.getMessage("loggedin.user", null, LocaleContextHolder.getLocale()),
				messageSource.getMessage("logout", null, LocaleContextHolder.getLocale()),
				messageSource.getMessage("productHeader", null, LocaleContextHolder.getLocale()),
				messageSource.getMessage("addProduct", null, LocaleContextHolder.getLocale()),
				messageSource.getMessage("productId", null, LocaleContextHolder.getLocale()),
				messageSource.getMessage("productName", null, LocaleContextHolder.getLocale()),
				messageSource.getMessage("price", null, LocaleContextHolder.getLocale()),
				messageSource.getMessage("dateAdded", null, LocaleContextHolder.getLocale()),
				messageSource.getMessage("measurement", null, LocaleContextHolder.getLocale()),
				messageSource.getMessage("images", null, LocaleContextHolder.getLocale()),
				messageSource.getMessage("actions", null, LocaleContextHolder.getLocale()),
				messageSource.getMessage("update", null, LocaleContextHolder.getLocale()),
				messageSource.getMessage("view", null, LocaleContextHolder.getLocale()),
				messageSource.getMessage("delete", null, LocaleContextHolder.getLocale()),
				messageSource.getMessage("footer", null, LocaleContextHolder.getLocale()), strDate,
				messageSource.getMessage("save", null, LocaleContextHolder.getLocale()),
				messageSource.getMessage("cancel", null, LocaleContextHolder.getLocale())

		);

		LOGGER.info("PageResponse returned according to particular locale");
		return pr;
	}

}
