package com.qa.test.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.qa.domain.ShowTime;
import org.junit.Before;
import org.junit.Test;

public class ShowTimeTest {

    private ShowTime showTime;
    private ShowTime other;

    @Before
    public void setUp() {
        showTime = new ShowTime(1L, "27/04/2020 13:30");
        other = new ShowTime(1L, "27/04/2020 13:30");
    }

    @Test
    public void settersTest() {
        assertNotNull(showTime.getId());
        assertNotNull(showTime.getTime());

        showTime.setId(null);
        assertNull(showTime.getId());
        showTime.setTime(null);
        assertNull(showTime.getTime());

    }

    @Test
    public void equalsWithNull() {
        assertFalse(showTime.equals(null));
    }

    @Test
    public void equalsWithDifferentObject() {
        assertFalse(showTime.equals(new Object()));
    }

    @Test
    public void createShowTimeWithId() {
        assertEquals(1L, showTime.getId(), 0);
        assertEquals("27/04/2020 13:30", showTime.getTime());
    }

    @Test
    public void checkEquality() {
        assertTrue(showTime.equals(showTime));
    }

    @Test
    public void checkEqualityBetweenDifferentObjects() {
        assertTrue(showTime.equals(other));
    }

    @Test
    public void showTimeTimeNullButOtherNameNotNull() {
        showTime.setTime(null);
        assertFalse(showTime.equals(other));
    }

    @Test
    public void showTimeTimesNotEqual() {
        other.setTime("27/04/2020 14:30");
        assertFalse(showTime.equals(other));
    }

    @Test
    public void checkEqualityBetweenDifferentObjectsNullTimes() {
        showTime.setTime(null);
        other.setTime(null);
        assertTrue(showTime.equals(other));
    }

    @Test
    public void nullId() {
        showTime.setId(null);
        assertFalse(showTime.equals(other));
    }

    @Test
    public void nullIdOnBoth() {
        showTime.setId(null);
        other.setId(null);
        assertTrue(showTime.equals(other));
    }

    @Test
    public void otherIdDifferent() {
        other.setId(2L);
        assertFalse(showTime.equals(other));
    }

    @Test
    public void constructorWithoutId() {
        ShowTime showTime = new ShowTime("27/04/2020 14:30");
        assertNull(showTime.getId());
        assertNotNull(showTime.getTime());
    }

    @Test
    public void hashCodeTest() {
        assertEquals(showTime.hashCode(), other.hashCode());
    }

    @Test
    public void hashCodeTestWithNull() {
        ShowTime showTime = new ShowTime(null);
        ShowTime other = new ShowTime(null);
        assertEquals(showTime.hashCode(), other.hashCode());
    }

}
