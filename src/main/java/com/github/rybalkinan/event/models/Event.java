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
@Table(name = "event")
@NoArgsConstructor
@AllArgsConstructor
public class Event extends BaseEntity{

    private int organizer;

    @Column(columnDefinition = "event_name")
    private String eventName;

    @Column(columnDefinition = "event_date")
    private String eventDate;

    @Column(columnDefinition = "event_date_range")
    private String eventDateRange;

    @Column(columnDefinition = "event_address")
    private String eventAddress;

    @Column(columnDefinition = "event_type")
    private int eventType;

    @Column(columnDefinition = "event_image")
    private String eventImage;

}
