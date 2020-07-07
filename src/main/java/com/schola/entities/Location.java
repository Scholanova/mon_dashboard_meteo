package com.schola.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// https://www.baeldung.com/jpa-many-to-many
@Entity
@Table(name = "Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "insee")
    private String insee;

    @ManyToMany(mappedBy = "favoritesLocations")
    private List<User> users = new ArrayList<>();


    public Location() {
    }

    public String getInsee() { return insee; }
    public void setInsee(String insee) { this.insee = insee; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public List<User> getUsers() { return users; }
    public void setUsers(List<User> users) { this.users = users; }
}
