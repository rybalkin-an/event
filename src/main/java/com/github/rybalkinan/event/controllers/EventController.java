package com.github.rybalkinan.event.controllers;

import com.github.rybalkinan.event.models.Event;
import com.github.rybalkinan.event.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/event/")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping(value = "{id}", produces = APPLICATION_JSON_VALUE)
    public HttpEntity<?> getEvent(@PathVariable Integer id) {
        if (id == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        Optional<Event> event = this.eventService.getById(id);
        if (!event.isPresent()){
            return new ResponseEntity<>(NOT_FOUND);
        }
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

    @DeleteMapping(value = "{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> deleteEvent(@PathVariable Integer id) {
        if (id == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        Optional<Event> event = this.eventService.getById(id);
        if (!event.isPresent()){
            return new ResponseEntity<>(NOT_FOUND);
        }
        this.eventService.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
