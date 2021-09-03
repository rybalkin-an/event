package com.github.rybalkinan.event.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String eventName;
    private String eventDate;
    private String eventDateRange;
    private String eventAddress;
    private int eventType;
    private String eventImage;

}
