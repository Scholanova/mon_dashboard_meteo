package com.schola.services;

import com.schola.entities.Location;
import com.schola.repositories.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository userRepository;

    public UserService(com.schola.repositories.UserRepository userLocationRepository) {
        this.userRepository = userLocationRepository;
    }

    public List<Location> getFavoritesLocations(long userId) {
        return userRepository.getFavoritesLocations(userId);
    }
}
