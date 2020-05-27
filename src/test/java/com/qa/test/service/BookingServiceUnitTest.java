package com.qa.test.service;

import com.qa.domain.Booking;
import com.qa.repo.BookingRepository;
import com.qa.service.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class BookingServiceUnitTest {

    @InjectMocks
    private BookingService service;

    @Mock
    private BookingRepository repo;

    private List<Booking> bookingList;

    private Booking testBooking;

    private Booking testBookingWithID;

    private final long id = 1L;


    @Before
    public void init() {
        this.bookingList = new ArrayList<>();
        this.bookingList.add(testBooking);
        this.testBooking = new Booking(1L, "Shrek 3", "27/05/2020 15:30", BigDecimal.valueOf(13.99),"email@email.com","0044 771234123","Jeff Tester",1,1,0);
        this.testBookingWithID = new Booking(this.id,1L, "Shrek 3", "27/05/2020 15:30", BigDecimal.valueOf(13.99),"email@email.com","0044 771234123","Jeff Tester",1,1,0);
    }

    @Test
    public void createBookingTest() {
        when(this.repo.save(testBooking)).thenReturn(testBookingWithID);
        assertEquals(testBookingWithID, this.service.createBooking(testBooking));
        verify(this.repo, times(1)).save(this.testBooking);
    }

    @Test
    public void deleteBookingTest() {
        when(this.repo.existsById(id)).thenReturn(true, false);
        this.service.deleteBooking(id);
        verify(this.repo, times(1)).deleteById(id);
        verify(this.repo, times(2)).existsById(id);
    }


    @Test
    public void findBookingByIDTest() {
        when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testBookingWithID));
        assertEquals(testBookingWithID, this.service.findBookingById(this.id));
        verify(this.repo, times(1)).findById(this.id);
    }

    @Test
    public void readBookingsTest() {
        when(repo.findAll()).thenReturn(this.bookingList);
        assertFalse("Controller has found no bookings", this.service.readBookings().isEmpty());
        verify(repo, times(1)).findAll();
    }

    @Test
    public void updateBookingsTest() {
        Booking newBooking = new Booking(2L, "Shrek 3", "28/05/2020 15:30", BigDecimal.valueOf(11.99),"email@email.com","0044 134512312","Jeff Tester",1,2,0);
        newBooking.setId(this.id);
        when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testBookingWithID));
        when(this.repo.save(newBooking)).thenReturn(newBooking);
        assertEquals(newBooking, this.service.updateBooking(this.id, newBooking));
        verify(this.repo, times(1)).findById(1L);
        verify(this.repo, times(1)).save(newBooking);
    }

}