package com.github.rybalkinan.event.services;

import com.github.rybalkinan.event.models.Organizer;
import com.github.rybalkinan.event.repositories.OrganizerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService{

    private final OrganizerRepository organizerRepository;

    public Organizer getOrganizer(Integer id) {
        return organizerRepository.findById(id).get();
    }
}
