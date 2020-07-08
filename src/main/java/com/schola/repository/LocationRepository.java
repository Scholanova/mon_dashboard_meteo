package com.schola.repository;

import com.schola.entity.location.Location;
import com.schola.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

    Optional<Location> findById(Long id);

    List<Location> findAll();
    Location findByName(String name);

}
