package com.github.rybalkinan.event.controllers;

import com.github.rybalkinan.event.models.Organizer;
import com.github.rybalkinan.event.services.OrganizerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/organizer/")
public class OrganizerController {

    @Autowired
    OrganizerService organizerService;

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> getOrganizer(@PathVariable Integer id) {
        if (id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Organizer> organizer = this.organizerService.getOrganizerById(id);
        if (!organizer.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(organizer, HttpStatus.OK);
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Organizer>> getAllOrganizers(){
        List<Organizer> organizers = this.organizerService.getOrganizers();
        if (organizers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(organizers, HttpStatus.OK);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Organizer> saveOrganizer(@RequestBody @Validated Organizer organizer) {
        HttpHeaders headers = new HttpHeaders();
        if (organizer == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.organizerService.saveOrganizer(organizer);
        return new ResponseEntity<>(organizer, headers, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Organizer> deleteOrganizer(@PathVariable Integer id) {
        if (id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Organizer> organizer = this.organizerService.getOrganizerById(id);
        if (!organizer.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.organizerService.deleteOrganizer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
