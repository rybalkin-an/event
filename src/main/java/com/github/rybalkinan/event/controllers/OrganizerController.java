package com.github.rybalkinan.event.controllers;

import com.github.rybalkinan.event.models.Organizer;
import com.github.rybalkinan.event.services.OrganizerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrganizerController {

    public final OrganizerService organizerService;

    @GetMapping("/organizer/{id}")
    public Organizer getOrganizer(@PathVariable Integer id) {
        return organizerService.getOrganizer(id);
    }
}
