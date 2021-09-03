package com.github.rybalkinan.event.services;

import com.github.rybalkinan.event.models.Organizer;

import java.util.List;
import java.util.Optional;

public interface OrganizerService {
    Optional<Organizer> getOrganizerById(Integer id);
    void saveOrganizer(Organizer organizer);
    void deleteOrganizer(Integer id);
    List<Organizer> getOrganizers();
}
