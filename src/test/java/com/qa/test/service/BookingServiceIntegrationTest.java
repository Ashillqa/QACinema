package com.qa.test.service;

import com.qa.domain.Booking;
import com.qa.repo.BookingRepository;
import com.qa.service.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingServiceIntegrationTest {

    @Autowired
    private BookingService service;

    @Autowired
    private BookingRepository repo;

    private Booking testBooking;

    @Before
    public void init() {
        this.testBooking = new Booking(1L, "Shrek 3", "27/05/2020 15:30", BigDecimal.valueOf(13.99),"email@email.com","0044 771234123","Jeff Tester",1,1,0);
        this.repo.deleteAll();
        this.testBooking = this.repo.save(this.testBooking);
    }

    @Test
    public void testCreateBooking() {
        assertEquals(this.testBooking, this.service.createBooking(testBooking));
    }

    @Test
    public void testDeleteBooking() {
        assertThat(this.service.deleteBooking(this.testBooking.getId())).isFalse();
    }

    @Test
    public void testFindBookingByID() {
        assertThat(this.service.findBookingById(this.testBooking.getId())).isEqualTo(this.testBooking);
    }

    @Test
    public void testReadBookings() {
        assertThat(this.service.readBookings()).isEqualTo(Stream.of(testBooking).collect(Collectors.toList()));
    }

    @Test
    public void testUpdateBooking() {
        Booking newBooking = new Booking(testBooking.getId(), 1L, "Shrek 3", "28/05/2020 15:30", BigDecimal.valueOf(11.99),"email@email.com","0044 134512312","Jeff Tester",1,2,0);
        assertThat(this.service.updateBooking(this.testBooking.getId(), newBooking)).isEqualTo((newBooking));
    }

}