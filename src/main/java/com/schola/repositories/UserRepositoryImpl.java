package com.schola.repositories;

import com.schola.entities.Location;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;

public class UserRepositoryImpl implements UserRepository {
    private EntityManager entityManager;

    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Location> getFavoritesLocations(Long id) {
        return null;
    }
}
