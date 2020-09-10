package com.codeclan.example.course_booking.components;

import com.codeclan.example.course_booking.models.Booking;
import com.codeclan.example.course_booking.models.Course;
import com.codeclan.example.course_booking.models.Customer;
import com.codeclan.example.course_booking.repositories.BookingRepository;
import com.codeclan.example.course_booking.repositories.CourseRepository;
import com.codeclan.example.course_booking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {}

    public void run(ApplicationArguments args){
        Course course1 = new Course("Introduction to Python", "Edinburgh", 5);
        courseRepository.save(course1);

        Course course2 = new Course("Advanced Spring", "Glasgow", 1);
        courseRepository.save(course2);

        Customer customer1 = new Customer("Rudy", "Edinburgh", 36);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("James", "Edinburgh", 23);
        customerRepository.save(customer2);

        Booking booking1 = new Booking("01-09-20", customer1, course1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("04-06-20", customer2, course2);
        bookingRepository.save(booking2);
    }
}
