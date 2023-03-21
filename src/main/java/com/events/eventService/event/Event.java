package com.events.eventService.event;

import javax.persistence.*;

import java.time.LocalDateTime;

/** Datenobjekt, welches in den Services verwendet wird */
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;
    String discription;
    float longitude;
    float latitude;
    String creatorName;
    String creatorId;
    LocalDateTime timestamp;
    LocalDateTime until;
    Eventtyp eventtypEnum;

    /** Konstruktor für Event Objekt
     *
     * @param id ID des zu erstellenden Eventobjektes
     * @param name Name des zu erstellenden Eventobjektes
     * @param discription Beschreibung des zu erstellenden Eventobjektes
     * @param longitude Longitude des zu erstellenden Eventobjektes
     * @param latitude Latitude des zu erstellenden Eventobjektes
     * @param creatorName Erstellername des zu erstellenden Eventobjektes
     * @param creatorId ErstellerID des zu erstellenden Eventobjektes
     * @param timestamp Startzeitpunkt des zu erstellenden Eventobjektes
     * @param until Endzeitpunkt des zu erstellenden Eventobjektes
     * @param eventtypEnum Eventtyp des zu erstellenden Eventobjektes
     */
    public Event(int id, String name, String discription, float longitude, float latitude,
                 String creatorName, String creatorId, LocalDateTime timestamp,
                 LocalDateTime until, Eventtyp eventtypEnum) {
        this.id = id;
        this.name = name;
        this.discription = discription;
        this.longitude = longitude;
        this.latitude = latitude;
        this.creatorName = creatorName;
        this.creatorId = creatorId;
        this.timestamp = timestamp;
        this.until = until;
        this.eventtypEnum = eventtypEnum;
    }

    /** leerer Konstruktor für Event Objekt */
    public Event(){

    }

    /** Gibt den Wert der Variable id zurück
     * @return ID des Events
     */
    public int getId() {
        return id;
    }

    /** Setzt die Variable id
     *
     * @param id mit der ID des Events
     */
    public void setId(int id) {
        this.id = id;
    }

    /** Gibt den Wert der Variable Name zurück
     *
     * @return Name des Events
     */
    public String getName() {
        return name;
    }

    /** Setzt die Variable Name
     *
     * @param name Zu setzender Name des Events
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Gibt den Wert der Variable Discription zurück
     *
     * @return Beschreibung des Events
     */
    public String getDiscription() {
        return discription;
    }

    /** Set für die Variable Beschreibung
     *
     * @param discription Zu setzende Beschreibung des Events
     */
    public void setDiscription(String discription) {
        this.discription = discription;
    }

    /** Gibt den Wert der Variable Longitude zurück
     *
     * @return Longitude des Events
     */
    public float getLongitude() {
        return longitude;
    }

    /** Set für die Variable Longitude
     *
     * @param longitude Zu setzende Longitude des Events
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /** Gibt den Wert der Variable Latitude zurück
     *
     * @return Latidue des Events
     */
    public float getLatitude() {
        return latitude;
    }

    /** Set für die Variable Latitude
     *
     * @param latitude Zu setzende Latitude des Events
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /** Gibt den Wert der Variable CreatorName zurück
     *
     * @return Name des Erstellers des Events
     */
    public String getCreatorName() {
        return creatorName;
    }

    /** Set für die Variable CreatorName
     *
     * @param creatorName Zu setzender Name des Erstellers
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    /** Gibt den Wert der Variable CreatorId zurück
     *
     * @return ID des Erstellers des Events
     */
    public String getCreatorId() {
        return creatorId;
    }

    /** Set für die Variable CreatorId
     *
     * @param creatorId Zu setzender ID des Erstellers
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    /** Gibt den Wert der Variable Timestamp zurück
     *
     * @return Timestamp des Startzeitpunktes
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /** Set für die Variable Timestamp
     *
     * @param timestamp Zu setzender Startzeitpunkt des Events
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /** Gibt den Wert der Variable Until zurück
     *
     * @return Timestamp des Ablaufdatums
     */
    public LocalDateTime getUntil() {
        return until;
    }

    /** Set für die Variable Until
     *
     * @param until Zu setzender Timestamp des Ablaufdatums des Objektes
     */
    public void setUntil(LocalDateTime until) {
        this.until = until;
    }

    /** Gibt den Wert der Variable EventtypEnum zurück
     *
     * @return Eventtyp des Events
     */
    public Eventtyp getEventtypEnum() {
        return eventtypEnum;
    }

    /** Set für die Variable EventtypEnum
     *
     * @param eventtypEnum Zu setzender Eventtyp
     */
    public void setEventtypEnum(Eventtyp eventtypEnum) {
        this.eventtypEnum = eventtypEnum;
    }
}
