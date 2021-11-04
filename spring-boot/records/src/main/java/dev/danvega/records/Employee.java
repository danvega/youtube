package dev.danvega.records;

import org.springframework.data.annotation.Id;

public record Employee(@Id Integer id, String firstName, String lastName, String email) {


//    public Employee(Integer id, String firstName, String lastName, String email) {
//        if(email.isEmpty() || email == null) {
//            throw new IllegalArgumentException("Email cannot be empty");
//        }
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//    }

    public Employee {
        if(email.isEmpty() || email == null) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
    }

}
