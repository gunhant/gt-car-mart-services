package com.tatman.gtcarmartservices.repositories;

import com.tatman.gtcarmartservices.entities.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*

Method	                        Description

long count()	                Returns the number of entities
Iterable<T> findAll()	        Returns all items of given type
Optional<T> findById(ID Id)	    Returns one item by id
void delete(T entity)	        Deletes an entity
void deleteAll()	            Deletes all entities of the repository
<S extends T> save(S entity)	Saves an entity

 */

public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findByBrand(String brand);
    List<Car> findByColor(String color);
    List<Car> findByYear(int year);

}
