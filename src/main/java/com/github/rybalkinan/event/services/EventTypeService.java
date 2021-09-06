package com.github.rybalkinan.event.services;

import com.github.rybalkinan.event.models.EventType;

import java.util.List;
import java.util.Optional;

public interface EventTypeService {
    Optional<EventType> getById(Integer id);
    void save(EventType eventType);
    void delete(EventType eventType);
    List<EventType> getAll();
}
