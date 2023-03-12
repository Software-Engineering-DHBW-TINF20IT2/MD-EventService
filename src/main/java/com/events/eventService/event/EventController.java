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

    // Schnittstelle zum Abfragen von allen Events aus der Datenbank
    @GetMapping
    public List<Event> getEvents(){
        return eventService.getEvents();
    }

    // Schnittstelle zum Abfragen von einem bestimmten Event über seine ID
    @GetMapping(path = "/id/{id}")
    public Event getEvent(@PathVariable int id){
        return eventService.getEvent(id);
    }

    // Schnittstelle zum Abfragen von aller Events eines Users
    @GetMapping(path = "/creator/{createrID}")
    public List<Event> getEventByCreator(@PathVariable String createrID){
        return eventService.getEventByCreator(createrID);
    }

    // Schnittstelle zum Abfragen von allen möglichen Eventtypen
    @GetMapping(path = "/type")
    public List<String> getEventtyps(){
        return eventService.getEventtyps();
    }

    // Schnittstelle zum Abfragen von allen Events eines Eventtyps
    @GetMapping(path = "/type/{eventtyp}")
    public List<Event> getEventByTyp(@PathVariable Eventtyp eventtyp){
        return eventService.getEventByTyp(eventtyp);
    }

    // Schnittstelle zum Hinzufügen eines neuen Events
    @PostMapping
    public Event postEvent(@RequestBody Event event){
        return eventService.postEvent(event);
    }

    // Schnittstelle zum Aktualiseren der Daten eines Events
    @PutMapping
    public Event updateEvent(@RequestBody Event event){
        return eventService.updateEvent(event);
    }

    // Schnittstelle zum Löschen eines Events
    @DeleteMapping(path = "{id}")
    public void deleteEvent(@PathVariable int id){
        eventService.deleteEvent(id);
    }
}
