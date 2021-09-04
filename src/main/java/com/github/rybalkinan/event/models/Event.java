package com.github.rybalkinan.event.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "event")
public class Event extends BaseEntity{

    @NonNull
    private int organizer;

    @NonNull
    @Column(columnDefinition = "event_name")
    private String eventName;

    @Nullable
    @Column(columnDefinition = "event_date")
    private Date eventDate;

    @Nullable
    @Column(columnDefinition = "event_date_range")
    private Date eventDateRange;

    @NonNull
    @Column(columnDefinition = "event_address")
    private String eventAddress;

    @NonNull
    @Column(columnDefinition = "event_type")
    private int eventType;

    @Nullable
    @Column(columnDefinition = "event_image")
    private byte[] eventImage;

}
