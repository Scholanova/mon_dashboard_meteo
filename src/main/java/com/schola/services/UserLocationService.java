package com.schola.services;

import com.schola.entities.Location;
import com.schola.repositories.UserLocationRepository;

import java.util.List;

public class UserLocationService {

    private UserLocationRepository userLocationRepository;

    public UserLocationService(UserLocationRepository userLocationRepository) {
        this.userLocationRepository = userLocationRepository;
    }

    public List<Location> listLocationByUserId(int userId) {
        return userLocationRepository.listLocationByUserId(userId);
    }
}
