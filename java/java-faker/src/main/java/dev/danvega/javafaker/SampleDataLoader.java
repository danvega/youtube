package dev.danvega.javafaker;

import com.github.javafaker.Faker;
import dev.danvega.javafaker.model.Address;
import dev.danvega.javafaker.model.Person;
import dev.danvega.javafaker.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final PersonRepository personRepository;
    private final Faker faker;

    public SampleDataLoader(PersonRepository personRepository, Faker faker) {
        this.personRepository = personRepository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {

        // create 100 rows of fake data
        List<Person> people = IntStream.rangeClosed(1,100)
                .mapToObj(i -> new Person(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.phoneNumber().cellPhone(),
                        faker.internet().emailAddress(),
                        new Address(
                                faker.address().streetAddress(),
                                faker.address().city(),
                                faker.address().state(),
                                faker.address().zipCode())
                )).collect(Collectors.toList());

        personRepository.saveAll(people);

    }
}
