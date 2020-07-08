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
    @Column(name = "isrecurrent")
    private Boolean isReccurent;
    @Column(name = "days")
    private String days;
    @Column(name = "hour")
    private String hour;
    @Column(name = "date")
    private String date;
    @Column(name = "id_user")
    private Long userId;
    @Column(name = "location_id")
    private Long locationId;


    public Alert() {
    }


    public Alert(String caption, Boolean isReccurent, String days, String hour, String date, Long idUser, Long locationId) {
        this.caption = caption;
        this.isReccurent = isReccurent;
        this.days =days;
        this.hour = hour;
        this.date = date;
        this.userId = idUser;
        this.locationId = locationId;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}