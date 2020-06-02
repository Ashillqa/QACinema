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

///////////////////////id////////////////////////////////
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
  ////////////////////ADULTNR////////////////////////////////
    @Test
    public void nullAdultNr() {
        booking.setAdultNr(null);
        assertFalse(booking.equals(other));
    }

    @Test
    public void nullAdultNrOnBoth() {
        booking.setAdultNr(null);
        other.setAdultNr(null);
        assertTrue(booking.equals(other));
    }

    @Test
    public void otherAdultNrDifferent() {
        other.setAdultNr(2);
        assertFalse(booking.equals(other));
    }
    
  ///////////////////CHILDNR/////////////////////////////////
    @Test
    public void nullChildNr() {
        booking.setChildNr(null);
        assertFalse(booking.equals(other));
    }

    @Test
    public void nullChildNrOnBoth() {
        booking.setChildNr(null);
        other.setChildNr(null);
        assertTrue(booking.equals(other));
    }

    @Test
    public void otherChildNrDifferent() {
        other.setChildNr(2);
        assertFalse(booking.equals(other));
    }
  //////////////////DATETIME////////////////////////////////
    @Test
    public void nullDateTime() {
        booking.setDateTime(null);
        assertFalse(booking.equals(other));
    }

    @Test
    public void nullDateTimeOnBoth() {
        booking.setDateTime(null);
        other.setDateTime(null);
        assertTrue(booking.equals(other));
    }

    @Test
    public void otherDateTimeDifferent() {
        other.setDateTime("29/05/2020 15:30");
        assertFalse(booking.equals(other));
    }
  /////////////////STUDENTNR////////////////////////////
    @Test
    public void nullStudentNr() {
        booking.setStudentNr(null);
        assertFalse(booking.equals(other));
    }

    @Test
    public void nullStudentNrOnBoth() {
        booking.setStudentNr(null);
        other.setStudentNr(null);
        assertTrue(booking.equals(other));
    }

    @Test
    public void otherStudentNrDifferent() {
        other.setStudentNr(2);
        assertFalse(booking.equals(other));
    }
   ////////////////EMAIL///////////////////////////
    @Test
    public void nullEmail() {
        booking.setEmailAddress(null);
        assertFalse(booking.equals(other));
    }

    @Test
    public void nullEmailOnBoth() {
        booking.setEmailAddress(null);
        other.setEmailAddress(null);
        assertTrue(booking.equals(other));
    }

    @Test
    public void otherEmailDifferent() {
        other.setEmailAddress("email@gmail.com");
        assertFalse(booking.equals(other));
    }
    /////////////MOVIENAME//////////////////////
    @Test
    public void nullMovieName() {
        booking.setMovieName(null);
        assertFalse(booking.equals(other));
    }

    @Test
    public void nullMovieNameOnBoth() {
        booking.setMovieName(null);
        other.setMovieName(null);
        assertTrue(booking.equals(other));
    }

    @Test
    public void otherMovieNameDifferent() {
        other.setMovieName("Spongebob");
        assertFalse(booking.equals(other));
    }
    //////////////MOVIE////////////////////////
    @Test
    public void nullMovie() {
        booking.setMovie(null);
        assertTrue(booking.equals(other));
    }

    @Test
    public void nullMovieOnBoth() {
        booking.setMovie(null);
        other.setMovie(null);
        assertTrue(booking.equals(other));
    }

    @Test
    public void otherMovieDifferent() {
    	Movie myMovie = new Movie(1L,1L,"coming","R");
        other.setMovie(myMovie);
        assertFalse(booking.equals(other));
    }
    ////////////PHONENUMBER/////////////////////////
    @Test
    public void nullPhoneNumber() {
        booking.setPhoneNumber(null);
        assertFalse(booking.equals(other));
    }

    @Test
    public void nullPhoneNumberOnBoth() {
        booking.setPhoneNumber(null);
        other.setPhoneNumber(null);
        assertTrue(booking.equals(other));
    }

    @Test
    public void otherPhoneNumberDifferent() {
        other.setPhoneNumber("0044 771234127");
        assertFalse(booking.equals(other));
    }
    //////////////TOTALPRICE///////////////////////////
    @Test
    public void nullTotalPrice() {
        booking.setTotalPrice(null);
        assertFalse(booking.equals(other));
    }

    @Test
    public void nullTotalPriceOnBoth() {
        booking.setTotalPrice(null);
        other.setTotalPrice(null);
        assertTrue(booking.equals(other));
    }

    @Test
    public void otherTotalPriceDifferent() {
        other.setTotalPrice(BigDecimal.valueOf(15.99));
        assertFalse(booking.equals(other));
    }
////////////////////////////////////////////////////////////

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
