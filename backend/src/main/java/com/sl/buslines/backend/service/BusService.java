package com.sl.buslines.backend.service;

import com.sl.buslines.backend.models.response.ApiResponse;
import com.sl.buslines.backend.models.response.Result;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sl.buslines.backend.models.Bus;
import com.sl.buslines.backend.models.Buses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BusService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Environment env;
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public ResponseEntity<String> getBusJour() {
        //url for fetching all the buses journey points
        String apiJourUrl = this.env.getProperty("spring.data.rest.base.path") + "?" + this.env.getProperty("spring.data.rest.api.key") + "&" + this.env.getProperty("spring.data.rest.bus.jour.query");
        return restTemplate.getForEntity(apiJourUrl, String.class);
    }

    public ResponseEntity<String> getBusStop() {
        //url for fetching all bus stops with its names
        String apiStopUrl = this.env.getProperty("spring.data.rest.base.path") + "?" + this.env.getProperty("spring.data.rest.api.key") + "&" + this.env.getProperty("spring.data.rest.bus.stop.query");
        return restTemplate.getForEntity(apiStopUrl, String.class);
    }

    public Buses createBuses(ResponseEntity<String> responseJour, ResponseEntity<String> responseStops) {
        ApiResponse jour = GSON.fromJson(responseJour.getBody(), ApiResponse.class);
        ApiResponse stop = GSON.fromJson(responseStops.getBody(), ApiResponse.class);
        //make a list with just the bus line numbers
        List<Integer> lineNumbers = jour.getResponseData().getResult().stream().map(Result::getLineNumber).distinct().toList();

        //put all journey points in a list inside a map with the line number as key
        HashMap<Integer, List<String>> map = new HashMap<>();
        lineNumbers.forEach(nr -> map.put(nr, jour.getResponseData().getResult().stream().filter(x -> nr.equals(x.getLineNumber())).filter(y -> 1 == y.getDirectionCode()).map(Result::getJourneyPatternPointNumber).toList()));

        //sort the list by number of items in the map.entrySet and limit it to 10 items and reverse order to make it descending order
        List<Map.Entry<Integer, List<String>>> sortedList = map.entrySet()
                .stream()
                .sorted(Comparator.comparing(e -> -e.getValue().size()))
                .limit(10)
                .toList();

        //convert JourneyPatternPointNumber to Stop name
        List<Map.Entry<Integer, List<String>>> sortedListWithStopNames = sortedList
                .stream()
                .map(entry -> Map.entry(entry.getKey(), entry.getValue().stream()
                        .map(str -> stop.getResponseData().getResult().stream().filter(result -> str.contentEquals(result.getStopPointNumber())).findFirst().map(Result::getStopPointName).orElse("Unknown")).toList()))
                .toList();

        //loop over list and create Bus object which is then put into its own list
        List<Bus> busList = new ArrayList<>();
        sortedListWithStopNames.stream().map(x -> new Bus(x.getKey(), x.getValue().stream().filter(s -> !s.contentEquals("Unknown")).toList().size(), x.getValue())).collect(Collectors.toCollection(() -> busList));

        return new Buses(busList);
    }
}
