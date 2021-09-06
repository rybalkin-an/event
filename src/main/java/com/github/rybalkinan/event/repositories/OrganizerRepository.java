package com.github.rybalkinan.event.repositories;

import com.github.rybalkinan.event.models.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {
}
