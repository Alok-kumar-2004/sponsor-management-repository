package com.example.sponsor_managment.repository;

import com.example.sponsor_managment.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity,Long> {
}
