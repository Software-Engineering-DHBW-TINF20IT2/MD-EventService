package com.events.eventService.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public Event getEvent(int id) {
        return eventRepository.findEventById(id);
    }

    public Event postEvent(Event event) {
        Event dbEvent = eventRepository.findEventById(event.getId());
        if(dbEvent == null){
            return eventRepository.save(event);
        }
        else{
            return dbEvent;
        }
    }

    public Event updateEvent(Event event) {
        Event existing = eventRepository.findEventById(event.getId());
        existing.setName(event.getName());
        existing.setDiscription(event.getDiscription());
        existing.setLocation(event.getLocation());
        existing.setCreatorId(event.getCreatorId());
        existing.setTimestamp(event.getTimestamp());
        existing.setUntil(event.getUntil());
        eventRepository.save(existing);
        return existing;
    }

    public Event deleteEvent(int id) {
        return eventRepository.deleteEventById(id);
    }
}
