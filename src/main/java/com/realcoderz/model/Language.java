package com.realcoderz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "languages")
public class Language implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "language")
    private String language;

    @Column(name = "parent")
    private String parent;

    @Column(name = "description")
    private String description;

    @Column(name = "is_default")
    private Boolean isDefault;
}
