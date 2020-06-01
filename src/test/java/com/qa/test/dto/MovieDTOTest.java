package com.qa.test.dto;

import com.qa.dto.MovieDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieDTOTest {

    private MovieDTO movieDTO;
    private MovieDTO other;

    @Before
    public void setUp() {
        movieDTO = new MovieDTO(1L,"Showing", 1123413L, "R");
        other = new MovieDTO(1L,"Showing", 1123413L, "R");
    }

    @Test
    public void settersTest() {
        assertNotNull(movieDTO.getId());
        assertNotNull(movieDTO.getStatus());
        assertNotNull(movieDTO.getRating());

        movieDTO.setId(null);
        assertNull(movieDTO.getId());
        movieDTO.setStatus(null);
        assertNull(movieDTO.getStatus());
        movieDTO.setRating(null);
        assertNull(movieDTO.getRating());;


    }

    @Test
    public void equalsWithNull() {
        assertNotEquals(null, movieDTO);
    }

    @Test
    public void equalsWithDifferentObject() {
        assertNotEquals(movieDTO, new Object());
    }

    @Test
    public void createMovieDTOWithId() {
        assertEquals(1L, movieDTO.getId(), 0);
        assertEquals("Showing", movieDTO.getStatus());
        assertEquals("R", movieDTO.getRating());
    }

    @Test
    public void checkEquality() {
        assertEquals(movieDTO, movieDTO);
    }

    @Test
    public void checkEqualityBetweenDifferentObjects() {
        assertEquals(movieDTO, other);
    }

    @Test
    public void movieDTONameNullButOtherNameNotNull() {
        movieDTO.setStatus(null);
        assertNotEquals(movieDTO, other);
    }

    @Test
    public void movieDTONamesNotEqual() {
        other.setStatus("featured");
        assertNotEquals(movieDTO, other);
    }

    @Test
    public void checkEqualityBetweenDifferentObjectsNullName() {
        movieDTO.setStatus(null);
        other.setStatus(null);
        assertEquals(movieDTO, other);
    }

    @Test
    public void nullId() {
        movieDTO.setId(null);
        assertNotEquals(movieDTO, other);
    }

    @Test
    public void nullIdOnBoth() {
        movieDTO.setId(null);
        other.setId(null);
        assertEquals(movieDTO, other);
    }

    @Test
    public void otherIdDifferent() {
        other.setId(2L);
        assertNotEquals(movieDTO, other);
    }

    @Test
    public void constructorWithoutId() {
        MovieDTO movieDTO = new MovieDTO("Showing", 1213413L, "R");
        assertNull(movieDTO.getId());
        assertNotNull(movieDTO.getStatus());
        assertNotNull(movieDTO.getApiID());
    }

    @Test
    public void hashCodeTest() {
        assertEquals(movieDTO.hashCode(), other.hashCode());
    }

    @Test
    public void hashCodeTestWithNull() {
        MovieDTO movieDTO = new MovieDTO(null,null, null);
        MovieDTO other = new MovieDTO(null,null,null);
        assertEquals(movieDTO.hashCode(), other.hashCode());
    }

}
