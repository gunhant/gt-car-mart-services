package com.tatman.gtcarmartservices.controllers;

import com.tatman.gtcarmartservices.entities.Car;
import com.tatman.gtcarmartservices.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public Iterable<Car> getCars() {

        return carRepository.findAll();

    }
}
