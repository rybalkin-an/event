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
@Table(name = "event_type")
@NoArgsConstructor
@AllArgsConstructor
public class EventType extends BaseEntity{

    public String eventTypeDescription;

}
