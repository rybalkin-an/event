package com.github.rybalkinan.event.services;

import com.github.rybalkinan.event.models.EventType;
import com.github.rybalkinan.event.repositories.EventTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventTypeServiceImpl implements EventTypeService{

    @Autowired
    EventTypeRepository eventTypeRepository;

    @Override
    public Optional<EventType> getById(Integer id) {
        return eventTypeRepository.findById(id);
    }

    @Override
    public void save(EventType eventType) {
        eventTypeRepository.save(eventType);
    }

    @Override
    public void delete(EventType eventType) {
        eventTypeRepository.delete(eventType);
    }

    @Override
    public List<EventType> getAll() {
        return eventTypeRepository.findAll();
    }
}
