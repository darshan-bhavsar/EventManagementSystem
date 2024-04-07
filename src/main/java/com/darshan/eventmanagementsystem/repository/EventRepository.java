package com.darshan.eventmanagementsystem.repository;

import com.darshan.eventmanagementsystem.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, String> {
    List<Event> findAll();
}
