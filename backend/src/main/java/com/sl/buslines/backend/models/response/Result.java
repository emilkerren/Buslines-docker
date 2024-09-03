package com.sl.buslines.backend.models.response;

import com.google.gson.GsonBuilder;

public class Result {
    // Fields for JourneyPatternPointOnLine response
    private int LineNumber;
    private int DirectionCode;
    private String JourneyPatternPointNumber;
    private String LastModifiedUtcDateTime;
    private String ExistsFromDate;

    // Fields for StopPoint response
    private String StopPointNumber;
    private String StopPointName;
    private String StopAreaNumber;
    private String LocationNorthingCoordinate;
    private String LocationEastingCoordinate;
    private String ZoneShortName;
    private String StopAreaTypeCode;

    public int getLineNumber() {
        return LineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.LineNumber = lineNumber;
    }

    public int getDirectionCode() {
        return DirectionCode;
    }

    public void setDirectionCode(int directionCode) {
        DirectionCode = directionCode;
    }

    public String getJourneyPatternPointNumber() {
        return JourneyPatternPointNumber;
    }

    public void setJourneyPatternPointNumber(String journeyPatternPointNumber) {
        this.JourneyPatternPointNumber = journeyPatternPointNumber;
    }

    public String getLastModifiedUtcDateTime() {
        return LastModifiedUtcDateTime;
    }

    public void setLastModifiedUtcDateTime(String lastModifiedUtcDateTime) {
        LastModifiedUtcDateTime = lastModifiedUtcDateTime;
    }

    public String getExistsFromDate() {
        return ExistsFromDate;
    }

    public void setExistsFromDate(String existsFromDate) {
        ExistsFromDate = existsFromDate;
    }

    public String getStopPointNumber() {
        return StopPointNumber;
    }

    public void setStopPointNumber(String stopPointNumber) {
        StopPointNumber = stopPointNumber;
    }

    public String getStopPointName() {
        return StopPointName;
    }

    public void setStopPointName(String stopPointName) {
        StopPointName = stopPointName;
    }

    public String getStopAreaNumber() {
        return StopAreaNumber;
    }

    public void setStopAreaNumber(String stopAreaNumber) {
        StopAreaNumber = stopAreaNumber;
    }

    public String getLocationNorthingCoordinate() {
        return LocationNorthingCoordinate;
    }

    public void setLocationNorthingCoordinate(String locationNorthingCoordinate) {
        LocationNorthingCoordinate = locationNorthingCoordinate;
    }

    public String getLocationEastingCoordinate() {
        return LocationEastingCoordinate;
    }

    public void setLocationEastingCoordinate(String locationEastingCoordinate) {
        LocationEastingCoordinate = locationEastingCoordinate;
    }
    public String getZoneShortName() {
        return ZoneShortName;
    }

    public void setZoneShortName(String zoneShortName) {
        ZoneShortName = zoneShortName;
    }

    public String getStopAreaTypeCode() {
        return StopAreaTypeCode;
    }

    public void setStopAreaTypeCode(String stopAreaTypeCode) {
        StopAreaTypeCode = stopAreaTypeCode;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
