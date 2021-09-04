package com.github.rybalkinan.event.services;

import com.github.rybalkinan.event.models.Event;
import com.github.rybalkinan.event.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{

    @Autowired
    EventRepository eventRepository;

    @Override
    public Optional<Event> getById(Integer id) {
        return eventRepository.findById(id);
    }

    @Override
    public void save(Event event) {
        eventRepository.save(event);
    }

    @Override
    public void delete(Event event) {
        eventRepository.delete(event);
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }
}
