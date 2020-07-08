package com.schola.services;

import com.schola.entity.location.Location;
import com.schola.entity.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserLocationService {

    Logger logger = LoggerFactory.getLogger(UserLocationService.class);
    @Autowired
    UserService userService;

    public List<Location> getUserLocations(String userName) {
        User user = (User) userService.loadUserByUsername(userName);
        logger.info("recherche des lieux favoris pour : "+ userName);
        logger.info("utilisateur " + userName + " nombre de favoris : " + user.getFavoritesLocations().size() );
        return  user.getFavoritesLocations();
    }
}
