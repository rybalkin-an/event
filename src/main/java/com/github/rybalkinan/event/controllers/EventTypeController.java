package com.github.rybalkinan.event.controllers;

import com.github.rybalkinan.event.exceptions.ResourceNotFoundException;
import com.github.rybalkinan.event.models.EventType;
import com.github.rybalkinan.event.services.EventTypeService;
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
@RequestMapping("/api/v1/eventType")
public class EventTypeController {

    @Autowired
    EventTypeService eventTypeService;

    private EventType eventType;

    @Operation(summary = "Get event type by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Event type found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EventType.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid event type id",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Event type not found",
                    content = @Content) })
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public HttpEntity<?> getEventType(@PathVariable Integer id) {
        if (id == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        eventType = this.eventTypeService.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event type with id '" + id + "' not found"));
        return new ResponseEntity<>(eventType, OK);
    }

    @Operation(summary = "Get list of all event types")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All event types has been found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EventType.class)) }),
            @ApiResponse(responseCode = "404", description = "Event types are not found",
                    content = @Content) })
    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EventType>> getAllEventTypes(){
        List<EventType> eventTypes = this.eventTypeService.getAll();
        if (eventTypes.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(eventTypes, OK);
    }

    @Operation(summary = "Create new event type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Event type has been created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EventType.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid event type model",
                    content = @Content)})
    @PostMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<EventType> saveEventType(@Valid @RequestBody EventType eventType) {
        HttpHeaders headers = new HttpHeaders();
        if (eventType == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        this.eventTypeService.save(eventType);
        return new ResponseEntity<>(eventType, headers, CREATED);
    }

    @Operation(summary = "Update event type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Event type updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EventType.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid event type model",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Event type not found",
                    content = @Content) })
    @PutMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<EventType> updateEventType(@Valid @RequestBody EventType eventType) {
        HttpHeaders headers = new HttpHeaders();
        if (eventType == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        Integer id = eventType.getId();
        this.eventTypeService.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event type with id '" + id + "' not found"));
        this.eventTypeService.save(eventType);
        return new ResponseEntity<>(eventType, headers, OK);
    }

    @Operation(summary = "Delete event type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Event type deleted",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EventType.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid event type id",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Event type not found",
                    content = @Content) })
    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<EventType> deleteEventType(@PathVariable Integer id) {
        if (id == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        eventType = this.eventTypeService.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event type with id '" + id + "' not found"));
        this.eventTypeService.delete(eventType);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
