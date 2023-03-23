# EventService
## Beschreibung

Dieses Repository bietet das Backend der Eventfunktionen. 
Der Nutzen ist dabei, dass Events abgefragt, hinzugefügt, bearbeitet und gelöscht werden können.

### Verfügbare Endpoints
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

## Technische Details

### Datenbank

Die in dem EventService verwendete Datenbank ist eine in der Azure Cloud gehostete MySQL Datenbank. Diese wird ausschließlich durch das Backend und dessen Service adressiert. Die Tabellen werden durch Hibernate automatisch erstellt, sodass die Objekte ohne Fehler in der DB übertragen wurden.

### Spring Service

Dieses Repository baut einen Spring Boot Service, welcher die Daten mit Spring Data JPA von der zuvor beschriebenen Datenbank RESTful zur Verfügung stellt.

## Ausführen dieses Programms

Um den Programmcode auzuführen gibt es zwei Möglichkeite:

### 1. Über IntelliJ

Hierzu führt man die Main Funktion in der Klasse EventServiceApplication aus

### 2. Über die Komandozeile

Navigiert man in den Primär Ordner des Project so kann man dort mit einem installierten Maven und Java 17 mit folgendem Befehl die Anwendung ausführen: mvn spring-boot:run
Die Abfragen finden auf den Pfad "/eventController" statt. 
