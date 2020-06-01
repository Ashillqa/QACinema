package com.qa.test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.dto.BookingDTO;
import com.qa.domain.Booking;
import com.qa.controller.BookingController;
import com.qa.service.BookingService;

@RunWith(MockitoJUnitRunner.class)
public class BookingControllerUnitTest {

    @InjectMocks
    private BookingController controller;

    @Mock
    private BookingService service;

    private List<Booking> bookingList;

    private Booking testBooking;

    private Booking testBookingWithID;

    private BookingDTO bookingDTO;

    final long id = 1L;

    private ModelMapper mapper = new ModelMapper();


    private BookingDTO mapToDTO(Booking booking) {
        return this.mapper.map(booking, BookingDTO.class);
    }


    @Before
    public void init() {
        this.bookingList = new ArrayList<>();
        this.testBooking = new Booking(1L, "Shrek 3", "27/05/2020 15:30", BigDecimal.valueOf(13.99),"email@email.com","0044 771234123","Jeff Tester",1,1,0);
        this.bookingList.add(testBooking);
        this.testBookingWithID = new Booking(testBooking.getMovieName(),testBooking.getDateTime(),testBooking.getTotalPrice(),testBooking.getEmailAddress(),testBooking.getPhoneNumber(),testBooking.getCustomerName(),testBooking.getAdultNr(),testBooking.getChildNr(),testBooking.getStudentNr());
        this.testBookingWithID.setId(id);
        this.bookingDTO = this.mapToDTO(testBookingWithID);
    }

    @Test
    public void createBookingTest() {
        when(this.service.createBooking(testBooking)).thenReturn(this.bookingDTO);

        assertEquals(new ResponseEntity<BookingDTO>(this.bookingDTO, HttpStatus.CREATED), this.controller.createBooking(testBooking));

        verify(this.service, times(1)).createBooking(this.testBooking);
    }

    @Test
    public void deleteBookingTest() {
        this.controller.deleteBooking(id);

        verify(this.service, times(1)).deleteBooking(id);
    }

    @Test
    public void findBookingByIDTest() {
        when(this.service.findBookingByID(this.id)).thenReturn(this.bookingDTO);

        assertEquals(new ResponseEntity<BookingDTO>(this.bookingDTO, HttpStatus.OK), this.controller.getBooking(this.id));

        verify(this.service, times(1)).findBookingByID(this.id);
    }

    @Test
    public void getAllBookingsTest() {

        when(service.readBookings()).thenReturn(this.bookingList.stream().map(this::mapToDTO).collect(Collectors.toList()));

        assertFalse("Controller has found no bookings", this.controller.getAllBookings().getBody().isEmpty());

        verify(service, times(1)).readBookings();
    }

    @Test
    public void updateBookingsTest() {
        // given
        Booking newBooking = new Booking(testBookingWithID.getId(), "Shrek 3", "28/05/2020 15:30", BigDecimal.valueOf(11.99),"email@email.com","0044 134512312","Jeff Tester",1,2,0);
        Booking updatedBooking = new Booking(testBooking.getMovieName(),testBooking.getDateTime(),testBooking.getTotalPrice(),testBooking.getEmailAddress(),testBooking.getPhoneNumber(),testBooking.getCustomerName(),testBooking.getAdultNr(),testBooking.getChildNr(),testBooking.getStudentNr());
        updatedBooking.setId(this.id);

        when(this.service.updateBooking(newBooking, this.id)).thenReturn(this.mapToDTO(updatedBooking));

        assertEquals(new ResponseEntity<BookingDTO>(this.mapToDTO(updatedBooking), HttpStatus.ACCEPTED), this.controller.updateBooking(this.id, newBooking));

        verify(this.service, times(1)).updateBooking(newBooking, this.id);
    }

}