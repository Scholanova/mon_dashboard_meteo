package com.schola.controller.location;

import com.schola.entity.location.Location;
import com.schola.services.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/locations")
public class LocationController {

    Logger logger = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationService locationService;

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable("id") Long locationId) {
        return locationService.findById(locationId).get();
    }

    @GetMapping("")
    public List<Location> getAll() {
        return locationService.findAll();
    }

    @GetMapping("/name/{name}")
    public Location getLocationByName(@PathVariable("name") String name) {
        return locationService.findByName(name);
    }

}
