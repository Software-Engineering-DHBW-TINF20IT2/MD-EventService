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

    public List<Event> getEventByCreator(String creator){
        return eventRepository.findEventsByCreator(creator);
    }

    public List<Event> getEvent(Eventtyp eventtyp){
        //return eventRepository.findEventsByEventtyp(eventtyp);
        return eventRepository.findEventsByEventtypEnumEquals(eventtyp);
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

    public void deleteEvent(int id) {
        eventRepository.deleteEvent(id);
    }
}
