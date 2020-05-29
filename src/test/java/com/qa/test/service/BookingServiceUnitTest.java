package com.qa.booking.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.dto.BookingDTO;
import com.qa.domain.Booking;
import com.qa.repo.BookingRepository;
import com.qa.service.BookingService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingServiceUnitTest {

    @Autowired
    private BookingService service;

    @Autowired
    private BookingRepository repo;

    private Booking testBooking;

    private Booking testBookingWithID;

    @Autowired
    private ModelMapper mapper;

    private BookingDTO mapToDTO(Booking booking) {
        return this.mapper.map(booking, BookingDTO.class);
    }

    @Before
    public void init() {
        this.testBooking = new Booking(1L, "Shrek 3", "27/05/2020 15:30", BigDecimal.valueOf(13.99),"email@email.com","0044 771234123","Jeff Tester",1,1,0);

        this.repo.deleteAll();
        long id = 1L;
        this.testBooking.setId(id);
        this.testBookingWithID = this.repo.save(this.testBooking);
    }

    @Test
    public void testCreateBooking() {
        assertEquals(this.mapToDTO(this.testBookingWithID), this.service.createBooking(testBooking));
    }

    @Test
    public void testDeleteBooking() {
        assertThat(this.service.deleteBooking(this.testBookingWithID.getId())).isFalse();
    }

    @Test
    public void testFindBookingByID() {
        assertThat(this.service.findBookingByID(this.testBookingWithID.getId())).isEqualTo(this.mapToDTO(this.testBookingWithID));
    }

    @Test
    public void testReadBookings() {
        assertThat(this.service.readBookings()).isEqualTo(Stream.of(this.mapToDTO(testBookingWithID)).collect(Collectors.toList()));
    }

    @Test
    public void testUpdateBooking() {
        Booking newBooking = new Booking(testBookingWithID.getId(), "Shrek 3", "28/05/2020 15:30", BigDecimal.valueOf(11.99),"email@email.com","0044 134512312","Jeff Tester",1,2,0);
        Booking updatedBooking = new Booking(newBooking.getMovieName(),newBooking.getDateTime(),newBooking.getTotalPrice(),newBooking.getEmailAddress(),newBooking.getPhoneNumber(),newBooking.getCustomerName(),newBooking.getAdultNr(),newBooking.getChildNr(),newBooking.getStudentNr());
        updatedBooking.setId(this.testBookingWithID.getId());

        assertThat(this.service.updateBooking(newBooking, this.testBookingWithID.getId())).isEqualTo(this.mapToDTO(updatedBooking));
    }

}