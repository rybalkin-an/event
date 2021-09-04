package com.github.rybalkinan.event.services;

import com.github.rybalkinan.event.models.Organizer;

import java.util.List;
import java.util.Optional;

public interface OrganizerService {
    Optional<Organizer> getById(Integer id);
    void save(Organizer organizer);
    void delete(Integer id);
    List<Organizer> getAll();
}
