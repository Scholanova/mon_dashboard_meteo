package com.schola.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ConceptMeteoResponse{

    private CityResponse city;

    private ForecastResponse forecast;

    //@JsonFormat(pattern = "YYYY-MM-DDThh:mm:ssTZD")
    //@JsonSerialize(using = LocalDateTimeSerializer.class)
    //@JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private String update;

    public CityResponse getCity() {
        return city;
    }

    public void setCity(CityResponse city) {
        this.city = city;
    }

    public ForecastResponse getForecast() {
        return forecast;
    }

    public void setForecast(ForecastResponse forecast) {
        this.forecast = forecast;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }
}
