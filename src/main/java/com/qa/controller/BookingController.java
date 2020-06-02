package com.qa.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dto.BookingDTO;
import com.qa.domain.Booking;
import com.qa.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private BookingService service;

    @Autowired
    public BookingController(BookingService service) {
        super();
        this.service = service;
    }

    @PostMapping("/createBooking")
    public ResponseEntity<BookingDTO> createBooking(@RequestBody Booking booking) {
        return new ResponseEntity<BookingDTO>(this.service.createBooking(booking), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteBooking/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id) {
        return this.service.deleteBooking(id) ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BookingDTO> getBooking(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.findBookingByID(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        return ResponseEntity.ok(this.service.readBookings());
    }

    @PutMapping("/updateBooking")
    public ResponseEntity<BookingDTO> updateBooking(@PathParam("id") Long id, @RequestBody Booking booking) {
        return new ResponseEntity<BookingDTO>(this.service.updateBooking(booking, id), HttpStatus.ACCEPTED);
    }

}