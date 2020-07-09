package com.schola.services;

import com.schola.entity.location.Location;
import com.schola.entity.user.User;
import com.schola.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class UserLocationService {

    Logger logger = LoggerFactory.getLogger(UserLocationService.class);

    @Autowired
    UserService userService;

    @Autowired
    LocationService locationService;

    public List<Location> getUserLocations(String userName) {
        User user = (User) userService.loadUserByUsername(userName);
        logger.info("recherche des lieux favoris pour : "+ userName);
        logger.info("utilisateur " + userName + " nombre de favoris : " + user.getFavoritesLocations().size() );
        return  user.getFavoritesLocations();
    }

    public void removeFavoriteLocation(String userName, Long id){
        User user = (User) userService.loadUserByUsername(userName);
        Location location = locationService.findById(id).get();

        logger.info("existing location : " +location);

        if(location != null){
            user.removeLocation(location);
        }
    }
    public void addFavoriteLocation(String userName, String locationName, String locationInsee) {
        User user = (User) userService.loadUserByUsername(userName);
        Location existingLocation = locationService.findByName(locationName);
        logger.info("existingLocation : " + existingLocation);

        if(existingLocation == null)
        {
            Location newLocation = new Location();
            newLocation.setName(locationName);
            newLocation.setInsee(locationInsee);
            locationService.save(newLocation);
            user.addLocation(newLocation);
        }
        else
        {
            boolean userAlreadyHaveLocation = user.getFavoritesLocations().contains(existingLocation);

            logger.info("userAlreadyHaveLocation : "+ userAlreadyHaveLocation);
            if(!userAlreadyHaveLocation){
                user.addLocation(existingLocation);
            }
        }

        logger.info("Userlocations" + user.getFavoritesLocations() );
    }
}
