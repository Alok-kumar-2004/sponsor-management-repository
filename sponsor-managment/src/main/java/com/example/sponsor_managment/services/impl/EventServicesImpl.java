package com.example.sponsor_managment.services.impl;

import com.example.sponsor_managment.entity.EventEntity;
import com.example.sponsor_managment.exception.ResourceNotFoundException;
import com.example.sponsor_managment.repository.EventRepository;
import com.example.sponsor_managment.services.EventServices;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EventServicesImpl implements EventServices {
    @Autowired
    private EventRepository eventRepository;
    @Override
    public List<EventEntity> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public EventEntity getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));
    }

    private static final Logger logger= LoggerFactory.getLogger(SponsorServicesImpl.class);
    @Override
    public EventEntity createEvent(EventEntity event) {

    return eventRepository.save(event);
    }

    @Override
    public EventEntity updateEvent(Long id, EventEntity event) {
        EventEntity existingEvent = getEventById(id);
        existingEvent.setEventName(event.getEventName());
        existingEvent.setDate(event.getDate());
        existingEvent.setLocation(event.getLocation());
        existingEvent.setDescription(event.getDescription());
        return eventRepository.save(existingEvent);
    }

    @Override
    public void deleteEvent(Long id) {
        EventEntity event = getEventById(id);
        eventRepository.delete(event);
    }
}
