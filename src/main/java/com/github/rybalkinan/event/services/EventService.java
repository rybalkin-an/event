package com.github.rybalkinan.event.services;

import com.github.rybalkinan.event.models.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    Optional<Event> getById(Integer id);
    void save(Event event);
    void delete(Event event);
    List<Event> getAll();
}
