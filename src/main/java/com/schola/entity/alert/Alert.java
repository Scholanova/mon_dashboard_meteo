package com.schola.entity.alert;


import lombok.Data;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Entity
@Table(name = "alert")
@Data
public class Alert  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "caption")
    private String caption;
    @Column(name = "isReccurent")
    private boolean isReccurent;
    @Column(name = "days")
    private String days;
    @Column(name = "hour")
    private Time hour;
    @Column(name = "date")
    private Timestamp date;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "locationId")
    private Integer locationId;


    public Alert() {
    }

    public Alert(String caption, boolean isReccurent, String days, Time hour, Timestamp date, Integer userId, Integer locationId) {
        this.caption = caption;
        this.isReccurent = isReccurent;
        this.days = days;
        this.hour = hour;
        this.date = date;
        this.userId = userId;
        this.locationId = locationId;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public boolean isReccurent() {
        return isReccurent;
    }

    public void setReccurent(boolean reccurent) {
        isReccurent = reccurent;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public Time getHour() {
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }
}