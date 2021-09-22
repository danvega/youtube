package dev.danvega.javafaker.controller;

import dev.danvega.javafaker.model.Person;
import dev.danvega.javafaker.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // ex: http://localhost:8080/api/people/findBy?first=Lucas&last=Powlowski
    @GetMapping("/findBy")
    public Person findByFirstAndLast(@RequestParam String first, @RequestParam String last) {
        return personRepository.findByFirstNameEqualsAndLastNameEquals(first,last);
    }
}
