package com.schola.repository.alert;

import com.schola.entity.alert.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AlertRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Alert> listAll() {
        String query = "SELECT ID as id, " +
                    "date AS date " +
                    "days AS days " +
                    "hour As hour " +
                "FROM Alert";

        Map<String, Object> parameters = new HashMap<>();

        return jdbcTemplate.query(query,
                parameters,
                new BeanPropertyRowMapper<>(Alert.class));
    }

}
