package com.codeclan.example.course_booking.controllers;

import com.codeclan.example.course_booking.models.Customer;
import com.codeclan.example.course_booking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value="/customers")
    public ResponseEntity<List<Customer>> getAllCustomer(
            @RequestParam(name="course", required = false) String course,
            @RequestParam(name = "town", required = false) String town,
            @RequestParam(name = "age", required = false) Integer age
            ) {
        if (age != null && course != null && town != null) {
            return new ResponseEntity<>(customerRepository.findByAgeGreaterThanAndTownAndBookingsCourseName(age, town, course), HttpStatus.OK);
        }
        if (course != null && town != null) {
            return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseName(town, course), HttpStatus.OK);
        }
        if (course != null) {
            return new ResponseEntity<>(customerRepository.findByBookingsCourseName(course), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
