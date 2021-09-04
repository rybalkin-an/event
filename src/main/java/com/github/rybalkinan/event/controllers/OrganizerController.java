package com.github.rybalkinan.event.controllers;

import com.github.rybalkinan.event.models.Organizer;
import com.github.rybalkinan.event.services.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/organizer/")
public class OrganizerController {

    @Autowired
    OrganizerService organizerService;

    @GetMapping(value = "{id}", produces = APPLICATION_JSON_VALUE)
    public HttpEntity<?> getOrganizer(@PathVariable Integer id) {
        if (id == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        Optional<Organizer> organizer = this.organizerService.getById(id);
        if (!organizer.isPresent()){
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(organizer, OK);
    }

    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Organizer>> getAllOrganizers(){
        List<Organizer> organizers = this.organizerService.getAll();
        if (organizers.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(organizers, OK);
    }

    @PostMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Organizer> saveOrganizer(@RequestBody @Validated Organizer organizer) {
        HttpHeaders headers = new HttpHeaders();
        if (organizer == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        this.organizerService.save(organizer);
        return new ResponseEntity<>(organizer, headers, CREATED);
    }

    @DeleteMapping(value = "{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Organizer> deleteOrganizer(@PathVariable Integer id) {
        if (id == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        Optional<Organizer> organizer = this.organizerService.getById(id);
        if (!organizer.isPresent()){
            return new ResponseEntity<>(NOT_FOUND);
        }
        this.organizerService.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
