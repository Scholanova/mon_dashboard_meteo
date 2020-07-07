package com.schola.services;

import com.schola.entity.city.City;

public interface CityService {
    Iterable<City> listAllCities();

    City getCityById(Integer id);

    City saveCity(City city);

    void deleteCity(Integer id);

}
