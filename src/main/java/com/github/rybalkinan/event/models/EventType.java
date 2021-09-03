package com.github.rybalkinan.event.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "public.event_type")
public class EventType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "event_type_id")
    private int eventTypeId;

    public String eventTypeDescription;

}
