package com.qa.rest;

import com.qa.domain.Bookings;
import com.qa.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookingController {
    private final BookingService service;

    @Autowired
    public BookingController(BookingService service) {
        this.service = service;
    }

    @GetMapping("/getAllBookings")
    public List<Bookings> getAllBookings(){
        return this.service.readAllBookings();
    }

    @PostMapping("/createBooking")
    public Bookings createBooking(@RequestBody Bookings booking){
        return this.service.createBooking(booking);
    }

    @DeleteMapping("/deleteBooking/{id}")
    public boolean deleteBooking(@PathVariable Long id){
        return this.service.deleteBooking(id);
    }

    @GetMapping("/getBookingBy/{id}")
    public Bookings getBookingById(@PathVariable Long id){
        return this.service.findBookingById(id);
    }

    @PutMapping("/updateBooking/{id}")
    public Bookings updateNote(@PathVariable Long id, @RequestBody Bookings booking){
        return this.service.updateBooking(id, booking);
    }

}
