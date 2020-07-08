package com.schola.entity.location;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LocationResponse {

    private String nom;
    private String code;
    private String codeDepartement;
    private String codeRegion;
    private List<String> codesPostaux;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public String getCodeRegion() {
        return codeRegion;
    }

    public void setCodeRegion(String codeRegion) {
        this.codeRegion = codeRegion;
    }

    public List<String> getCodesPostaux() {
        return codesPostaux;
    }

    public void setCodesPostaux(List<String> codesPostaux) {
        this.codesPostaux = codesPostaux;
    }
}
