package com.example.event_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.event_management.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

		Optional<Event> findByEventId(String eventId);
}

