package com.schola.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Weather {

    private String insee;               // Code Insee de la commune
    private int day;                    // Jour entre 0 et 13 (Pour le jour même : 0, pour le lendemain : 1, etc.)
    private LocalDateTime datetime;     // Date en heure locale
    private int probaRain;              // Probabilité de pluie entre 0 et 100%
    private int weather;                // Temps sensible (Code temps)
    private int temp;                   // Température locale
    private int tMin;                   // Température minimale
    private int tMax;                   // Température maximale
    private int sunHours;               // Ensoleillement en heures
    private int probaFrost;             // Probabilité de gel entre 0 et 100%

    public Weather(){

    }

    public Weather(String insee, int day, LocalDateTime datetime, int probaRain, int weather, int temp, int tMin, int tMax, int sunHours, int probaFrost) {
        this.insee = insee;
        this.day = day;
        this.datetime = datetime;
        this.probaRain = probaRain;
        this.weather = weather;
        this.temp = temp;
        this.tMin = tMin;
        this.tMax = tMax;
        this.sunHours = sunHours;
        this.probaFrost = probaFrost;
    }

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

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public int getProbaRain() {
        return probaRain;
    }

    public void setProbaRain(int probaRain) {
        this.probaRain = probaRain;
    }

    public int getWeather() {
        return weather;
    }

    public void setWeather(int weather) {
        this.weather = weather;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int gettMin() {
        return tMin;
    }

    public void settMin(int tMin) {
        this.tMin = tMin;
    }

    public int gettMax() {
        return tMax;
    }

    public void settMax(int tMax) {
        this.tMax = tMax;
    }

    public int getSunHours() {
        return sunHours;
    }

    public void setSunHours(int sunHours) {
        this.sunHours = sunHours;
    }

    public int getProbaFrost() {
        return probaFrost;
    }

    public void setProbaFrost(int probaFrost) {
        this.probaFrost = probaFrost;
    }

    @Override
    public String toString() {
        return "Méteo{" +
                "Insee de la commune =" + insee +
                ", jour ='" + day + '\'' +
                ", Date et heure locale ='" + datetime + '\'' +
                ", Risque de pluie ='" + probaRain + '\'' +
                ", Temps =" + weather +
                ", Température locale =" + temp +
                ", Température minimale =" + tMin +
                ", Température maximale =" + tMax +
                ", Ensoleillement =" + sunHours +
                ", Risque de gel =" + probaFrost +
                '}';
    }
}
