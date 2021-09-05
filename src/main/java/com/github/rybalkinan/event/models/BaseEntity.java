package com.github.rybalkinan.event.models;

import lombok.Data;

import javax.persistence.*;


@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "jpaSequence")
    @SequenceGenerator(name = "jpaSequence", sequenceName = "JPA_SEQUENCE", allocationSize = 1, initialValue = 1)
    private Integer id;
}
