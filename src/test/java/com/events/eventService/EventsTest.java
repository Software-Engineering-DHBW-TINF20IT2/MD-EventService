package com.events.eventService;

import com.events.eventService.event.Event;
import com.events.eventService.event.EventController;
import com.events.eventService.event.Eventtyp;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class EventsTest {
    private final EventController eventController;

    Event testEvent = new Event(-1, "Test", "zum Testen des Controllers",
            (float)8.5349, (float)49.4733, "Tester",
            "Tester@gmail.com", LocalDateTime.parse("2023-03-01T10:09:26.997"),
            LocalDateTime.parse("2023-03-01T13:09:26.997"), Eventtyp.Essen);


    @Autowired
    public EventsTest(EventController eventController) {
        this.eventController = eventController;
    }

    @AfterEach
    void deleteTestData(){
        eventController.deleteEvent(-1);
    }

    @Test
    void testGet(){
        Event returnEvent = eventController.postEvent(testEvent);
        List<Event> events = eventController.getEvents();
        assertTrue(events.contains(returnEvent));
    }

    @Test
    void testGetById(){
        Event returnEvent = eventController.postEvent(testEvent);
        int returnId = returnEvent.getId();
        Event event = eventController.getEvent(returnId);
        assertEvent(returnEvent, event);
        eventController.deleteEvent(returnId);
    }

    @Test
    void testGetByCreator(){
        List<Event> events = eventController.getEventByCreator("Tester@gmail.com");
        assertTrue(events.contains(testEvent));
    }

    @Test
    void testGetEventtyps(){
        List<String> typssearched = eventController.getEventtyps();
        List<String> typs = new ArrayList<>();
        typs.add("Saufen");
        typs.add("Kino");
        typs.add("Essen");
        assertEquals(typssearched, typs);
    }

    @Test
    void testGetByTyp(){

        List<Event> events = eventController.getEventByTyp(Eventtyp.Essen);
        assertTrue(events.contains(testEvent));
    }

    @Test
    void testPost(){
        Event returnEvent = eventController.postEvent(testEvent);
        int returnId = returnEvent.getId();
        Event event = eventController.getEvent(returnId);
        assertEvent(returnEvent, event);
        eventController.deleteEvent(returnId);
    }

    @Test
    void testUpdate(){
        Event returnEvent1 = eventController.postEvent(testEvent);
        int returnId = returnEvent1.getId();
        Event update = new Event(returnId, "Tester", "zum Testen der Updatefunktionalität",
                (float)9.534927099121942, (float)48.473342449968946, "Test",
                "Test@gmail.com", LocalDateTime.parse("2023-03-01T10:00:26.997"),
                LocalDateTime.parse("2023-03-01T13:00:26.997"), Eventtyp.Kino);
        eventController.updateEvent(update);
        Event event = eventController.getEvent(returnId);
        assertEquals(event.getId(), returnId);
        assertNotEquals(testEvent.getDiscription(), event.getDiscription());
        eventController.deleteEvent(returnId);
    }

    @Test
    void testDelete(){
        Event returnEvent = eventController.postEvent(testEvent);
        int returnId = returnEvent.getId();
        testEvent.setId(returnId);
        // List<Event> eventsBefore = eventController.getEvents();
        // assertTrue(eventsBefore.contains(testEvent));
        eventController.deleteEvent(returnId);
        List<Event> eventsAfter = eventController.getEvents();
        assertFalse(eventsAfter.contains(testEvent));
    }

    private void assertEvent(Event add, Event get){
        assertEquals(add.getId(), get.getId());
        assertEquals(add.getName(), get.getName());
        assertEquals(add.getDiscription(), get.getDiscription());
        assertEquals(add.getLongitude(), get.getLongitude());
        assertEquals(add.getLatitude(), get.getLatitude());
        assertEquals(add.getCreatorName(), get.getCreatorName());
        assertEquals(add.getCreatorId(), get.getCreatorId());
        assertEquals(add.getTimestamp(), get.getTimestamp());
        assertEquals(add.getUntil(), get.getUntil());
        assertEquals(add.getEventtypEnum(), get.getEventtypEnum());
    }
}
