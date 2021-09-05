package com.github.rybalkinan.event.controllers;

import com.github.rybalkinan.event.exceptions.ResourceNotFoundException;
import com.github.rybalkinan.event.models.Event;
import com.github.rybalkinan.event.models.Organizer;
import com.github.rybalkinan.event.services.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Get event by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Event found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Event.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid event id",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Event not found",
                    content = @Content) })
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public HttpEntity<?> getEvent(@PathVariable Integer id) {
        if (id == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        event = this.eventService.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event with id '" + id + "' not found"));
        return new ResponseEntity<>(event, OK);
    }

    @Operation(summary = "Get list of all events")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All events has been found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Event.class)) }),
            @ApiResponse(responseCode = "404", description = "Events are not found",
                    content = @Content) })
    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> getAllEvents(){
        List<Event> events = this.eventService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(events, OK);
    }

    @Operation(summary = "Create new event")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Event has been created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Event.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid event model",
                    content = @Content)})
    @PostMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> saveEvent(@Valid @RequestBody Event event) {
        HttpHeaders headers = new HttpHeaders();
        if (event == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        this.eventService.save(event);
        return new ResponseEntity<>(event, headers, CREATED);
    }

    @Operation(summary = "Update event")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Event updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Event.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid event model",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Event not found",
                    content = @Content) })
    @PutMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> updateEvent(@Valid @RequestBody Event event) {
        HttpHeaders headers = new HttpHeaders();
        if (event == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        this.eventService.save(event);
        return new ResponseEntity<>(event, headers, OK);
    }

    @Operation(summary = "Delete event")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Event deleted",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Event.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid event id",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Event not found",
                    content = @Content) })
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
