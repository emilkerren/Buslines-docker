package com.sl.buslines.backend.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Buses {
    @SerializedName("BusList")
    List<Bus> busList;

    public Buses(List<Bus> busList) {
        this.busList = busList;
    }

    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }

    @Override
    public String toString() {
        return "Buses{" +
                "busList=" + busList +
                '}';
    }
}
