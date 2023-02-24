package com.events.eventService.event;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Event {
    @Id
    int id;

    String name;
    String discription;
    float longitude;
    float latitude;
    String creatorId;
    LocalDateTime timestamp;
    LocalDateTime until;

    public Event(int id, String name, String discription, float longitude, float latitude,
                 String creatorId, LocalDateTime timestamp, LocalDateTime until) {
        this.id = id;
        this.name = name;
        this.discription = discription;
        this.longitude = longitude;
        this.latitude = latitude;
        this.creatorId = creatorId;
        this.timestamp = timestamp;
        this.until = until;
    }

    public Event(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getUntil() {
        return until;
    }

    public void setUntil(LocalDateTime until) {
        this.until = until;
    }
}
