package com.schola.services;

import com.schola.entity.location.Location;
import com.schola.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public Optional<Location> findById(Long id) { return locationRepository.findById(id); }
    public List<Location> findAll() { return locationRepository.findAll(); }
    public Location findByName(String name){
        return  locationRepository.findByName(name);
    }

}
