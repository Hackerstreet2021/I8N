package com.realcoderz.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

public class NumberUtils {

	private NumberUtils() {
	}

	public static double getDoubleValue(String value) throws ParseException {
		return NumberUtils.getDoubleValue(LocaleContextHolder.getLocale(), value);
	}

	public static double getDoubleValue(Locale loc, String value) throws ParseException {
		return NumberFormat.getInstance(loc).parse(value).doubleValue();
	}

	public static String convertStringAsStringNumberUnLocalized(String value) throws ParseException {
		return convertStringAsStringNumberUnLocalized(LocaleContextHolder.getLocale(), value);
	}

	public static String convertStringAsStringNumberUnLocalized(Locale loc, String value) throws ParseException {
		double d = NumberUtils.getDoubleValue(loc, value);
		return NumberFormat.getInstance(new Locale("us")).format(d);
	}

	
}