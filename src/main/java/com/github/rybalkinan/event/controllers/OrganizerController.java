package com.github.rybalkinan.event.controllers;

import com.github.rybalkinan.event.exceptions.ResourceNotFoundException;
import com.github.rybalkinan.event.models.Organizer;
import com.github.rybalkinan.event.services.OrganizerService;
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
@RequestMapping("/api/v1/organizer")
public class OrganizerController {

    @Autowired
    OrganizerService organizerService;

    @Operation(summary = "Get organizer of an event by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Organizer of an event has been found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Organizer.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid organizer id",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Organizer of event is not found",
                    content = @Content) })
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public HttpEntity<?> getOrganizer(@PathVariable Integer id) {
        if (id == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        Organizer organizer = this.organizerService.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organizer with id '" + id + "' not found"));
        return new ResponseEntity<>(organizer, OK);
    }

    @Operation(summary = "Get list of all organizers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All organizers of an event has been found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Organizer.class)) }),
            @ApiResponse(responseCode = "404", description = "Organizers of event are not found",
                    content = @Content) })
    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Organizer>> getAllOrganizers(){
        List<Organizer> organizers = this.organizerService.getAll();
        if (organizers.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(organizers, OK);
    }

    @Operation(summary = "Create organizer of an event")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The organizer of an event has been created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Organizer.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Organizer model",
                    content = @Content)})
    @PostMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Organizer> saveOrganizer(@RequestBody @Valid Organizer organizer) {
        HttpHeaders headers = new HttpHeaders();
        if (organizer == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        this.organizerService.save(organizer);
        return new ResponseEntity<>(organizer, headers, CREATED);
    }

    @Operation(summary = "Update organizer of an event")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated organizer of an event",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Organizer.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Organizer model",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Organizer of event is not found",
                    content = @Content) })
    @PutMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Organizer> updateOrganizer(@RequestBody @Valid Organizer organizer) {
        HttpHeaders headers = new HttpHeaders();
        if (organizer == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        Integer id = organizer.getId();
        this.organizerService.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organizer with id '" + id + "' not found"));
        this.organizerService.save(organizer);
        return new ResponseEntity<>(organizer, headers, OK);
    }

    @Operation(summary = "Delete organizer of an event")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Deleted organizer of an event",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Organizer.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Organizer id",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Organizer of event is not found",
                    content = @Content) })
    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Organizer> deleteOrganizer(@PathVariable Integer id) {
        if (id == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        Organizer organizer = this.organizerService.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organizer with id '" + id + "' not found"));
        this.organizerService.delete(organizer);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
