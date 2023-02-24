package com.events.eventService;

import java.net.URI;
import java.util.Collections;


public class UserDTO {
    String id;

    String personUsername;
    String personName;
    String personFamilyName;

    Boolean gaveConsent;
    URI personPhoto;

    public User toUser(){
        return new User(this.id, this.personUsername, this.personName,
                this.personFamilyName, this.gaveConsent, this.personPhoto, Collections.emptySet());
    }

    public UserDTO(String id, String personUsername, String personName,
                   String personFamilyName, Boolean gaveConsent,
                   URI personPhoto) {
        this.id = id;
        this.personUsername = personUsername;
        this.personName = personName;
        this.personFamilyName = personFamilyName;
        this.gaveConsent = gaveConsent;
        this.personPhoto = personPhoto;
    }

    public UserDTO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonUsername() {
        return personUsername;
    }

    public void setPersonUsername(String personUsername) {
        this.personUsername = personUsername;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonFamilyName() {
        return personFamilyName;
    }

    public void setPersonFamilyName(String personFamilyName) {
        this.personFamilyName = personFamilyName;
    }

    public URI getPersonPhoto() {
        return personPhoto;
    }

    public void setPersonPhoto(URI personPhoto) {
        this.personPhoto = personPhoto;
    }

    public Boolean getGaveConsent() {
        return gaveConsent;
    }

    public void setGaveConsent(Boolean gaveConsent) {
        this.gaveConsent = gaveConsent;
    }

}
