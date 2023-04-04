package co.develhope.customqueries1.controllers;

import co.develhope.customqueries1.entities.Flight;
import co.develhope.customqueries1.repositories.FlightRepository;
import co.develhope.customqueries1.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    FlightService flightService;

   @PostMapping
    public ResponseEntity create50Flights(){
        flightService.do50Flights();
        return ResponseEntity.status(HttpStatus.CREATED).body("50 flights created");
    }

   @GetMapping
    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }




}
