package com.github.rybalkinan.event.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "organizer")
public class Organizer extends BaseEntity{

    @NotBlank(message = "organizerName cannot be empty")
    @Column(columnDefinition = "organizer_name")
    private String organizerName;

    @NotEmpty(message = "loginName cannot be empty")
    @Column(columnDefinition = "login_name")
    private String loginName;

    @NotEmpty(message = "password cannot be empty")
    private String password;

}
