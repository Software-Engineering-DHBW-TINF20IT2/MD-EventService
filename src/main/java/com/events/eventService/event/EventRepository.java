package com.events.eventService.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer>{
    Event findEventById(int id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Event e WHERE e.id = ?1")
    void deleteEvent(int id);
}
