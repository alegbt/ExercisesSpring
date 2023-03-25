package com.example._CRUD.controllers;

import com.example._CRUD.entities.Car;
import com.example._CRUD.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @PostMapping("/create")
    public Car createCar(@RequestBody Car car){
        return carRepository.save(car);
    }

    @GetMapping("/get-all")
    public List<Car> getAll(){
        return carRepository.findAll();
    }

    @GetMapping("/get-one")
    public Optional<Car> getone(@RequestParam long id){
        if(carRepository.existsById(id)) {
            Optional<Car> car = carRepository.findById(id);
            return car;
        }else{
            Optional<Car> car2 = Optional.of(new Car());
            return car2;
        }
    }


    @PutMapping("/{id}")
    public Car updateType(@PathVariable long id, @RequestParam String type){
        Car car;
        if(carRepository.existsById(id)){
            car = carRepository.getReferenceById(id);
            car.setType(type);
            car = carRepository.saveAndFlush(car);
        }else{
            car = new Car();
        }
        return car;
    }


    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable long id, HttpServletResponse response){
        if(carRepository.existsById(id)){
            carRepository.deleteById(id);
        }else
            response.setStatus(409);
    }


    @DeleteMapping("/deleteall")
    public void deleteAll(){
        carRepository.deleteAll();
    }













}
