package com.events.eventService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Die EventServiceApplication-Klasse ist die Hauptklasse der Anwendung und startet die Spring Boot-Anwendung.
 * Diese Klasse ist mit der @SpringBootApplication-Annotation versehen, die die Konfiguration und den Start der Anwendung vereinfacht.
 */
@SpringBootApplication
public class EventServiceApplication {

	/**
	 * Die main-Methode ist der Einstiegspunkt der Anwendung.
	 * Diese Methode startet die Spring Boot-Anwendung.
	 * @param args Die Kommandozeilenargumente, die an die Anwendung übergeben werden.
	 */
	public static void main(String[] args) {
		SpringApplication.run(EventServiceApplication.class, args);
	}
}
