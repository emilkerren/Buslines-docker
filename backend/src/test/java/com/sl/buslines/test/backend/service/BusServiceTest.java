package com.sl.buslines.test.backend.service;

import com.sl.buslines.backend.models.Bus;
import com.sl.buslines.backend.models.Buses;
import com.sl.buslines.backend.models.response.ApiResponse;
import com.sl.buslines.backend.models.response.ResponseData;
import com.sl.buslines.backend.models.response.Result;
import com.sl.buslines.backend.service.BusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BusServiceTest {
    private ApiResponse responseApiJour;
    private ApiResponse responseApiStop;
    private ResponseEntity<String> responseEntityJour;
    private ResponseEntity<String> responseEntityStop;
    private ResponseData responseJour;
    private ResponseData responseStop;
    @BeforeEach
    public void setup() {
        Result res1 = new Result();
        res1.setLineNumber(1);
        res1.setDirectionCode(1);
        res1.setJourneyPatternPointNumber("10001");
        res1.setLastModifiedUtcDateTime("2022-02-15 00:00:00.000");
        res1.setExistsFromDate("2022-02-15 00:00:00.000");
        Result res2 = new Result();
        res2.setLineNumber(1);
        res2.setDirectionCode(1);
        res2.setJourneyPatternPointNumber("10006");
        res2.setLastModifiedUtcDateTime("2022-02-15 00:00:00.000");
        res2.setExistsFromDate("2022-02-15 00:00:00.000");
        Result res3 = new Result();
        res3.setLineNumber(2);
        res3.setDirectionCode(1);
        res3.setJourneyPatternPointNumber("10008");
        res3.setLastModifiedUtcDateTime("2022-02-15 00:00:00.000");
        res3.setExistsFromDate("2023-03-07 00:00:00.000");
        responseJour = new ResponseData();
        responseJour.setType("JourneyPatternPointOnLine");
        responseJour.setVersion("2023-04-16 00:11");
        responseJour.setResult(List.of(
                res1,
                res2,
                res3
        ));
        responseApiJour = new ApiResponse();
        responseApiJour.setStatusCode(200);
        responseApiJour.setMessage(null);
        responseApiJour.setExecutionTime(500);
        responseApiJour.setResponseData(responseJour);
        String responseBodyJour = responseApiJour.toString();
        HttpHeaders headersJour = new HttpHeaders();
        responseEntityJour = new ResponseEntity<>(responseBodyJour, headersJour, HttpStatus.OK);

        responseStop = new ResponseData();
        Result resStop1 = new Result();
        resStop1.setStopPointNumber("10001");
        resStop1.setStopPointName("Stadshagsplan");
        resStop1.setStopAreaNumber("10001");
        resStop1.setLocationNorthingCoordinate("59.3373571967995");
        resStop1.setLocationEastingCoordinate("18.0214674159693");
        resStop1.setZoneShortName("A");
        resStop1.setStopAreaTypeCode("BUSTERM");
        Result resStop2 = new Result();
        resStop2.setStopPointNumber("10006");
        resStop2.setStopPointName("Arbetargatan");
        resStop2.setStopAreaNumber("10006");
        resStop2.setLocationNorthingCoordinate("59.3373571967995");
        resStop2.setLocationEastingCoordinate("18.0214674159693");
        resStop2.setZoneShortName("A");
        resStop2.setStopAreaTypeCode("BUSTERM");
        Result resStop3 = new Result();
        resStop3.setStopPointNumber("10012");
        resStop3.setStopPointName("John Bergs plan");
        resStop3.setStopAreaNumber("10012");
        resStop3.setLocationNorthingCoordinate("59.3362549983713");
        resStop3.setLocationEastingCoordinate("18.0220232520707");
        resStop3.setZoneShortName("A");
        resStop3.setStopAreaTypeCode("BUSTERM");
        responseStop.setVersion("2023-04-19 00:11");
        responseStop.setType("StopPoint");
        responseStop.setResult(List.of(resStop1, resStop2, resStop3));
        responseApiStop = new ApiResponse();
        responseApiStop.setStatusCode(200);
        responseApiStop.setMessage(null);
        responseApiStop.setExecutionTime(500);
        responseApiStop.setResponseData(responseStop);

        String responseBodyStop = responseApiStop.toString();
        HttpHeaders headersStop = new HttpHeaders();
        responseEntityStop = new ResponseEntity<>(responseBodyStop, headersStop, HttpStatus.OK);
    }

    @Test
    void createBuses() {
        Buses expected = new Buses(List.of(new Bus(1, 2, List.of("Stadshagsplan", "Arbetargatan")),
                new Bus(2, 0, List.of("Unknown"))));
        BusService busService = new BusService();
        Buses actual = busService.createBuses(responseEntityJour, responseEntityStop);

        assertEquals(expected.toString(), actual.toString());
    }
}