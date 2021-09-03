package com.github.rybalkinan.event.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "organizer")
@NoArgsConstructor
@AllArgsConstructor
public class Organizer extends BaseEntity{

    @Column(columnDefinition = "organizer_name")
    private String organizerName;

    @Column(columnDefinition = "login_name")
    private String loginName;

    private String password;

}
