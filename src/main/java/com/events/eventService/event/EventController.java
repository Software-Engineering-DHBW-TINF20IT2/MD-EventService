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

    @GetMapping
    public List<Event> getEvents(){
        return eventService.getEvents();
    }

    @GetMapping(path = "/id/{id}")
    public Event getEvent(@PathVariable int id){
        return eventService.getEvent(id);
    }

    @GetMapping(path = "/creator/{createrID}")
    public List<Event> getEventByCreator(@PathVariable String createrID){
        return eventService.getEventByCreator(createrID);
    }

    @GetMapping(path = "/type")
    public List<String> getEventtyps(){
        return eventService.getEventtyps();
    }

    @GetMapping(path = "/type/{eventtyp}")
    public List<Event> getEventByTyp(@PathVariable Eventtyp eventtyp){
        return eventService.getEventByTyp(eventtyp);
    }

    @PostMapping
    public Event postEvent(@RequestBody Event event){
        return eventService.postEvent(event);
    }

    @PutMapping
    public Event updateEvent(@RequestBody Event event){
        return eventService.updateEvent(event);
    }

    @DeleteMapping(path = "{id}")
    public void deleteEvent(@PathVariable int id){
        eventService.deleteEvent(id);
    }
}
