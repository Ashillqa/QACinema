package com.qa.controller;

import com.qa.domain.Booking;
import com.qa.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Booking>> getAllBookings(){
        return ResponseEntity.ok(this.service.readBookings());
    }

    @PostMapping("/createBooking")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        return new ResponseEntity<Booking>(this.service.createBooking(booking), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteBooking/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id){
        return this.service.deleteBooking(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getBookingById/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findBookingById(id));
    }

    @PutMapping("/updateBooking/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking){
        return ResponseEntity.ok(this.service.updateBooking(id, booking));
    }

}
