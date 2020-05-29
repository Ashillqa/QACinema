package com.qa.test.domain;

import com.qa.domain.Booking;
import com.qa.domain.Movie;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookingTest {

    private Booking booking;
    private Booking other;
    private Movie movie = new Movie();

    @Before
    public void setUp() {
        booking = new Booking(1L, "Shrek 3", "27/05/2020 15:30", BigDecimal.valueOf(13.99),"email@email.com","0044 771234123","Jeff Tester",1,1,0);
        other = new Booking(1L, "Shrek 3", "27/05/2020 15:30", BigDecimal.valueOf(13.99),"email@email.com","0044 771234123","Jeff Tester",1,1,0);
    }

    @Test
    public void settersTest() {
        assertNotNull(booking.getId());
        assertNotNull(booking.getAdultNr());
        assertNotNull(booking.getChildNr());
        assertNotNull(booking.getDateTime());
        assertNotNull(booking.getEmailAddress());
        assertNotNull(booking.getMovieName());
        assertNotNull(booking.getPhoneNumber());
        assertNotNull(booking.getStudentNr());
        assertNotNull(booking.getTotalPrice());

        booking.setId(null);
        assertNull(booking.getId());
        booking.setAdultNr(null);
        assertNull(booking.getAdultNr());
        booking.setChildNr(null);
        assertNull(booking.getChildNr());
        booking.setDateTime(null);
        assertNull(booking.getDateTime());
        booking.setEmailAddress(null);
        assertNull(booking.getEmailAddress());
        booking.setMovieName(null);
        assertNull(booking.getMovieName());
        booking.setMovie(null);
        assertNull(booking.getMovie());
        booking.setPhoneNumber(null);
        assertNull(booking.getPhoneNumber());
        booking.setStudentNr(null);
        assertNull(booking.getStudentNr());
        booking.setTotalPrice(null);
        assertNull(booking.getTotalPrice());

    }

    @Test
    public void equalsWithNull() {
        assertFalse(booking.equals(null));
    }

    @Test
    public void equalsWithDifferentObject() {
        assertFalse(booking.equals(new Object()));
    }

    @Test
    public void createBookingWithId() {
        assertEquals(1L, booking.getId(), 0);
        assertEquals("Jeff Tester", booking.getCustomerName());
        assertEquals(1, booking.getAdultNr(), 0);
        assertEquals("27/05/2020 15:30", booking.getDateTime());
        assertEquals("email@email.com", booking.getEmailAddress());
        assertEquals("Shrek 3", booking.getMovieName());
        assertEquals("0044 771234123", booking.getPhoneNumber());
        assertEquals(1, booking.getChildNr(), 0);
        assertEquals(0, booking.getStudentNr(),0);
        assertEquals(BigDecimal.valueOf(13.99), booking.getTotalPrice());
    }

    @Test
    public void checkEquality() {
        assertTrue(booking.equals(booking));
    }

    @Test
    public void checkEqualityBetweenDifferentObjects() {
        assertTrue(booking.equals(other));
    }


    @Test
    public void nullId() {
        booking.setId(null);
        assertFalse(booking.equals(other));
    }

    @Test
    public void nullIdOnBoth() {
        booking.setId(null);
        other.setId(null);
        assertTrue(booking.equals(other));
    }

    @Test
    public void otherIdDifferent() {
        other.setId(2L);
        assertFalse(booking.equals(other));
    }


    @Test
    public void constructorWithoutId() {
        Booking booking = new Booking("Shrek 3", "27/05/2020 15:30", BigDecimal.valueOf(13.99),"email@email.com","0044 771234123","Jeff Tester",1,1,0);
        assertNull(booking.getId());
        assertEquals("Jeff Tester", booking.getCustomerName());
        assertEquals(1, booking.getAdultNr(), 0);
        assertEquals("27/05/2020 15:30", booking.getDateTime());
        assertEquals("email@email.com", booking.getEmailAddress());
        assertEquals("Shrek 3", booking.getMovieName());
        assertEquals("0044 771234123", booking.getPhoneNumber());
        assertEquals(1, booking.getChildNr(), 0);
        assertEquals(0, booking.getStudentNr(),0);
        assertEquals(BigDecimal.valueOf(13.99), booking.getTotalPrice());
    }

    @Test
    public void hashCodeTest() {
        assertEquals(booking.hashCode(), other.hashCode());
    }

    @Test
    public void hashCodeTestWithNull() {
        Booking booking = new Booking(null, null,null,null,null,null,null,null,null,null);
        Booking other = new Booking(null, null,null,null,null,null,null,null,null,null);
        assertEquals(booking.hashCode(), other.hashCode());
    }

}
