package com.qa.test.controller;

import com.qa.controller.BookingController;
import com.qa.domain.Booking;
import com.qa.service.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookingControllerUnitTest {

    @InjectMocks
    private BookingController controller;

    @Mock
    private BookingService service;

    private List<Booking> bookingList;

    private Booking testBooking;

    private Booking testBookingWithID;


    final long id = 1L;


    @Before
    public void init() {
        this.bookingList = new ArrayList<>();
        this.testBooking = new Booking(1L, "Shrek 3", "27/05/2020 15:30", BigDecimal.valueOf(13.99),"email@email.com","0044 771234123","Jeff Tester",1,1,0);
        this.bookingList.add(testBooking);
        this.testBookingWithID = new Booking(testBooking.getMovieId(), testBooking.getMovieName(), testBooking.getDateTime(),testBooking.getTotalPrice(),testBooking.getEmailAddress(),testBooking.getPhoneNumber(),testBooking.getCustomerName(),testBooking.getAdultNr(),testBooking.getChildNr(),testBooking.getStudentNr());
        this.testBookingWithID.setId(id);
    }

    @Test
    public void createBookingTest() {
        when(this.service.createBooking(testBooking)).thenReturn(this.testBookingWithID);

        assertEquals(new ResponseEntity<Booking>(this.testBookingWithID, HttpStatus.CREATED), this.controller.createBooking(testBooking));

        verify(this.service, times(1)).createBooking(this.testBooking);
    }

    @Test
    public void deleteBookingTest() {
        this.controller.deleteBooking(id);

        verify(this.service, times(1)).deleteBooking(id);
    }

    @Test
    public void findBookingByIDTest() {
        when(this.service.findBookingById(this.id)).thenReturn(this.testBookingWithID);

        assertEquals(new ResponseEntity<Booking>(this.testBookingWithID, HttpStatus.OK), this.controller.getBookingById(this.id));

        verify(this.service, times(1)).findBookingById(this.id);
    }

    @Test
    public void getAllBookingsTest() {

        when(service.readBookings()).thenReturn(this.bookingList);

        assertFalse("Controller has found no bookings", Objects.requireNonNull(this.controller.getAllBookings().getBody()).isEmpty());

        verify(service, times(1)).readBookings();
    }

    @Test
    public void updateBookingsTest() {
        Booking newBooking = new Booking(2L, "Shrek 4", "26/05/2020 11:30", BigDecimal.valueOf(11.99),"email@email.com","0044 771234123","Jeff Tester",1,3,0);
        Booking updatedBooking = new Booking(testBooking.getMovieId(), testBooking.getMovieName(), testBooking.getDateTime(),testBooking.getTotalPrice(),testBooking.getEmailAddress(),testBooking.getPhoneNumber(),testBooking.getCustomerName(),testBooking.getAdultNr(),testBooking.getChildNr(),testBooking.getStudentNr());
        updatedBooking.setId(this.id);

        when(this.service.updateBooking(this.id, newBooking)).thenReturn(updatedBooking);

        assertEquals(new ResponseEntity<Booking>(updatedBooking, HttpStatus.OK), this.controller.updateBooking(this.id, newBooking));

        verify(this.service, times(1)).updateBooking(this.id, newBooking);
    }

}