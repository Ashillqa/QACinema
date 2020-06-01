package com.qa.test.dto;

import com.qa.dto.BookingDTO;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookingDTOTest {

    private BookingDTO bookingDTO;
    private BookingDTO other;

    @Before
    public void setUp() {
        bookingDTO = new BookingDTO(1L, "Shrek 3", "27/05/2020 15:30", BigDecimal.valueOf(13.99),"email@email.com","0044 771234123","Jeff Tester",1,1,0);
        other = new BookingDTO(1L, "Shrek 3", "27/05/2020 15:30", BigDecimal.valueOf(13.99),"email@email.com","0044 771234123","Jeff Tester",1,1,0);
    }

    @Test
    public void settersTest() {
        assertNotNull(bookingDTO.getId());
        assertNotNull(bookingDTO.getAdultNr());
        assertNotNull(bookingDTO.getChildNr());
        assertNotNull(bookingDTO.getDateTime());
        assertNotNull(bookingDTO.getEmailAddress());
        assertNotNull(bookingDTO.getMovieName());
        assertNotNull(bookingDTO.getPhoneNumber());
        assertNotNull(bookingDTO.getStudentNr());
        assertNotNull(bookingDTO.getTotalPrice());

        bookingDTO.setId(null);
        assertNull(bookingDTO.getId());
        bookingDTO.setAdultNr(null);
        assertNull(bookingDTO.getAdultNr());
        bookingDTO.setChildNr(null);
        assertNull(bookingDTO.getChildNr());
        bookingDTO.setDateTime(null);
        assertNull(bookingDTO.getDateTime());
        bookingDTO.setEmailAddress(null);
        assertNull(bookingDTO.getEmailAddress());
        bookingDTO.setMovieName(null);
        assertNull(bookingDTO.getMovieName());
        bookingDTO.setPhoneNumber(null);
        assertNull(bookingDTO.getPhoneNumber());
        bookingDTO.setStudentNr(null);
        assertNull(bookingDTO.getStudentNr());
        bookingDTO.setTotalPrice(null);
        assertNull(bookingDTO.getTotalPrice());

    }

    @Test
    public void equalsWithNull() {
        assertFalse(bookingDTO.equals(null));
    }

    @Test
    public void equalsWithDifferentObject() {
        assertFalse(bookingDTO.equals(new Object()));
    }

    @Test
    public void createBookingDTOWithId() {
        assertEquals(1L, bookingDTO.getId(), 0);
        assertEquals("Jeff Tester", bookingDTO.getCustomerName());
        assertEquals(1, bookingDTO.getAdultNr(), 0);
        assertEquals("27/05/2020 15:30", bookingDTO.getDateTime());
        assertEquals("email@email.com", bookingDTO.getEmailAddress());
        assertEquals("Shrek 3", bookingDTO.getMovieName());
        assertEquals("0044 771234123", bookingDTO.getPhoneNumber());
        assertEquals(1, bookingDTO.getChildNr(), 0);
        assertEquals(0, bookingDTO.getStudentNr(),0);
        assertEquals(BigDecimal.valueOf(13.99), bookingDTO.getTotalPrice());
    }

    @Test
    public void checkEquality() {
        assertTrue(bookingDTO.equals(bookingDTO));
    }

    @Test
    public void checkEqualityBetweenDifferentObjects() {
        assertTrue(bookingDTO.equals(other));
    }


    @Test
    public void nullId() {
        bookingDTO.setId(null);
        assertFalse(bookingDTO.equals(other));
    }

    @Test
    public void nullIdOnBoth() {
        bookingDTO.setId(null);
        other.setId(null);
        assertTrue(bookingDTO.equals(other));
    }

    @Test
    public void otherIdDifferent() {
        other.setId(2L);
        assertFalse(bookingDTO.equals(other));
    }


    @Test
    public void constructorWithoutId() {
        BookingDTO bookingDTO = new BookingDTO("Shrek 3", "27/05/2020 15:30", BigDecimal.valueOf(13.99),"email@email.com","0044 771234123","Jeff Tester",1,1,0);
        assertNull(bookingDTO.getId());
        assertEquals("Jeff Tester", bookingDTO.getCustomerName());
        assertEquals(1, bookingDTO.getAdultNr(), 0);
        assertEquals("27/05/2020 15:30", bookingDTO.getDateTime());
        assertEquals("email@email.com", bookingDTO.getEmailAddress());
        assertEquals("Shrek 3", bookingDTO.getMovieName());
        assertEquals("0044 771234123", bookingDTO.getPhoneNumber());
        assertEquals(1, bookingDTO.getChildNr(), 0);
        assertEquals(0, bookingDTO.getStudentNr(),0);
        assertEquals(BigDecimal.valueOf(13.99), bookingDTO.getTotalPrice());
    }

    @Test
    public void hashCodeTest() {
        assertEquals(bookingDTO.hashCode(), other.hashCode());
    }

    @Test
    public void hashCodeTestWithNull() {
        BookingDTO bookingDTO = new BookingDTO(null, null,null,null,null,null,null,null,null,null);
        BookingDTO other = new BookingDTO(null, null,null,null,null,null,null,null,null,null);
        assertEquals(bookingDTO.hashCode(), other.hashCode());
    }

}
