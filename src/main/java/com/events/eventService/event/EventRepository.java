package com.events.eventService.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer>{
    Event findEventById(int id);

    Event deleteEventById(int id);
}
