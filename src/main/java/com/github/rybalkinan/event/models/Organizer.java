package com.github.rybalkinan.event.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "public.organizer")
@NoArgsConstructor
@AllArgsConstructor
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "organizer_id")
    private int organizerId;

    @Column(columnDefinition = "organizer_name")
    private String organizerName;

    @Column(columnDefinition = "login_name")
    private String loginName;

    private String password;

}
