package com.github.rybalkinan.event.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "event_type")
public class EventType extends BaseEntity{

    @Column(columnDefinition = "event_type_description")
    public String eventTypeDescription;

}
