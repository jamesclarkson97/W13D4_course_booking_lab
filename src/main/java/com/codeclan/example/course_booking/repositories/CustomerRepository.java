package com.codeclan.example.course_booking.repositories;

import com.codeclan.example.course_booking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseNameIgnoreCase(String name);

    List<Customer> findByTownAndBookingsCourseName(String town, String name);

    List<Customer> findByAgeGreaterThanAndTownAndBookingsCourseName(int age, String town, String name);
}
