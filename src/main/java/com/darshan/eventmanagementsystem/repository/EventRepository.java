package com.darshan.eventmanagementsystem.repository;

import com.darshan.eventmanagementsystem.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {
}
