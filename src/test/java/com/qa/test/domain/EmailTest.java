package com.qa.test.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;



import org.junit.Before;
import org.junit.Test;


import com.qa.domain.Email;

public class EmailTest {
	
	private Email email;
	private Email other;
	
	@Before
    public void setUp() {
		email = new Email(1L,"User","email@email.com","TestSubject","TestBody");
		other = new Email(1L,"User","email@email.com","TestSubject","TestBody");
	}
	
	 @Test
	    public void settersTest() {
	        assertNotNull(email.getId());
	        assertNotNull(email.getUsername());
	        assertNotNull(email.getEmail());
	        assertNotNull(email.getSubject());
	        assertNotNull(email.getBody());
	        
	        email.setId(null);
	        assertNull(email.getId());
	        email.setUsername(null);
	        assertNull(email.getUsername());
	        email.setEmail(null);
	        assertNull(email.getEmail());
	        email.setSubject(null);
	        assertNull(email.getSubject());
	        email.setBody(null);
	        assertNull(email.getBody());

	    }
	 
	 
	 @Test
	    public void equalsWithDifferentObject() {
	        assertFalse(email.equals(new Object()));
	    }

	    @Test
	    public void createEmailWithId() {
	        assertEquals(1L, email.getId(), 0);
	        assertEquals("User", email.getUsername());
	        assertEquals("email@email.com", email.getEmail());
	        assertEquals("TestSubject", email.getSubject());
	        assertEquals("TestBody", email.getBody());
	    }

	    @Test
	    public void checkEquality() {
	        assertTrue(email.equals(email));
	    }

	    @Test
	    public void checkEqualityBetweenDifferentObjects() {
	        assertTrue(email.equals(other));
	    }
	    
	    
	    //////////////////////////ID//////////////////////////////////////
	    @Test
	    public void nullId() {
	        email.setId(null);
	        assertFalse(email.equals(other));
	    }

	    @Test
	    public void nullIdOnBoth() {
	        email.setId(null);
	        other.setId(null);
	        assertTrue(email.equals(other));
	    }

	    @Test
	    public void otherIdDifferent() {
	        other.setId(2L);
	        assertFalse(email.equals(other));
	    }
	    ///////////////////////////USERNAME/////////////////////////////////////
	    @Test
	    public void nullUsername() {
	        email.setUsername(null);
	        assertFalse(email.equals(other));
	    }

	    @Test
	    public void nullUsernameOnBoth() {
	        email.setUsername(null);
	        other.setUsername(null);
	        assertTrue(email.equals(other));
	    }

	    @Test
	    public void otherUsernameDifferent() {
	        other.setUsername("User2");
	        assertFalse(email.equals(other));
	    }
	    //////////////////////////EMAIL////////////////////////////////////////
	    @Test
	    public void nullEmail() {
	        email.setEmail(null);
	        assertFalse(email.equals(other));
	    }

	    @Test
	    public void nulEmailOnBoth() {
	        email.setEmail(null);
	        other.setEmail(null);
	        assertTrue(email.equals(other));
	    }

	    @Test
	    public void otherEmailDifferent() {
	        other.setEmail("email@different.com");
	        assertFalse(email.equals(other));
	    }
	    /////////////////////////SUBJECT//////////////////////////////////////
	    @Test
	    public void nullSubject() {
	        email.setSubject(null);
	        assertFalse(email.equals(other));
	    }

	    @Test
	    public void nullSubjectOnBoth() {
	        email.setSubject(null);
	        other.setSubject(null);
	        assertTrue(email.equals(other));
	    }

	    @Test
	    public void otherSubjectDifferent() {
	        other.setSubject("Subject2");
	        assertFalse(email.equals(other));
	    }
	    /////////////////////////BODY/////////////////////////////////////////
	    @Test
	    public void nullBody() {
	        email.setBody(null);
	        assertFalse(email.equals(other));
	    }

	    @Test
	    public void nullBodyOnBoth() {
	        email.setBody(null);
	        other.setBody(null);
	        assertTrue(email.equals(other));
	    }

	    @Test
	    public void otherBodyDifferent() {
	        other.setBody("Different Body");
	        assertFalse(email.equals(other));
	    }
	    //////////////////////////////////////////////////////////////////////////////
	    
	    @Test
	    public void constructorWithoutId() {
	        Email email = new Email("User","email@email.com","subject","body");
	        assertNull(email.getId());
	        assertEquals("User", email.getUsername());
	        assertEquals("subject", email.getSubject());
	        assertEquals("body", email.getBody());
	    }
	    
	    @Test
	    public void hashCodeTest() {
	        assertEquals(email.hashCode(), other.hashCode());
	    }
	    
	    @Test
	    public void hashCodeTestWithNull() {
	        Email email = new Email(null, null,null,null,null);
	        Email other = new Email(null, null,null,null,null);
	        assertEquals(email.hashCode(), other.hashCode());
	    }


}
