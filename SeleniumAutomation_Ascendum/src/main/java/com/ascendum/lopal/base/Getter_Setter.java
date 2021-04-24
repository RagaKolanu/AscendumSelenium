package com.ascendum.lopal.base;

import java.util.ArrayList;

public class Getter_Setter {

    private String LO_Name;
    private String LO_NMLS;
    private String LO_FullAddress;
    private String LO_StreetAddress;
    private String LO_OtherNames;
    private String LO_City;
    private String LO_Zipcode;
    private String LO_State;
    private ArrayList<String> websites = new ArrayList<>();

    public String getLO_Name() { return LO_Name; }

    public void setLO_Name(String LO_Name) {
        this.LO_Name = LO_Name;
    }

    public String getLO_NMLS() {
        return LO_NMLS;
    }

    public void setLO_NMLS(String LO_NMLS) {
        this.LO_NMLS = LO_NMLS;
    }

    public String getLO_FullAddress() {
        return LO_FullAddress;
    }

    public void setLO_FullAddress(String LO_FullAddress) {
        this.LO_FullAddress = LO_FullAddress;
    }

    public String getLO_StreetAddress() {
        return LO_StreetAddress;
    }

    public void setLO_StreetAddress(String LO_StreetAddress) {
        this.LO_StreetAddress = LO_StreetAddress;
    }

    public String getLO_OtherNames() {
        return LO_OtherNames;
    }

    public void setLO_OtherNames(String LO_OtherNames) {
        this.LO_OtherNames = LO_OtherNames;
    }

    public String getLO_City() {
        return LO_City;
    }

    public void setLO_City(String LO_City) {
        this.LO_City = LO_City;
    }

    public String getLO_Zipcode() {
        return LO_Zipcode;
    }

    public void setLO_Zipcode(String LO_Zipcode) {
        this.LO_Zipcode = LO_Zipcode;
    }

    public String getLO_State() {
        return LO_State;
    }

    public void setLO_State(String LO_State) {
        this.LO_State = LO_State;
    }

    public ArrayList<String> getWebsites() {
        return websites;
    }

    public void setWebsites(ArrayList<String> websites) {
        this.websites = websites;
    }




}
