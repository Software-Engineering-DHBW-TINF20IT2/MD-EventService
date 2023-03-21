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

    /**
     * Funktion zum Abfragen von allen Events aus der Datenbank
     *
     * @return List of Event mit allen Events die in der Datenbank vorhanden sind
     */
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    /**
     * Funktion zum Abfragen von bestimmten Events über deren ID
     *
     * @param id mit der ID des Events was zurückgegeben werden soll
     *
     * @return mit dem Eventobjekt
     */
    public Event getEvent(int id) {
        return eventRepository.findEventById(id);
    }

    /**
     * Funktion zum Abfragen von allen Events eines Nutzers
     *
     * @param creator mit der userID des Nutzers, der das Event angelegt hat
     *
     * @return List of Event mit allen Events die von diesem User angelegt wurden
     */
    public List<Event> getEventByCreator(String creator){
        return eventRepository.findEventsByCreator(creator);
    }

    /**
     * Funktion zum Abfragen von allen möglichen Eventtypen
     *
     * @return List of String mit allen Auswahlmöglichkeiten des Enums
     */
    public List<String> getEventtyps() {
        return Arrays.stream(Eventtyp.values()).map(Enum::name).collect(Collectors.toList());
    }

    /**
     * Funktion zum Abfragen von allen Events eines bestimmten Eventtyps
     *
     * @param eventtyp mit dem gesuchten Eventtyp
     *
     * @return List of Event mit allen Events des gewünschten Typs
     */
    public List<Event> getEventByTyp(Eventtyp eventtyp){
        return eventRepository.findEventsByEventtypEnumEquals(eventtyp);
    }

    /**
     * Funktion zum Hinzufügen eines Events in die DB.
     * Überprüft, ob das Event bereits in der DB ist. Wenn das Event noch nicht vorhanden ist, wird es hinzugefügt.
     *
     * @param event mit dem hinzuzufügenden Event
     *
     * @return Event mit dem hinzugefügten Event, welches die generierte Event-ID beinhaltet
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

    /**
     * Funktion zum Aktualisieren eines Events in der DB.
     * Dafür wird erst das Objekt aus der Datenbank abgefragt, sämtliche Daten auf die neuen Daten aktualisiert und
     * dann das Objekt wieder in die Datenbank gespeichert.
     *
     * @param event mit dem aktualisierten Event. Die EventId dieses Events wird verwendet, um das existente Event
     *              zu finden und entsprechend zu aktualisieren
     *
     * @return Event mit den aktualisierten Daten
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

    /**
     * Funktion zum Löschen eines Events
     *
     * @param id mit der ID des zu löschenden Events
     */
    public void deleteEvent(int id) {
        eventRepository.deleteEvent(id);
    }
}
