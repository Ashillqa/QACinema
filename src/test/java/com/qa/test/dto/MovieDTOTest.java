package com.qa.test.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.qa.dto.MovieDTO;
import org.junit.Before;
import org.junit.Test;

public class MovieDTOTest {

    private MovieDTO movieDTO;
    private MovieDTO other;

    @Before
    public void setUp() {
        movieDTO = new MovieDTO(1L, "Showing");
        other = new MovieDTO(1L, "Showing");
    }

    @Test
    public void settersTest() {
        assertNotNull(movieDTO.getId());
        assertNotNull(movieDTO.getStatus());

        movieDTO.setId(null);
        assertNull(movieDTO.getId());
        movieDTO.setStatus(null);
        assertNull(movieDTO.getStatus());

    }

    @Test
    public void equalsWithNull() {
        assertFalse(movieDTO.equals(null));
    }

    @Test
    public void equalsWithDifferentObject() {
        assertFalse(movieDTO.equals(new Object()));
    }

    @Test
    public void createMovieDTOWithId() {
        assertEquals(1L, movieDTO.getId(), 0);
        assertEquals("Showing", movieDTO.getStatus());
    }

    @Test
    public void checkEquality() {
        assertTrue(movieDTO.equals(movieDTO));
    }

    @Test
    public void checkEqualityBetweenDifferentObjects() {
        assertTrue(movieDTO.equals(other));
    }

    @Test
    public void movieDTONameNullButOtherNameNotNull() {
        movieDTO.setStatus(null);
        assertFalse(movieDTO.equals(other));
    }

    @Test
    public void movieDTONamesNotEqual() {
        other.setStatus("featured");
        assertFalse(movieDTO.equals(other));
    }

    @Test
    public void checkEqualityBetweenDifferentObjectsNullName() {
        movieDTO.setStatus(null);
        other.setStatus(null);
        assertTrue(movieDTO.equals(other));
    }

    @Test
    public void nullId() {
        movieDTO.setId(null);
        assertFalse(movieDTO.equals(other));
    }

    @Test
    public void nullIdOnBoth() {
        movieDTO.setId(null);
        other.setId(null);
        assertTrue(movieDTO.equals(other));
    }

    @Test
    public void otherIdDifferent() {
        other.setId(2L);
        assertFalse(movieDTO.equals(other));
    }

    @Test
    public void constructorWithoutId() {
        MovieDTO movieDTO = new MovieDTO("Showing");
        assertNull(movieDTO.getId());
        assertNotNull(movieDTO.getStatus());
    }

    @Test
    public void hashCodeTest() {
        assertEquals(movieDTO.hashCode(), other.hashCode());
    }

    @Test
    public void hashCodeTestWithNull() {
        MovieDTO movieDTO = new MovieDTO(null);
        MovieDTO other = new MovieDTO(null);
        assertEquals(movieDTO.hashCode(), other.hashCode());
    }

}
