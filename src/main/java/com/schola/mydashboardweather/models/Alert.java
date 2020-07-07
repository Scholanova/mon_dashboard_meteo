package com.schola.mydashboardweather.models;

public class Alert {
    private Integer id;
    private String time;
    private String location;
    private Integer repeat;

    public Alert() {
    }

    public Alert(Integer id, String time, String location, Integer repeat) {
        this.id = id;
        this.time = time;
        this.location = location;
        this.repeat = repeat;
    }

    public Integer getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public Integer getRepeat() {
        return repeat;
    }
}
