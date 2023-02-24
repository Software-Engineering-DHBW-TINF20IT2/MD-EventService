package com.events.eventService.event;

import javax.persistence.*;

import com.events.eventService.UserDTO;

import java.time.LocalDateTime;

@Entity
public class Event {
    @Id
    int id;

    String name;
    String discription;
    int location;
    UserDTO creator;
    LocalDateTime timestamp;
    LocalDateTime until;

    public Event(int id, String name, String discription, int location,
                 UserDTO creator, LocalDateTime timestamp, LocalDateTime until) {
        this.id = id;
        this.name = name;
        this.discription = discription;
        this.location = location;
        this.creator = creator;
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

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public UserDTO getCreator() {
        return creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
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
