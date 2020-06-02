package com.qa.test.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.qa.domain.Movie;
import org.junit.Before;
import org.junit.Test;

public class MovieTest {

    private Movie movie;
    private Movie other;

    @Before
    public void setUp() {
        movie = new Movie(1L,1123413L, "Showing", "R");
        other = new Movie(1L,1123413L, "Showing", "R");
    }

    @Test
    public void settersTest() {
        assertNotNull(movie.getId());
        assertNotNull(movie.getStatus());
        assertNotNull(movie.getRating());

        movie.setId(null);
        assertNull(movie.getId());
        movie.setStatus(null);
        assertNull(movie.getStatus());
        movie.setRating(null);
        assertNull(movie.getRating());

    }

    @Test
    public void equalsWithNull() {
        assertFalse(movie.equals(null));
    }

    @Test
    public void equalsWithDifferentObject() {
        assertFalse(movie.equals(new Object()));
    }

    @Test
    public void createMovieWithId() {
        assertEquals(1L, movie.getId(), 0);
        assertEquals("Showing", movie.getStatus());
        assertEquals("R", movie.getRating());
    }

    @Test
    public void checkEquality() {
        assertTrue(movie.equals(movie));
    }

    @Test
    public void checkEqualityBetweenDifferentObjects() {
        assertTrue(movie.equals(other));
    }

    @Test
    public void movieNameNullButOtherNameNotNull() {
        movie.setStatus(null);
        assertFalse(movie.equals(other));
    }

    @Test
    public void movieNamesNotEqual() {
        other.setStatus("featured");
        assertFalse(movie.equals(other));
    }

    @Test
    public void checkEqualityBetweenDifferentObjectsNullName() {
        movie.setStatus(null);
        other.setStatus(null);
        assertTrue(movie.equals(other));
    }

    @Test
    public void nullId() {
        movie.setId(null);
        assertFalse(movie.equals(other));
    }

    @Test
    public void nullIdOnBoth() {
        movie.setId(null);
        other.setId(null);
        assertTrue(movie.equals(other));
    }

    @Test
    public void otherIdDifferent() {
        other.setId(2L);
        assertFalse(movie.equals(other));
    }

    @Test
    public void constructorWithoutId() {
        Movie movie = new Movie(129838L,"Showing","R");
        assertNull(movie.getId());
        assertNotNull(movie.getStatus());
        assertNotNull(movie.getRating());
    }

    @Test
    public void hashCodeTest() {
        assertEquals(movie.hashCode(), other.hashCode());
    }

    @Test
    public void hashCodeTestWithNull() {
        Movie movie = new Movie(null,null,null);
        Movie other = new Movie(null,null,null);
        assertEquals(movie.hashCode(), other.hashCode());
    }

}
