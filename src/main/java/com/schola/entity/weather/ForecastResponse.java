package com.schola.entity.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ForecastResponse{
    private String insee;               // Code Insee de la commune
    private int day;                    // Jour entre 0 et 13 (Pour le jour même : 0, pour le lendemain : 1, etc.)
    private String datetime;            // Date en heure locale
    private int probarain;              // Probabilité de pluie entre 0 et 100%
    private int weather;                // Temps sensible (Code temps)
    private int tmin;                   // Température minimale
    private int tmax;                   // Température maximale
    private int sun_hours;              // Ensoleillement en heures
    private int probafrostv;            // Probabilité de gel entre 0 et 100%
    private int probafog;               // Probabilité de brouillard entre 0 et 100%

    public String getInsee() {
        return insee;
    }

    public void setInsee(String insee) {
        this.insee = insee;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getProbarain() {
        return probarain;
    }

    public void setProbarain(int probarain) {
        this.probarain = probarain;
    }

    public int getWeather() {
        return weather;
    }

    public void setWeather(int weather) {
        this.weather = weather;
    }

    public int getTmin() {
        return tmin;
    }

    public void setTmin(int tmin) {
        this.tmin = tmin;
    }

    public int getTmax() {
        return tmax;
    }

    public void setTmax(int tmax) {
        this.tmax = tmax;
    }

    public int getSun_hours() {
        return sun_hours;
    }

    public void setSun_hours(int sun_hours) {
        this.sun_hours = sun_hours;
    }

    public int getProbafrostv() {
        return probafrostv;
    }

    public void setProbafrostv(int probafrostv) {
        this.probafrostv = probafrostv;
    }

    public int getProbafog() {
        return probafog;
    }

    public void setProbafog(int probafog) {
        this.probafog = probafog;
    }
}
