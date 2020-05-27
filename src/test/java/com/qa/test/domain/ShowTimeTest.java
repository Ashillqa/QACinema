package com.qa.test.domain;

import com.qa.domain.ShowTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
        assertNotEquals(null, showTime);
    }

    @Test
    public void equalsWithDifferentObject() {
        assertNotEquals(showTime, new Object());
    }

    @Test
    public void createShowTimeWithId() {
        assertEquals(1L, showTime.getId(), 0);
        assertEquals("27/04/2020 13:30", showTime.getTime());
    }

    @Test
    public void checkEquality() {
        assertEquals(showTime, showTime);
    }

    @Test
    public void checkEqualityBetweenDifferentObjects() {
        assertEquals(showTime, other);
    }

    @Test
    public void showTimeTimeNullButOtherNameNotNull() {
        showTime.setTime(null);
        assertNotEquals(showTime, other);
    }

    @Test
    public void showTimeTimesNotEqual() {
        other.setTime("27/04/2020 14:30");
        assertNotEquals(showTime, other);
    }

    @Test
    public void checkEqualityBetweenDifferentObjectsNullTimes() {
        showTime.setTime(null);
        other.setTime(null);
        assertEquals(showTime, other);
    }

    @Test
    public void nullId() {
        showTime.setId(null);
        assertNotEquals(showTime, other);
    }

    @Test
    public void nullIdOnBoth() {
        showTime.setId(null);
        other.setId(null);
        assertEquals(showTime, other);
    }

    @Test
    public void otherIdDifferent() {
        other.setId(2L);
        assertNotEquals(showTime, other);
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
