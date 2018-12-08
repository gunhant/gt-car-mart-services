package com.tatman.gtcarmartservices;

import com.tatman.gtcarmartservices.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tatman.gtcarmartservices.entities.Car;

@SpringBootApplication
public class GtCarMartServicesApplication {

	// Started on 12-7-2018

	@Autowired
	private CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(GtCarMartServicesApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args-> {
			carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-2111", 2017, 50000));
		};
	}

}
