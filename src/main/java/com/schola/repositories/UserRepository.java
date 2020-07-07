package com.schola.repositories;

import com.schola.entities.Location;

import java.util.List;


public interface UserRepository {
    List<Location> getFavoritesLocations(Long id);
}
