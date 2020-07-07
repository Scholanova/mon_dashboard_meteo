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
    private boolean isReccurent;
    @Column(name = "days")
    private String days;
    @Column(name = "hour")
    private Time hour;
    @Column(name = "date")
    private Timestamp date;
    @Column(name = "id_user")
    private Integer userId;
    @Column(name = "location_id")
    private Integer locationId;


    public Alert() {
    }




}