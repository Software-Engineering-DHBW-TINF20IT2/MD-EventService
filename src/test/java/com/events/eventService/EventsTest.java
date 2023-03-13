package com.events.eventService;

import com.events.eventService.event.Event;
import com.events.eventService.event.EventController;
import com.events.eventService.event.Eventtyp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class EventsTest {
    private final EventController eventController;

    /**
     * testEvent und testEvent2 sind zwei testEvents um nachfolgend die Tests durchzuführen
     */
    Event testEvent = new Event(-1, "Test", "zum Testen des Controllers",
            (float)8.5349, (float)49.4733, "Tester",
            "Tester@gmail.com", LocalDateTime.parse("2023-03-01T10:09:26.997"),
            LocalDateTime.parse("2023-03-01T13:09:26.997"), Eventtyp.Essen);
    Event testEvent2 = new Event(-2, "Tester", "zum Testen der Updatefunktionalität",
            (float)9.534927099121942, (float)48.473342449968946, "Test",
            "Test@gmail.com", LocalDateTime.parse("2023-03-01T10:00:26.997"),
            LocalDateTime.parse("2023-03-01T13:00:26.997"), Eventtyp.Kino);

    @Autowired
    public EventsTest(EventController eventController) {
        this.eventController = eventController;
    }

    /**
     * Hier wird die Schnittstelle getestet, die alle Events aus der DB zurückgibt.
     */
    @Test
    void testGet(){
        Event returnEvent = eventController.postEvent(testEvent);
        List<Event> events = eventController.getEvents();
        assertTrue(contains(events, returnEvent));
        eventController.deleteEvent(returnEvent.getId());
    }

    /**
     * In dem testGetById Test wird überprüft, dass die Schnittstelle zum Abfragen eines bestimmten Events
     * mit dessen ID auch nur dieses eine angeforderte Event mit den korrekten Daten zurückgibt
     */
    @Test
    void testGetById(){
        Event returnEvent = eventController.postEvent(testEvent);
        int returnId = returnEvent.getId();
        Event event = eventController.getEvent(returnId);
        assertEvent(returnEvent, event);
        eventController.deleteEvent(returnId);
    }

    /**
     * testGetByCreator prüft die Schnittstelle zum Erhalten von den Events eines Users.
     * Dazu werden zwei Testevents hinzugefügt und dann bei der Abfrage der Events überprüft, ob in der Liste
     * an Events auch nur das eine Event von dem User ist und das des anderen Users nicht angezeigt wird.
     */
    @Test
    void testGetByCreator(){
        Event returnEvent1 = eventController.postEvent(testEvent);
        int returnId1 = returnEvent1.getId();
        Event returnEvent2 = eventController.postEvent(testEvent2);
        int returnId2 = returnEvent2.getId();
        List<Event> events = eventController.getEventByCreator("Tester@gmail.com");
        testEvent.setId(returnId1);
        assertTrue(contains(events, testEvent));
        testEvent2.setId(returnId2);
        assertFalse(contains(events, testEvent2));
        eventController.deleteEvent(returnId1);
        eventController.deleteEvent(returnId2);
    }

    /**
     * Hier wird die Schnittstelle geprüft, die alle möglichen Eventtypen aus dem dazugehörigen Enum zurückgibt.
     */
    @Test
    void testGetEventtyps(){
        List<String> typssearched = eventController.getEventtyps();
        List<String> typs = new ArrayList<>();
        typs.add("Saufen");
        typs.add("Kino");
        typs.add("Essen");
        assertEquals(typssearched, typs);
    }

    /**
     * Der testGetByTyp Test überprüft, ob die Abfrage nach einem spezifischen Eventtypen auch entsprechende Events
     * in der Rückgabeliste ausgibt. Dazu werden zwei Events von unterschiedlichem Typen hinzugefügt und dann die
     * DB abgefragt. Der Rückgabewert sollte dann das eine Testevent des korrekten Typen enthalten.
     * Außerdem sollten alle zurückerhaltenen Events den entsprechenden Typen haben.
     */
    @Test
    void testGetByTyp(){
        Event returnEvent1 = eventController.postEvent(testEvent);
        int returnId1 = returnEvent1.getId();
        Event returnEvent2 = eventController.postEvent(testEvent2);
        int returnId2 = returnEvent2.getId();
        testEvent.setId(returnId1);
        List<Event> events = eventController.getEventByTyp(Eventtyp.Essen);
        assertTrue(contains(events, testEvent));
        boolean correctListEventtyps = true;
        for (Event event : events) {
            if (event.getEventtypEnum() != Eventtyp.Essen) {
                correctListEventtyps = false;
                break;
            }
        }
        assertTrue(correctListEventtyps);
        eventController.deleteEvent(returnId1);
        eventController.deleteEvent(returnId2);
    }

    /**
     * Bei testPost wird die Post Schnittstelle getestet indem ein Objekt hinzugefügt wird und dann überprüft wird,
     * ob dieses in der DB vorhanden ist
     */
    @Test
    void testPost(){
        Event returnEvent = eventController.postEvent(testEvent);
        int returnId = returnEvent.getId();
        Event event = eventController.getEvent(returnId);
        assertEvent(returnEvent, event);
        eventController.deleteEvent(returnId);
    }

    /**
     * Bei testUpdate wird die Update-Schnittstelle getestet. Dazu wird zuerst ein Testobjekt hinzugefügt und dieses
     * wird dann mittels der Update-Schnittstelle aktualisiert. Eine Überprüfung der nun vorhandenen Eventdaten
     * kontrolliert dann, dass das ursprüngliche Event auch gemäßg der Angaben korrekt aktualisiert wurde.
     */
    @Test
    void testUpdate(){
        Event returnEvent1 = eventController.postEvent(testEvent);
        int returnId = returnEvent1.getId();
        testEvent2.setId(returnId);
        eventController.updateEvent(testEvent2);
        Event event = eventController.getEvent(returnId);
        assertEquals(event.getId(), returnId);
        assertNotEquals(testEvent.getDiscription(), event.getDiscription());
        eventController.deleteEvent(returnId);
    }

    /**
     * testet die Schnittstelle zum Löschen von Events.
     * Dafür wird ein Event erst hinzugefügt und überprüft ob es vorhanden ist.
     * Ist das Objekt vorhanden wird das Objekt mittels der Schnittstelle gelöscht und überprüft,
     * ob es nun nicht mehr vorhanden ist
     */
    @Test
    void testDelete(){
        Event returnEvent = eventController.postEvent(testEvent);
        int returnId = returnEvent.getId();
        testEvent.setId(returnId);
        List<Event> eventsBefore = eventController.getEvents();
        assertTrue(contains(eventsBefore, returnEvent));
        eventController.deleteEvent(returnId);
        List<Event> eventsAfter = eventController.getEvents();
        assertFalse(contains(eventsAfter, returnEvent));
    }

    /**
     * assertEvent überprüft, ob die Attribute eines Objekts mit denen des anderen übereinstimmen
     */

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

    /**
     * Funktion die überprüft, ob ein Objekt des Typs Event in einer Liste von Eventobjekten ist.
     */
    private boolean contains(List<Event> events, Event event){
        int i = 0;
        boolean found = false;
        while(i < events.size()) {
            if(event.getId() == events.get(i).getId() &&
                    Objects.equals(event.getName(), events.get(i).getName()) &&
                    Objects.equals(event.getName(), events.get(i).getName())&&
                    Objects.equals(event.getDiscription(), events.get(i).getDiscription())&&
                    event.getLongitude() == events.get(i).getLongitude() &&
                    event.getLatitude() == events.get(i).getLatitude() &&
                    Objects.equals(event.getCreatorName(), events.get(i).getCreatorName()) &&
                    Objects.equals(event.getCreatorId(), events.get(i).getCreatorId()) &&
                    event.getTimestamp().equals(events.get(i).getTimestamp()) &&
                    event.getUntil().equals(events.get(i).getUntil()) &&
                    event.getEventtypEnum() == events.get(i).getEventtypEnum()){
                found = true;
                break;
            }
            i++;
        }
        return found;
    }
}
