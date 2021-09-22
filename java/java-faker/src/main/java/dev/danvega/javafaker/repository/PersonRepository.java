package dev.danvega.javafaker.repository;

import dev.danvega.javafaker.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Integer> {

    Person findByFirstNameEqualsAndLastNameEquals(String first, String last);

}
