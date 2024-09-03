package com.sl.buslines.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Bus {
    @Id
    @GeneratedValue
    private Long id;
	private int busNumber;
	private int numberOfBusStops;
	private List<String> busStops;

	private Bus() {}

	public Bus(int busNumber, int numberOfBusStops, List<String> busStops) {
		this.busNumber = busNumber;
		this.numberOfBusStops = numberOfBusStops;
		this.busStops = busStops;
	}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBusNumber() {
        return this.busNumber;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public int getNumberOfBusStops() {
        return this.numberOfBusStops;
    }

    public void setNumberOfBusStops(int numberOfBusStops) {
        this.numberOfBusStops = numberOfBusStops;
    }

    public List<String> getBusStops() {
        return this.busStops;
    }

    public void setBusStops(List<String> busStops) {
        this.busStops = busStops;
    }

    @Override
    public String toString() {
        return "Bus{" +
            " id='" + getId() + "'" +
            ", busLine='" + getBusNumber() + "'" +
            ", numberOfBusStops='" + getNumberOfBusStops() + "'" +
            ", busStops='" + getBusStops() + "'" +
            "}";
    }
    
}