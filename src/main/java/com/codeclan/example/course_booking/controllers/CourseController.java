package com.codeclan.example.course_booking.controllers;

import com.codeclan.example.course_booking.models.Course;
import com.codeclan.example.course_booking.models.Customer;
import com.codeclan.example.course_booking.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name="customer", required = false) String customer,
            @RequestParam(name="rating", required = false) Integer rating) {
        if (customer != null) {
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerName(customer), HttpStatus.OK);
        }
        if (rating != null) {
            return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }
}
