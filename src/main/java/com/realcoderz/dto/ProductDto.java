package com.realcoderz.dto;



import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.realcoderz.utils.JsonInternationalized;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductDto {

    @Getter(AccessLevel.PUBLIC)
    private Long id;
    @JsonInternationalized
    @NotNull
    private String name;
    
    @NotNull
    private String price;

    private String createAt;
    
    private String measurement;
    
    @JsonIgnore
    private Integer port;

}