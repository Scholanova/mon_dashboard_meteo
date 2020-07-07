package com.schola.services;

import com.schola.entity.city.City;
import com.schola.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CityServiceImpl implements CityService{
    private CityRepository cityRepository;

    @Autowired
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Iterable<City> listAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Integer id) {
        return cityRepository.findById(id).get();
    }

    @Override
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void deleteCity(Integer id) {
        cityRepository.deleteById(id);
    }

}
