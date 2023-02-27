package com.events.eventService.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer>{
    Event findEventById(int id);

    @Query("SELECT e FROM Event e WHERE e.creatorId = ?1")
    List<Event> findEventsByCreator(String creator);

    //@Query("SELECT e FROM Event e WHERE e.eventtypEnum = ?1")
    //List<Event> findEventsByEventtyp(Eventtyp eventtyp);
    List<Event> findEventsByEventtypEnumEquals(Eventtyp eventtyp);

    @Transactional
    @Modifying
    @Query("DELETE FROM Event e WHERE e.id = ?1")
    void deleteEvent(int id);
}
