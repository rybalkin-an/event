package com.github.rybalkinan.event.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "event")
public class Event extends BaseEntity{

    @NotNull(message = "Organizer is required")
    private int organizer;

    @NotNull(message = "Event name is required")
    @NotBlank(message = "Event name is required")
    @Column(columnDefinition = "event_name")
    private String eventName;

    @Nullable
    @Column(columnDefinition = "event_date")
    private Date eventDate;

    @Nullable
    @Column(columnDefinition = "event_date_range")
    private Date eventDateRange;

    @NotBlank(message = "Event address is required")
    @Column(columnDefinition = "event_address")
    private String eventAddress;

    @NotNull(message = "Event type is required")
    @Column(columnDefinition = "event_type")
    private int eventType;

    @Nullable
    @Column(columnDefinition = "event_image")
    private byte[] eventImage;

}
