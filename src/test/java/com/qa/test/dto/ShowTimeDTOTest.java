package com.qa.test.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.qa.dto.ShowTimeDTO;
import org.junit.Before;
import org.junit.Test;

public class ShowTimeDTOTest {

    private ShowTimeDTO showTimeDTO;
    private ShowTimeDTO other;

    @Before
    public void setUp() {
        showTimeDTO = new ShowTimeDTO(1L, "27/04/2020 13:30");
        other = new ShowTimeDTO(1L, "27/04/2020 13:30");
    }

    @Test
    public void settersTest() {
        assertNotNull(showTimeDTO.getId());
        assertNotNull(showTimeDTO.getTime());

        showTimeDTO.setId(null);
        assertNull(showTimeDTO.getId());
        showTimeDTO.setTime(null);
        assertNull(showTimeDTO.getTime());

    }

    @Test
    public void equalsWithNull() {
        assertFalse(showTimeDTO.equals(null));
    }

    @Test
    public void equalsWithDifferentObject() {
        assertFalse(showTimeDTO.equals(new Object()));
    }

    @Test
    public void createShowTimeDTOWithId() {
        assertEquals(1L, showTimeDTO.getId(), 0);
        assertEquals("27/04/2020 13:30", showTimeDTO.getTime());
    }

    @Test
    public void checkEquality() {
        assertTrue(showTimeDTO.equals(showTimeDTO));
    }

    @Test
    public void checkEqualityBetweenDifferentObjects() {
        assertTrue(showTimeDTO.equals(other));
    }

    @Test
    public void showTimeDTOTimeNullButOtherNameNotNull() {
        showTimeDTO.setTime(null);
        assertFalse(showTimeDTO.equals(other));
    }

    @Test
    public void showTimeDTOTimesNotEqual() {
        other.setTime("27/04/2020 14:30");
        assertFalse(showTimeDTO.equals(other));
    }

    @Test
    public void checkEqualityBetweenDifferentObjectsNullTimes() {
        showTimeDTO.setTime(null);
        other.setTime(null);
        assertTrue(showTimeDTO.equals(other));
    }

    @Test
    public void nullId() {
        showTimeDTO.setId(null);
        assertFalse(showTimeDTO.equals(other));
    }

    @Test
    public void nullIdOnBoth() {
        showTimeDTO.setId(null);
        other.setId(null);
        assertTrue(showTimeDTO.equals(other));
    }

    @Test
    public void otherIdDifferent() {
        other.setId(2L);
        assertFalse(showTimeDTO.equals(other));
    }

    @Test
    public void constructorWithoutId() {
        ShowTimeDTO showTimeDTO = new ShowTimeDTO("27/04/2020 14:30");
        assertNull(showTimeDTO.getId());
        assertNotNull(showTimeDTO.getTime());
    }

    @Test
    public void hashCodeTest() {
        assertEquals(showTimeDTO.hashCode(), other.hashCode());
    }

    @Test
    public void hashCodeTestWithNull() {
        ShowTimeDTO showTimeDTO = new ShowTimeDTO(null);
        ShowTimeDTO other = new ShowTimeDTO(null);
        assertEquals(showTimeDTO.hashCode(), other.hashCode());
    }

}
