# EventService

- getEvents()
    Übergabewert: n/a
    Rückgabewert: List<Event> mit allen Events der Datenbank
- getEvent(id)
    Übergabewert: Integer id des zu suchenden Event-Objektes
    Rückgabewert: Event
- getEventByCreator
    Übergabewert: String ID des Users dessen Events angezeigt werden sollen
    Rückgabewert: List<Event> mit allen Events von dem User
- getEventtyps
    Übergabewert: n/a
    Rückgabewert: List<String> mit allen Auswahlmöglichkeiten des Enums
- getEventByTyp
    Übergabewert: Eventtyp aus dem Eventtyp.enum zu dem alle Events gesucht werden sollen
    Rückgabewert: List<Events> welche alle Events eines Events beinhaltet
- postEvent
    Übergabewert: Event mit den hinzuzufügenden Daten
    Rückgabewert: Event (mit der neuen generierten Event-Objekt ID)
- updateEvent
    Übergabewert: Event mit den zu löschenden Daten
    Rückgabewert: Event
- deleteEvent
    Übergabewert: Integer id des zu löschenden Event-Objektes
    Rückgabewert: n/a
