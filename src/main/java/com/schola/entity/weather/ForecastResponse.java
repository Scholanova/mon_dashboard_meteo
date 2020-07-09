package com.schola.entity.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.javafx.sg.prism.EffectFilter;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ForecastResponse{
    private String insee;               // Code Insee de la commune
    private int day;                    // Jour entre 0 et 13 (Pour le jour même : 0, pour le lendemain : 1, etc.)
    private String datetime;            // Date en heure locale
    private int weather;                // Temps sensible (Code temps)
    private int tmin;                   // Température minimale
    private int tmax;                   // Température maximale
    private int sun_hours;              // Ensoleillement en heures
    private int probarain;              // Probabilité de pluie entre 0 et 100%
    private int probafrost;            // Probabilité de gel entre 0 et 100%
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

    public int getProbarain() {
        return probarain;
    }

    public void setProbarain(int probarain) {
        this.probarain = probarain;
    }

    public int getProbafrost() {
        return probafrost;
    }

    public void setProbafrost(int probafrost) {
        this.probafrost = probafrost;
    }

    public int getProbafog() {
        return probafog;
    }

    public void setProbafog(int probafog) {
        this.probafog = probafog;
    }

    public String getWeatherType(){
        if (getWeather() == 0)
            return "Soleil";
        if (getWeather() == 1)
            return "Peu nuageux";
        if (getWeather() == 2)
            return "Ciel voilé";
        if (getWeather() == 3)
            return "Nuageux";
        if (getWeather() == 4)
            return "Très nuageux";
        if (getWeather() == 5)
            return "Couvert";
        if (getWeather() == 6)
            return "Brouillard";
        if (getWeather() == 10)
            return "Pluie faible";
        if (getWeather() == 11)
            return "Pluie modérée";
        if (getWeather() == 12)
            return "Pluie forte";
        if (getWeather() == 13)
            return "Pluie faible verglaçante";
        if (getWeather() == 14)
            return "Pluie modérée verglaçante";
        if (getWeather() == 15)
            return "Pluie forte verglaçante";
        if (getWeather() == 20)
            return "Neige faible";
        if (getWeather() == 21)
            return "Neige modérée";
        if (getWeather() == 30)
            return "Pluie et neige mêlées faibles";
        if (getWeather() == 31)
            return "Pluie et neige mêlées modérées";
        if (getWeather() == 32)
            return "Pluie et neige mêlées fortes";
        if (getWeather() == 40)
            return "Averses de pluie locales et faibles";
        if (getWeather() == 41)
            return "Averses de pluie locales";
        if (getWeather() == 42)
            return "Averses locales et fortes";
        if (getWeather() == 43)
            return "Averses de pluie faibles";
        if (getWeather() == 44)
            return "Averses de pluie";
        if (getWeather() == 45)
            return "Averses de pluie fortes";
        if (getWeather() == 46)
            return "Averses de pluie faibles et fréquentes";
        if (getWeather() == 47)
            return "Averses de pluie fréquentes";
        if (getWeather() == 48)
            return "Averses de pluie fortes et fréquentes";
        if (getWeather() == 60)
            return "Averses de neige localisées et faibles";
        if (getWeather() == 61)
            return "Averses de neige localisées";
        if (getWeather() == 62)
            return "Averses de neige localisées et fortes";
        if (getWeather() == 63)
            return "Averses de neige faibles";
        if (getWeather() == 64)
            return "Averses de neige";
        if (getWeather() == 65)
            return "Averses de neige fortes";
        if (getWeather() == 66)
            return "Averses de neige faibles et fréquentes";
        if (getWeather() == 67)
            return "Averses de neige fréquentes";
        if (getWeather() == 68)
            return "Averses de neige fortes et fréquentes";
        if (getWeather() == 70)
            return "Averses de pluie et neige mêlées localisées et faibles";
        if (getWeather() == 71)
            return "Averses de pluie et neige mêlées localisées";
        if (getWeather() == 72)
            return "Averses de pluie et neige mêlées localisées et fortes";
        if (getWeather() == 73)
            return "Averses de pluie et neige mêlées faibles";
        if (getWeather() == 74)
            return "Averses de pluie et neige mêlées";
        if (getWeather() == 75)
            return "Averses de pluie et neige mêlées fortes";
        if (getWeather() == 76)
            return "Averses de pluie et neige mêlées faibles et nombreuses";
        if (getWeather() == 77)
            return "Averses de pluie et neige mêlées fréquentes";
        if (getWeather() == 78)
            return "Averses de pluie et neige mêlées fortes et fréquentes";
        if (getWeather() == 100)
            return "Orages faibles et locaux";
        if (getWeather() == 101)
            return "Orages locaux";
        if (getWeather() == 102)
            return "Orages fort et locaux";
        if (getWeather() == 103)
            return "Orages faibles";
        if (getWeather() == 104)
            return "Orages";
        if (getWeather() == 105)
            return "Orages forts";
        if (getWeather() == 106)
            return "Orages faibles et fréquents";
        if (getWeather() == 107)
            return "Orages fréquents";
        if (getWeather() == 108)
            return "Orages forts et fréquents";
        if (getWeather() == 120)
            return "Orages faibles et locaux de neige ou grésil";
        if (getWeather() == 121)
            return "Orages locaux de neige ou grésil";
        if (getWeather() == 122)
            return "Orages locaux de neige ou grésil";
        if (getWeather() == 123)
            return "Orages faibles de neige ou grésil";
        if (getWeather() == 124)
            return "Orages de neige ou grésil";
        if (getWeather() == 125)
            return "Orages de neige ou grésil";
        if (getWeather() == 126)
            return "Orages faibles et fréquents de neige ou grésil";
        if (getWeather() == 127)
            return "Orages fréquents de neige ou grésil";
        if (getWeather() == 128)
            return "Orages fréquents de neige ou grésil";
        if (getWeather() == 130)
            return "Orages faibles et locaux de pluie et neige mêlées ou grésil";
        if (getWeather() == 131)
            return "Orages locaux de pluie et neige mêlées ou grésil";
        if (getWeather() == 132)
            return "Orages fort et locaux de pluie et neige mêlées ou grésil";
        if (getWeather() == 133)
            return "Orages faibles de pluie et neige mêlées ou grésil";
        if (getWeather() == 134)
            return "Orages de pluie et neige mêlées ou grésil";
        if (getWeather() == 135)
            return "Orages forts de pluie et neige mêlées ou grésil";
        if (getWeather() == 136)
            return "Orages faibles et fréquents de pluie et neige mêlées ou grésil";
        if (getWeather() == 137)
            return "Orages fréquents de pluie et neige mêlées ou grésil";
        if (getWeather() == 138)
            return "Orages forts et fréquents de pluie et neige mêlées ou grésil";
        if (getWeather() == 140)
            return "Pluies orageuses";
        if (getWeather() == 141)
            return "Pluie et neige mêlées à caractère orageux";
        if (getWeather() == 142)
            return "Neige à caractère orageux";
        if (getWeather() == 210)
            return "Pluie faible intermittente";
        if (getWeather() == 211)
            return "Pluie modérée intermittente";
        if (getWeather() == 212)
            return "Pluie forte intermittente";
        if (getWeather() == 220)
            return "Neige faible intermittente";
        if (getWeather() == 221)
            return "Neige modérée intermittente";
        if (getWeather() == 222)
            return "Neige forte intermittente";
        if (getWeather() == 230)
            return "Pluie et neige mêlées";
        if (getWeather() == 231)
            return "Pluie et neige mêlées";
        if (getWeather() == 232)
            return "Pluie et neige mêlées";
        if (getWeather() == 235)
            return "Averses de grêle";
        return String.valueOf(getWeather());
    }
}
