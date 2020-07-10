package com.schola.entity.location;

import com.schola.entity.user.User;
import com.schola.entity.weather.ConceptMeteoResponse;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class LocationVM {
    private Long id;

    private String name;


    private String insee;

    private List<User> users = new ArrayList<>();


    public ConceptMeteoResponse getResponse() {
        return response;
    }

    public void setResponse(ConceptMeteoResponse response) {
        this.response = response;
    }

    private ConceptMeteoResponse response;

}
