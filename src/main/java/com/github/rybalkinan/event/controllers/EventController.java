package com.github.rybalkinan.event.controllers;

import com.github.rybalkinan.event.exceptions.ResourceNotFoundException;
import com.github.rybalkinan.event.models.Event;
import com.github.rybalkinan.event.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    @Autowired
    EventService eventService;

    private Event event;

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public HttpEntity<?> getEvent(@PathVariable Integer id) {
        if (id == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        event = this.eventService.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event with id '" + id + "' not found"));
        return new ResponseEntity<>(event, OK);
    }

    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> getAllEvents(){
        List<Event> events = this.eventService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(events, OK);
    }

    @PostMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> saveEvent(@Valid @RequestBody Event event) {
        HttpHeaders headers = new HttpHeaders();
        if (event == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        this.eventService.save(event);
        return new ResponseEntity<>(event, headers, CREATED);
    }

    @PutMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> updateEvent(@Valid @RequestBody Event event) {
        HttpHeaders headers = new HttpHeaders();
        if (event == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        this.eventService.save(event);
        return new ResponseEntity<>(event, headers, OK);
    }

    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> deleteEvent(@PathVariable Integer id) {
        if (id == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        event = this.eventService.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event with id '" + id + "' not found"));
        this.eventService.delete(event);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
