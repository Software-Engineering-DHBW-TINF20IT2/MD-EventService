package com.events.eventService.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // Funktion zum Abfragen von allen Events aus der Datenbank
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    // Funktion zum Abfragen von bestimmten Events über deren ID
    public Event getEvent(int id) {
        return eventRepository.findEventById(id);
    }

    // Funktion zum Abfragen von allen Events eines Nutzers
    public List<Event> getEventByCreator(String creator){
        return eventRepository.findEventsByCreator(creator);
    }

    // Funktion zum Abfragen von allen möglichen Eventtypen
    public List<String> getEventtyps() {
        return Arrays.stream(Eventtyp.values()).map(Enum::name).collect(Collectors.toList());
    }

    // Funktion zum Abfragen von allen Events eines bestimmten Eventtyps
    public List<Event> getEventByTyp(Eventtyp eventtyp){
        return eventRepository.findEventsByEventtypEnumEquals(eventtyp);
    }

    /* Funktion zum Hinzufügen eines Events in die DB.
    Überprüft, ob das Event bereits in der DB ist. Wenn das Event noch nicht vorhanden ist, wird es hinzugefügt.
     */
    public Event postEvent(Event event) {
        Event dbEvent = eventRepository.findEventById(event.getId());
        if(dbEvent == null){
            return eventRepository.save(event);
        }
        else{
            return dbEvent;
        }
    }

    /* Funktion zum Aktualisieren eines Events in der DB.
    Dafür wird erst das Objekt aus der Datenbank abgefragt, sämtliche Daten auf die neuen Daten aktualisiert und
    dann das Objekt wieder in die Datenbank gespeichert.
     */
    public Event updateEvent(Event event) {
        Event existing = eventRepository.findEventById(event.getId());
        existing.setName(event.getName());
        existing.setDiscription(event.getDiscription());
        existing.setLongitude(event.getLongitude());
        existing.setLatitude(event.getLatitude());
        existing.setCreatorName(event.getCreatorName());
        existing.setCreatorId(event.getCreatorId());
        existing.setTimestamp(event.getTimestamp());
        existing.setUntil(event.getUntil());
        existing.setEventtypEnum(event.getEventtypEnum());
        eventRepository.save(existing);
        return existing;
    }

    // Funktion zum Löschen eines Events aus der DB.
    public void deleteEvent(int id) {
        eventRepository.deleteEvent(id);
    }
}
