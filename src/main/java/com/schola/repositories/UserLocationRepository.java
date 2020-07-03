package com.schola.repositories;

import com.schola.entities.Location;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserLocationRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public UserLocationRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Location> listLocationByUserId(int userId) {
        return null;
        //TODO
    }

}