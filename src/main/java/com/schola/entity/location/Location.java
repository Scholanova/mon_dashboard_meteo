package com.schola.entity.location;

import com.schola.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// https://www.baeldung.com/jpa-many-to-many
@Entity
@Table(name = "Location")
@AllArgsConstructor
@Getter
@Setter
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


}
