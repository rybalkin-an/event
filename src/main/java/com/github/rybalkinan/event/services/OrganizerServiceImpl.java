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
    public Optional<Organizer> getById(Integer organizerId) {
        return organizerRepository.findById(organizerId);
    }

    @Override
    public void save(Organizer organizer) {
        organizerRepository.save(organizer);
    }

    @Override
    public void delete(Integer id) {
        organizerRepository.deleteById(id);
    }

    @Override
    public List<Organizer> getAll() {
        return organizerRepository.findAll();
    }
}
