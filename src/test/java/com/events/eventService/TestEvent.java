package com.events.eventService;

import com.events.eventService.EventServiceApplication;
import com.events.eventService.event.Event;
import com.events.eventService.event.EventController;
import com.events.eventService.event.Eventtyp;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class TestEvent {
    private final EventController eventController;

    Event testEvent = new Event(-1, "Test", "zum Testen des Controllers",
            (float)8.534927099121942, (float)49.473342449968946, "Tester",
            "Tester@gmail.com", LocalDateTime.parse("2023-03-01T10:09:26.997"),
            LocalDateTime.parse("2023-03-01T13:09:26.997"), Eventtyp.Essen);


    @Autowired
    public TestEvent(EventController eventController) {
        this.eventController = eventController;
    }

    @BeforeEach
    void addTestData(){
        eventController.postEvent(testEvent);
    }

    @AfterEach
    void deleteTestData(){
        eventController.deleteEvent(-1);
    }

    @Test
    void testGet(){
        List<Event> events = eventController.getEvents();
        assertTrue(events.contains(testEvent));
    }

    @Test
    void testGetById(){
        Event event = eventController.getEvent(-1);
        assertEquals(event, testEvent);
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
        Event testEvent2 = new Event(-2, "Tester", "zum Testen der Updatefunktionalität",
                (float)9.534927099121942, (float)48.473342449968946, "Test",
                "Test@gmail.com", LocalDateTime.parse("2023-03-01T10:00:26.997"),
                LocalDateTime.parse("2023-03-01T13:00:26.997"), Eventtyp.Kino);
        eventController.postEvent(testEvent2);
        assertTrue(eventController.getEvents().contains(testEvent2));
        eventController.deleteEvent(-2);
    }

    @Test
    void testUpdate(){
        Event update = new Event(-1, "Tester", "zum Testen der Updatefunktionalität",
                (float)9.534927099121942, (float)48.473342449968946, "Test",
                "Test@gmail.com", LocalDateTime.parse("2023-03-01T10:00:26.997"),
                LocalDateTime.parse("2023-03-01T13:00:26.997"), Eventtyp.Kino);
        eventController.updateEvent(update);
        List<Event> events = eventController.getEvents();
        assertFalse(events.contains(testEvent));
        assertTrue(events.contains(update));
    }

    @Test
    void testDelete(){
        eventController.deleteEvent(-1);
        List<Event> events = eventController.getEvents();
        assertFalse(events.contains(testEvent));
    }

}
