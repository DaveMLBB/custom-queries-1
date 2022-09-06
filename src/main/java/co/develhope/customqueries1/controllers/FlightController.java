package co.develhope.customqueries1.controllers;

import co.develhope.customqueries1.entities.Flight;
import co.develhope.customqueries1.entities.FlightStatus;
import co.develhope.customqueries1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private  final Random random = new Random();
    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/provisioning")
    public List<Flight> generateFlights(){
        List<Flight> flights = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            flights.add(new Flight(random.ints().findFirst().getAsInt() + "",
                                    random.ints().findFirst().getAsInt() + "",
                                    random.ints().findFirst().getAsInt() + "",
                    FlightStatus.ONTIME));
        }
        flightRepository.saveAll(flights);
        return flights;
    }

    @GetMapping()
    public List<Flight> getAll(){
        return  flightRepository.findAll();
    }





}
