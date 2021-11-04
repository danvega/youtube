package dev.danvega.records;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class RecordsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecordsApplication.class, args);
    }

    @Bean
    @Profile("!test")
    public CommandLineRunner commandLineRunner(EmployeeRepository repository) {
        return args -> {
            repository.save(new Employee(null, "Dan", "Vega", "danvega@gmail.com"));
        };
    }

}
