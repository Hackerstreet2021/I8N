package com.realcoderz.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.realcoderz.utils.NumberFormatDeserializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = -6555690960724844505L;
     
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonDeserialize(using = NumberFormatDeserializer.class)
    @JsonFormat(shape = Shape.STRING)
    @Column(name = "price")
    private Double price;

    @JsonFormat(shape = Shape.STRING,pattern="yyyy-MM-dd'T'HH:mm:ss:SSSSSS")
    @Column(name = "create_at",columnDefinition = "TIMESTAMP")
    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createAt;

    @JsonDeserialize(using = NumberFormatDeserializer.class)
    @JsonFormat(shape = Shape.STRING)
    @Column(name="measurement")
    private Double measurement;
    
    
    @OneToMany(fetch = FetchType.EAGER)    
    @JoinColumn(name = "reference", referencedColumnName = "name")
    private Set<Resource> resources = new HashSet<>(0);

    @PrePersist
    private void onCreate() {
    	createAt=LocalDateTime.now();
    }
    
      

}