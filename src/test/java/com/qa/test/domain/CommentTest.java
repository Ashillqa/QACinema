package com.qa.test.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.qa.domain.Comment;
import org.junit.Before;
import org.junit.Test;

public class CommentTest {

    private Comment comment;
    private Comment other;

    @Before
    public void setUp() {
        comment = new Comment(1L, "Tester One", 3L, "was Alright");
        other = new Comment(1L, "Tester One", 3L, "was Alright");
    }

    @Test
    public void settersTest() {
        assertNotNull(comment.getId());
        assertNotNull(comment.getUserName());
        assertNotNull(comment.getComment());
        assertNotNull(comment.getRating());

        comment.setId(null);
        assertNull(comment.getId());
        comment.setUserName(null);
        assertNull(comment.getUserName());
        comment.setRating(null);
        assertNull(comment.getRating());
        comment.setComment(null);
        assertNull(comment.getComment());

    }

    @Test
    public void equalsWithNull() {
        assertFalse(comment.equals(null));
    }

    @Test
    public void equalsWithDifferentObject() {
        assertFalse(comment.equals(new Object()));
    }

    @Test
    public void createCommentWithId() {
        assertEquals(1L, comment.getId(), 0);
        assertEquals("Tester One", comment.getUserName());
        assertEquals(3L, comment.getRating(), 0);
        assertEquals("was Alright", comment.getComment());
    }

    @Test
    public void checkEquality() {
        assertTrue(comment.equals(comment));
    }

    @Test
    public void checkEqualityBetweenDifferentObjects() {
        assertTrue(comment.equals(other));
    }

    @Test
    public void commentNameNullButOtherNameNotNull() {
        comment.setUserName(null);
        assertFalse(comment.equals(other));
    }

    @Test
    public void commentNamesNotEqual() {
        other.setUserName("Not the Tester");
        assertFalse(comment.equals(other));
    }

    @Test
    public void checkEqualityBetweenDifferentObjectsNullName() {
        comment.setUserName(null);
        other.setUserName(null);
        assertTrue(comment.equals(other));
    }

    @Test
    public void nullId() {
        comment.setId(null);
        assertFalse(comment.equals(other));
    }

    @Test
    public void nullIdOnBoth() {
        comment.setId(null);
        other.setId(null);
        assertTrue(comment.equals(other));
    }

    @Test
    public void otherIdDifferent() {
        other.setId(2L);
        assertFalse(comment.equals(other));
    }

    @Test
    public void nullComment() {
        comment.setComment(null);
        assertFalse(comment.equals(other));
    }

    @Test
    public void nullCommentOnBoth() {
        comment.setComment(null);
        other.setComment(null);
        assertTrue(comment.equals(other));
    }

    @Test
    public void otherCommentDifferent() {
        other.setComment("I have a different opinion");
        assertFalse(comment.equals(other));
    }

    @Test
    public void nullRating() {
        comment.setRating(null);
        assertFalse(comment.equals(other));
    }

    @Test
    public void nullRatingOnBoth() {
        comment.setRating(null);
        other.setRating(null);
        assertTrue(comment.equals(other));
    }

    @Test
    public void otherRatingDifferent() {
        other.setRating(1L);
        assertFalse(comment.equals(other));
    }

    @Test
    public void constructorWithoutId() {
        Comment comment = new Comment("Tester One", 3L, "was Alright");
        assertNull(comment.getId());
        assertNotNull(comment.getComment());
        assertNotNull(comment.getRating());
        assertNotNull(comment.getUserName());
    }

    @Test
    public void hashCodeTest() {
        assertEquals(comment.hashCode(), other.hashCode());
    }

    @Test
    public void hashCodeTestWithNull() {
        Comment comment = new Comment(null, null,null,null);
        Comment other = new Comment(null, null,null,null);
        assertEquals(comment.hashCode(), other.hashCode());
    }

}
