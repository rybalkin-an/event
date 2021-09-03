package com.github.rybalkinan.event.repositories;

import com.github.rybalkinan.event.models.Organizer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizerRepository extends CrudRepository<Organizer, Integer> {

    @Override
    default Optional<Organizer> findById(Integer integer) {
        return Optional.empty();
    }
}
