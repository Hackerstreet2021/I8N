package com.realcoderz.utils.dto;

import org.modelmapper.ModelMapper;

public class ModelMapperWrapper {
	
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public static ModelMapper getModelMapper() {
	return MODEL_MAPPER;
    }

}
