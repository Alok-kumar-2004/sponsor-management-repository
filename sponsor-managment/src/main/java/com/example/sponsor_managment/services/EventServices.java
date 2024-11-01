package com.example.sponsor_managment.services;

import com.example.sponsor_managment.entity.EventEntity;

import java.util.List;

public interface EventServices {

    List<EventEntity> getAllEvents();

    EventEntity getEventById(Long id);

    EventEntity createEvent(EventEntity event);

    EventEntity updateEvent(Long id, EventEntity event);

    void deleteEvent(Long id);
}
