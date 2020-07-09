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
            return "SUN";
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
        if (getWeather() == 7)
            return "Brouillard givrant";
        return String.valueOf(getWeather());
    }

            /*
            10 => "Pluie faible",
            11 => "Pluie modérée",
            12 => "Pluie forte",
            13 => "Pluie faible verglaçante",
            14 => "Pluie modérée verglaçante",
            15 => "Pluie forte verglaçante",
            16 => "Bruine",
            20 => "Neige faible",
            21 => "Neige modérée",
            22 => "Neige forte",
            30 => "Pluie et neige mêlées faibles",
            31 => "Pluie et neige mêlées modérées",
            32 => "Pluie et neige mêlées fortes",
            40 => "Averses de pluie locales et faibles",
            41 => "Averses de pluie locales",
            42 => "Averses locales et fortes",
            43 => "Averses de pluie faibles",
            44 => "Averses de pluie",
            45 => "Averses de pluie fortes",
            46 => "Averses de pluie faibles et fréquentes",
            47 => "Averses de pluie fréquentes",
            48 => "Averses de pluie fortes et fréquentes",
            60 => "Averses de neige localisées et faibles",
            61 => "Averses de neige localisées",
            62 => "Averses de neige localisées et fortes",
            63 => "Averses de neige faibles",
            64 => "Averses de neige",
            65 => "Averses de neige fortes",
            66 => "Averses de neige faibles et fréquentes",
            67 => "Averses de neige fréquentes",
            68 => "Averses de neige fortes et fréquentes",
            70 => "Averses de pluie et neige mêlées localisées et faibles",
            71 => "Averses de pluie et neige mêlées localisées",
            72 => "Averses de pluie et neige mêlées localisées et fortes",
            73 => "Averses de pluie et neige mêlées faibles",
            74 => "Averses de pluie et neige mêlées",
            75 => "Averses de pluie et neige mêlées fortes",
            76 => "Averses de pluie et neige mêlées faibles et nombreuses",
            77 => "Averses de pluie et neige mêlées fréquentes",
            78 => "Averses de pluie et neige mêlées fortes et fréquentes",
            100 => "Orages faibles et locaux",
            101 => "Orages locaux",
            102 => "Orages fort et locaux",
            103 => "Orages faibles",
            104 => "Orages",
            105 => "Orages forts",
            106 => "Orages faibles et fréquents",
            107 => "Orages fréquents",
            108 => "Orages forts et fréquents",
            120 => "Orages faibles et locaux de neige ou grésil",
            121 => "Orages locaux de neige ou grésil",
            122 => "Orages locaux de neige ou grésil",
            123 => "Orages faibles de neige ou grésil",
            124 => "Orages de neige ou grésil",
            125 => "Orages de neige ou grésil",
            126 => "Orages faibles et fréquents de neige ou grésil",
            127 => "Orages fréquents de neige ou grésil",
            128 => "Orages fréquents de neige ou grésil",
            130 => "Orages faibles et locaux de pluie et neige mêlées ou grésil",
            131 => "Orages locaux de pluie et neige mêlées ou grésil",
            132 => "Orages fort et locaux de pluie et neige mêlées ou grésil",
            133 => "Orages faibles de pluie et neige mêlées ou grésil",
            134 => "Orages de pluie et neige mêlées ou grésil",
            135 => "Orages forts de pluie et neige mêlées ou grésil",
            136 => "Orages faibles et fréquents de pluie et neige mêlées ou grésil",
            137 => "Orages fréquents de pluie et neige mêlées ou grésil",
            138 => "Orages forts et fréquents de pluie et neige mêlées ou grésil",
            140 => "Pluies orageuses",
            141 => "Pluie et neige mêlées à caractère orageux",
            142 => "Neige à caractère orageux",
            210 => "Pluie faible intermittente",
            211 => "Pluie modérée intermittente",
            212 => "Pluie forte intermittente",
            220 => "Neige faible intermittente",
            221 => "Neige modérée intermittente",
            222 => "Neige forte intermittente",
            230 => "Pluie et neige mêlées",
            231 => "Pluie et neige mêlées",
            232 => "Pluie et neige mêlées",
            235 => "Averses de grêle",
            */

}
