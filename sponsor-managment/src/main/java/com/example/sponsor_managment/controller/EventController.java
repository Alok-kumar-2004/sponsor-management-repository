package com.example.sponsor_managment.controller;
import com.example.sponsor_managment.entity.EventEntity;
import com.example.sponsor_managment.services.EventServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@Tag(name = "Event Entity",description = "Create,Read,Update,Delete The Event ")
public class EventController {
    @Autowired
    private EventServices eventServices;
    @GetMapping
    public List<EventEntity>getAllEvents(){
        return eventServices.getAllEvents();
    }
    @GetMapping("/{id}")
    public ResponseEntity<EventEntity> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(eventServices.getEventById(id));
    }
    @PostMapping
    public ResponseEntity<EventEntity> createEvent(@RequestBody EventEntity event) {
        return ResponseEntity.ok(eventServices.createEvent(event));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EventEntity> updateEvent(@PathVariable Long id, @RequestBody EventEntity event) {
        return ResponseEntity.ok(eventServices.updateEvent(id, event));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventServices.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

}
