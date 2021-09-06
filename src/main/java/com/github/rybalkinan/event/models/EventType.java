package com.github.rybalkinan.event.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "event_type")
public class EventType extends BaseEntity{

    @NotEmpty(message = "eventTypeDescription cannot be empty")
    @Column(columnDefinition = "event_type_description")
    public String eventTypeDescription;

}
