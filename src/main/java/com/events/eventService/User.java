package com.events.eventService;

import javax.persistence.*;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Set;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Entity
public class User {
    @Id
    String id;

    String personUsername;
    String personName;
    String personFamilyName;

    Boolean gaveConsent;
    URI personPhoto;

    @ManyToMany
    @JoinTable(name = "user_users",
            joinColumns = @JoinColumn(name = "user_1_id"),
            inverseJoinColumns = @JoinColumn(name = "users_2_id"))
    private Set<User> friends = new LinkedHashSet<>();

    @Retention(RUNTIME)
    @Target(FIELD)
    public @interface MyJoinColumn {
        String id() default "";
        String personUsername() default "";
        String personName() default "";
        String personFamilyName() default "";
    }

    public UserDTO toUserDTO(){
        return new UserDTO(this.id, this.personUsername, this.personName,
                this.personFamilyName, this.gaveConsent, this.personPhoto);
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public User(String id, String personUsername, String personName,
                String personFamilyName, Boolean gaveConsent,
                URI personPhoto, Set<User> friends) {
        this.id = id;
        this.personUsername = personUsername;
        this.personName = personName;
        this.personFamilyName = personFamilyName;
        this.gaveConsent = gaveConsent;
        this.personPhoto = personPhoto;
        this.friends = friends;
    }

    public User() {

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
