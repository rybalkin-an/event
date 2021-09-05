package com.github.rybalkinan.event.repositories;

import com.github.rybalkinan.event.models.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Integer> {
}
