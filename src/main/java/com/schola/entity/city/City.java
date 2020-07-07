package com.schola.entity.city;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "location")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "city_id")
    private String cityId;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "city_lat")
    private String cityLat;
    @Column(name = "city_lon")
    private String cityLon;
}
