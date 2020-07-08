package com.schola.controller.location;

import com.schola.entity.location.Location;
import com.schola.services.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    Logger logger = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationService locationService;

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable("id") Long locationId) {
        logger.info("pwet" + locationId);
        return locationService.findById(locationId).get();
    }

    @GetMapping("")
    public List<Location> getAll() {
        logger.info("pwet");
        return locationService.findAll();
    }

    @GetMapping("/name/{name}")
    public Location getLocationByName(@PathVariable("name") String name) {
        logger.info("NAME" + name);
        return locationService.findByName(name);
    }

}
