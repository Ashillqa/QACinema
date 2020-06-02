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

////////////////////ID////////////////////////////////////
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
////////////////////CUSTOMERNAME//////////////////////////////////////////////////
    @Test
    public void nullCustomerName() {
        bookingDTO.setCustomerName(null);
        assertFalse(bookingDTO.equals(other));
    }

    @Test
    public void nullCustomerNameOnBoth() {
        bookingDTO.setCustomerName(null);
        other.setCustomerName(null);
        assertTrue(bookingDTO.equals(other));
    }

    @Test
    public void otherCustomerNameDifferent() {
        other.setCustomerName("Bob");
        assertFalse(bookingDTO.equals(other));
    }
////////////////////DATETIME/////////////////////////////////////////////////////
    @Test
    public void nullDateTime() {
        bookingDTO.setDateTime(null);
        assertFalse(bookingDTO.equals(other));
    }

    @Test
    public void nullDateTimeOnBoth() {
        bookingDTO.setDateTime(null);
        other.setDateTime(null);
        assertTrue(bookingDTO.equals(other));
    }

    @Test
    public void otherDateTimeDifferent() {
        other.setDateTime("29/05/2020 15:30");
        assertFalse(bookingDTO.equals(other));
    }
///////////////////EMAILADDRESS/////////////////////////////////////////////////
    @Test
    public void nullEmailAddress() {
        bookingDTO.setEmailAddress(null);
        assertFalse(bookingDTO.equals(other));
    }

    @Test
    public void nullEmailAddressOnBoth() {
        bookingDTO.setEmailAddress(null);
        other.setEmailAddress(null);
        assertTrue(bookingDTO.equals(other));
    }

    @Test
    public void otherEmailAddressDifferent() {
        other.setEmailAddress("different@email.com");
        assertFalse(bookingDTO.equals(other));
    }
///////////////////MOVIENAME/////////////////////////////////////////////////
    @Test
    public void nullMovieName() {
        bookingDTO.setMovieName(null);
        assertFalse(bookingDTO.equals(other));
    }

    @Test
    public void nullMovieNameOnBoth() {
        bookingDTO.setMovieName(null);
        other.setMovieName(null);
        assertTrue(bookingDTO.equals(other));
    }

    @Test
    public void otherMovieNameDifferent() {
        other.setMovieName("Spongebob");
        assertFalse(bookingDTO.equals(other));
    }
///////////////////PHONENUMBER/////////////////////////////////////////////////
    @Test
    public void nullPhoneNumber() {
        bookingDTO.setPhoneNumber(null);
        assertFalse(bookingDTO.equals(other));
    }

    @Test
    public void nullPhoneNumberOnBoth() {
        bookingDTO.setPhoneNumber(null);
        other.setPhoneNumber(null);
        assertTrue(bookingDTO.equals(other));
    }

    @Test
    public void otherPhoneNumberDifferent() {
        other.setPhoneNumber("0044 771234127");
        assertFalse(bookingDTO.equals(other));
    }
///////////////////CHILDNR/////////////////////////////////////////////////
    @Test
    public void nullChildNr() {
        bookingDTO.setChildNr(null);
        assertFalse(bookingDTO.equals(other));
    }

    @Test
    public void nullChildNrOnBoth() {
        bookingDTO.setChildNr(null);
        other.setChildNr(null);
        assertTrue(bookingDTO.equals(other));
    }

    @Test
    public void otherChildNrDifferent() {
        other.setChildNr(2);
        assertFalse(bookingDTO.equals(other));
    }
///////////////////ADULTNR/////////////////////////////////////////////////
    @Test
    public void nullAdultNr() {
        bookingDTO.setAdultNr(null);
        assertFalse(bookingDTO.equals(other));
    }

    @Test
    public void nullAdultNrOnBoth() {
        bookingDTO.setAdultNr(null);
        other.setAdultNr(null);
        assertTrue(bookingDTO.equals(other));
    }

    @Test
    public void otherAdultNrDifferent() {
        other.setAdultNr(2);
        assertFalse(bookingDTO.equals(other));
    }
///////////////////STUDENTNR///////////////////////////////////////////////// 
    @Test
    public void nullStudentNr() {
        bookingDTO.setStudentNr(null);
        assertFalse(bookingDTO.equals(other));
    }

    @Test
    public void nullStudentNrOnBoth() {
        bookingDTO.setStudentNr(null);
        other.setStudentNr(null);
        assertTrue(bookingDTO.equals(other));
    }

    @Test
    public void otherStudentNrDifferent() {
        other.setStudentNr(2);
        assertFalse(bookingDTO.equals(other));
    }
///////////////////GETTOTAL/////////////////////////////////////////////////  
    @Test
    public void nullTotalPrice() {
        bookingDTO.setTotalPrice(null);
        assertFalse(bookingDTO.equals(other));
    }

    @Test
    public void nullTotalPriceOnBoth() {
        bookingDTO.setTotalPrice(null);
        other.setTotalPrice(null);
        assertTrue(bookingDTO.equals(other));
    }

    @Test
    public void otherTotalPriceDifferent() {
        other.setTotalPrice(BigDecimal.valueOf(14.99));
        assertFalse(bookingDTO.equals(other));
    }
///////////////////////////////////////////////////////////////////////////

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
