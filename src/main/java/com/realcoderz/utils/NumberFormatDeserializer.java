package com.realcoderz.utils;

import java.io.IOException;
import java.text.ParseException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class NumberFormatDeserializer extends JsonDeserializer<Double>{

	@Override
	public Double deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		String doubleString = p.getText();
		double d = 0;
		try {
			d = NumberUtils.getDoubleValue(doubleString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

}
