package com.sl.buslines.backend.controller;

import com.sl.buslines.backend.models.Buses;
import com.sl.buslines.backend.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping("/buses")
    public Buses getBuses() {
        ResponseEntity<String> jour;
        ResponseEntity<String> stop;
        try {
            jour = busService.getBusJour();
        } catch (Exception e) {
            throw new RestClientException("Error getting jour object", e);
        }
        try {
            stop = busService.getBusStop();
        } catch (Exception e) {
            throw new RestClientException("Error getting stop object", e);
        }

        return busService.createBuses(jour, stop);

    }
}
