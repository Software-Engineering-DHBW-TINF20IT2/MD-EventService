package com.events.eventService.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Das EventRepository ist eine Schnittstelle, die den Zugriff auf die Datenbanktabelle 'events' ermöglicht.
 * Diese Schnittstelle bietet Methoden zur Verwaltung von Event-Objekten.
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Integer>{

    /**
     * Findet ein Event-Objekt anhand seiner ID.
     * @param id Die ID des Events, das gefunden werden soll.
     * @return Das Event-Objekt mit der angegebenen ID oder null, wenn kein Event mit dieser ID gefunden wurde.
     */
    Event findEventById(int id);

    /**
     * Sucht nach Events, die von einem bestimmten Benutzer erstellt wurden.
     * @param creatorId Der Benutzername des Erstellers der Events, die gesucht werden sollen.
     * @return Eine Liste von Event-Objekten, die von dem angegebenen Benutzer erstellt wurden.
     */
    List<Event> findEventsByCreatorId(String creatorId);

    /**
     * Sucht nach Events, die einem bestimmten Eventtyp zugeordnet sind.
     * @param eventtyp Der Eventtyp, nach dem gesucht werden soll.
     * @return Eine Liste von Event-Objekten, die dem angegebenen Eventtyp zugeordnet sind.
     */
    List<Event> findEventsByEventtypEnumEquals(Eventtyp eventtyp);

    /**
     * Löscht ein Event-Objekt aus der Datenbank anhand seiner ID.
     * @param id Die ID des Events, das gelöscht werden soll.
     */
    @Transactional
    @Modifying
    @Query("DELETE FROM Event e WHERE e.id = ?1")
    void deleteEvent(int id);
}

