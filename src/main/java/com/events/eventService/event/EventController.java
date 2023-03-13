package com.events.eventService.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "eventController")
@Slf4j
@CrossOrigin()
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    /**
     * Schnittstelle zum Abfragen von allen Events aus der Datenbank
     *
     * @return List<Event> mit allen Events die in der Datenbank vorhanden sind
     */
    @GetMapping
    public List<Event> getEvents(){
        return eventService.getEvents();
    }

    /**
     * Schnittstelle zum Abfragen von einem bestimmten Event über seine ID
     *
     * @param id mit der ID des Events was zurückgegeben werden soll
     *
     * @return mit dem Eventobjekt
     */
    @GetMapping(path = "/id/{id}")
    public Event getEvent(@PathVariable int id){
        return eventService.getEvent(id);
    }

    /**
     * Schnittstelle zum Abfragen von aller Events eines Users
     *
     * @param createrID mit der userID des Nutzers, der das Event angelegt hat
     *
     * @return List<Event> mit allen Events die von diesem User angelegt wurden
     */
    @GetMapping(path = "/creator/{createrID}")
    public List<Event> getEventByCreator(@PathVariable String createrID){
        return eventService.getEventByCreator(createrID);
    }

    /**
     * Schnittstelle zum Abfragen von allen möglichen Eventtypen
     *
     * @return List<String> mit allen Auswahlmöglichkeiten des Enums
     */
    @GetMapping(path = "/type")
    public List<String> getEventtyps(){
        return eventService.getEventtyps();
    }

    /**
     * Schnittstelle zum Abfragen von allen Events eines Eventtyps
     *
     * @param eventtyp mit dem gesuchten Eventtyp
     *
     * @return List<Event> mit allen Events des gewünschten Typs
     */
    @GetMapping(path = "/type/{eventtyp}")
    public List<Event> getEventByTyp(@PathVariable Eventtyp eventtyp){
        return eventService.getEventByTyp(eventtyp);
    }

    /**
     * Schnittstelle zum Hinzufügen eines neuen Events
     *
     * @param event mit dem hinzuzufügenden Event
     *
     * @return Event mit dem hinzugefügten Event, welches die generierte Event-ID beinhaltet
     */
    @PostMapping
    public Event postEvent(@RequestBody Event event){
        return eventService.postEvent(event);
    }

    /**
     * Schnittstelle zum Aktualiseren der Daten eines Events
     *
     * @param event mit dem aktualisierten Event. Die EventId dieses Events wird verwendet, um das existente Event
     *              zu finden und entsprechend zu aktualisieren
     *
     * @return Event mit den aktualisierten Daten
     */
    @PutMapping
    public Event updateEvent(@RequestBody Event event){
        return eventService.updateEvent(event);
    }

    /**
     * Schnittstelle zum Löschen eines Events
     *
     * @param id mit der ID des zu löschenden Events
     */
    @DeleteMapping(path = "{id}")
    public void deleteEvent(@PathVariable int id){
        eventService.deleteEvent(id);
    }
}
