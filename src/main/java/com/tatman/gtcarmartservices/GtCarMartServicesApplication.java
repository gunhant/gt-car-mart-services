package com.tatman.gtcarmartservices;

import com.tatman.gtcarmartservices.entities.Owner;
import com.tatman.gtcarmartservices.entities.User;
import com.tatman.gtcarmartservices.repositories.CarRepository;
import com.tatman.gtcarmartservices.repositories.OwnerRepository;
import com.tatman.gtcarmartservices.repositories.UserRepository;
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

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(GtCarMartServicesApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args-> {

			Owner owner1 = new Owner("Ben", "Johnson");
			Owner owner2 = new Owner("Bill", "Brown");

			ownerRepository.save(owner1);
			ownerRepository.save(owner2);

			carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-2111", 2017, 50000, owner1));
			carRepository.save(new Car("Nissan", "Sentra", "Blue", "ADB-3333", 2017, 30000, owner1));
			carRepository.save(new Car("Mazda", "Miata", "White", "CCC-4444", 2015, 20000, owner2));

			// username: user password: user
			userRepository.save(new User("user",
					"$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi",
					"USER"));
			// username: admin password: admin
			userRepository.save(new User("admin",
					"$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
					"ADMIN"));

			// username: gunhan password: gunhan
			// used BCrypt calculator at: https://www.browserling.com/tools/bcrypt
			userRepository.save(new User("gunhan",
					"$2a$10$N8Sn78zCAkQIO8rtbbR5SuA9CPbviDHyQP5vowT60VC6yGYuRoUxC",
					"ADMIN"));

		};
	}

}
