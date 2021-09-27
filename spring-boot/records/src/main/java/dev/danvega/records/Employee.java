package dev.danvega.records;

import org.springframework.data.annotation.Id;

public record Employee(@Id Integer id, String firstName, String lastName, String email) {

}
