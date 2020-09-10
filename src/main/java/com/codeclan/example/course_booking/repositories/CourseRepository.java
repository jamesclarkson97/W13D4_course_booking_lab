package com.codeclan.example.course_booking.repositories;

import com.codeclan.example.course_booking.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByRating(int i);

    List<Course> findByBookingsCustomerName(String name);
}
