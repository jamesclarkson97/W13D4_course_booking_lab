package com.codeclan.example.course_booking;

import com.codeclan.example.course_booking.models.Course;
import com.codeclan.example.course_booking.repositories.BookingRepository;
import com.codeclan.example.course_booking.repositories.CourseRepository;
import com.codeclan.example.course_booking.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseBookingApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindCoursesWithRatingOf5() {
		List<Course> foundCourse = courseRepository.findByRating(5);
		assertEquals(1, foundCourse.size());
	}

}
