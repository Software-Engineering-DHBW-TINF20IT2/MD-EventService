# EventService
Die Abfragen finden auf den Pfad "/eventController" statt. 

- getEvents  
    Funktion: Erhalt von allen Events der Datenbank  
    Übergabewert: n/a  
    Rückgabewert: Event List  
- getEvent  
    Funktion: Raussuchen eines bestimmten Events eines Users  
    Übergabewert: Integer Eventid  
    Rückgabewert: Event  
- getEventByCreator  
    Funktion: Raussuchen aller Events, die von einem User erstellt wurden  
    Übergabewert: String UserID  
    Rückgabewert: Event List 
- getEventtyps  
    Funktion: Erhalt von allen Auswahlmöglichkeiten für den Eventtyp  
    Übergabewert: n/a  
    Rückgabewert: String List (mit allen Auswahlmöglichkeiten des Enums)  
- getEventByTyp  
    Funktion: Raussuchen aller Event eines bestimmten Eventtyps  
    Übergabewert: Eventtyp (aus dem Eventtyp.enum)  
    Rückgabewert: Event List   
- postEvent  
    Funktion: Hinzufügen eines Events  
    Übergabewert: Event  
    Rückgabewert: Event (mit der neuen generierten Event-Objekt ID)  
- updateEvent  
    Funktion: Aktualisieren der Daten eines Events  
    Übergabewert: Event (mit den neuen Daten)  
    Rückgabewert: Event  
- deleteEvent  
    Funktion: Löschen eines Events aus der Datenbank  
    Übergabewert: Integer EventId  
    Rückgabewert: n/a  
