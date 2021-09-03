package com.github.rybalkinan.event.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "public.event")
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    private int organizer;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "event_id")
    private int eventId;
    private String eventName;
    private String eventDate;
    private String eventDateRange;
    private String eventAddress;
    private int eventType;
    private String eventImage;

}
