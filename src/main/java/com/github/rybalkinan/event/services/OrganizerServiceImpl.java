package com.github.rybalkinan.event.services;

import com.github.rybalkinan.event.models.Organizer;
import com.github.rybalkinan.event.repositories.OrganizerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService{

    @Autowired
    OrganizerRepository organizerRepository;

    @Override
    public Optional<Organizer> getOrganizerById(Integer organizerId) {
        return organizerRepository.findById(organizerId);
    }

    @Override
    public void saveOrganizer(Organizer organizer) {
        organizerRepository.save(organizer);
    }

    @Override
    public void deleteOrganizer(Integer id) {
        organizerRepository.deleteById(id);
    }

    @Override
    public List<Organizer> getOrganizers() {
        return organizerRepository.findAll();
    }
}
