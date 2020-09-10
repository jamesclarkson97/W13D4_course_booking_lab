package com.codeclan.example.course_booking.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "town")
    private String town;

    @Column(name = "rating")
    private int rating;

    @OneToMany(mappedBy = "course")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @JsonIgnoreProperties({"course"})
    private List<Booking> bookings;

    public Course(String name, String town, int rating) {
        this.name = name;
        this.town = town;
        this.rating = rating;
        this.bookings = new ArrayList<>();
    }

    public Course() {
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }

    public int getRating() {
        return rating;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
