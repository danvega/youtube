package dev.danvega.log4jv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Log4jvApplication {

    private static final Logger log = LoggerFactory.getLogger(Log4jvApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(Log4jvApplication.class, args);
        var message = "Hello World!";
        log.info("Logging {}", message);
    }

}
