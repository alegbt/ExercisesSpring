package co.develhope.firstapi5.controllers;

import co.develhope.firstapi5.DTO.CarDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cars")
public class CarController {


    @GetMapping("")
    public CarDTO getCar(CarDTO newCar){
        return newCar;
    }

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public String createCar(@RequestBody @Valid CarDTO car){
        return car.toString();
    }





}
