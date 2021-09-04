package com.github.rybalkinan.event.models;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Entity
@Table(name = "event")
public class Event extends BaseEntity{

    @NotNull(message = "Organizer is required")
    private Integer organizer;

    @NotEmpty(message = "eventName cannot be empty")
    @Column(columnDefinition = "event_name")
    private String eventName;

    @Nullable
    @Column(columnDefinition = "event_date")
    private Date eventDate;

    @Nullable
    @Column(columnDefinition = "event_date_range")
    private Date eventDateRange;

    @NotEmpty(message = "Event address cannot be empty")
    @Column(columnDefinition = "event_address")
    private String eventAddress;

    @NotNull(message = "eventType is required")
    @Column(columnDefinition = "event_type")
    private Integer eventType;

    @Nullable
    @Column(columnDefinition = "event_image")
    private byte[] eventImage;

}
