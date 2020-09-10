package com.codeclan.example.course_booking;

import com.codeclan.example.course_booking.models.Booking;
import com.codeclan.example.course_booking.models.Course;
import com.codeclan.example.course_booking.models.Customer;
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

	@Test
	public void canGetCustomersInACourse() {
		List<Customer> foundCustomers = customerRepository.findByBookingsCourseName("Advanced Spring");
		assertEquals(2, foundCustomers.size());
	}

	@Test
	public void canGetCoursesForAGivenCustomer() {
		List<Course> foundCourses = courseRepository.findByBookingsCustomerName("Rudy");
		assertEquals(2, foundCourses.size());
	}

	@Test
	public void canGetBookingsForAGivenDate() {
		List<Booking> foundBookings = bookingRepository.findByDate("01-09-20");
		assertEquals(1, foundBookings.size());
	}

	@Test
	public void canGetCustomersInGivenTownAndCourse() {
		List<Customer> foundCustomers = customerRepository.findByTownAndBookingsCourseName("Edinburgh","Advanced Spring");
		assertEquals(2, foundCustomers.size());
	}

}
