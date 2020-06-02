package com.qa.test.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.qa.dto.EmailDTO;

public class EmailDTOTest {
	
	private EmailDTO emailDTO;
	private EmailDTO other;
	
	 	@Before
	    public void setUp() {
		 emailDTO = new EmailDTO(1L,"user","email@email.com","subject","test");
		 other = new EmailDTO(1L,"user","email@email.com","subject","test");
	 }
	 
	 	@Test
	    public void settersTest() {
		 assertNotNull(emailDTO.getId());
		 assertNotNull(emailDTO.getUsername());
		 assertNotNull(emailDTO.getEmail());
		 assertNotNull(emailDTO.getSubject());
		 assertNotNull(emailDTO.getBody());
		 
		 emailDTO.setId(null);
	     assertNull(emailDTO.getId());
	     emailDTO.setUsername(null);
	     assertNull(emailDTO.getUsername());
	     emailDTO.setEmail(null);
	     assertNull(emailDTO.getEmail());
	     emailDTO.setSubject(null);
	     assertNull(emailDTO.getSubject());
	     emailDTO.setBody(null);
	     assertNull(emailDTO.getBody());
	 }
	 
	 @Test
	 public void equalsWithNull() {
	 	assertFalse(emailDTO.equals(null));
	 }

	 @Test
     public void equalsWithDifferentObject() {
        assertFalse(emailDTO.equals(new Object()));
	 }

    @Test
    public void createEmailDTOWithId() {
    	assertEquals(1L, emailDTO.getId(), 0);
        assertEquals("user", emailDTO.getUsername());
        assertEquals("email@email.com", emailDTO.getEmail());
        assertEquals("subject", emailDTO.getSubject());
        assertEquals("test", emailDTO.getBody());
    }
	 	    
   @Test
    public void checkEquality() {
        assertTrue(emailDTO.equals(emailDTO));
    }

    @Test
    public void checkEqualityBetweenDifferentObjects() {
        assertTrue(emailDTO.equals(other));
    }
    
////////////////////ID////////////////////////////////////
    @Test
    public void nullId() {
    	emailDTO.setId(null);
    	assertFalse(emailDTO.equals(other));
    }

    @Test
    public void nullIdOnBoth() {
    	emailDTO.setId(null);
    	other.setId(null);
    	assertTrue(emailDTO.equals(other));
    }

	@Test
	public void otherIdDifferent() {
	other.setId(2L);
	assertFalse(emailDTO.equals(other));
	}
////////////////////USERNAME//////////////////////////////////////////////////
	@Test
	public void nullUsername() {
	emailDTO.setUsername(null);
	assertFalse(emailDTO.equals(other));
	}

	@Test
	public void nullUsernameOnBoth() {
	emailDTO.setUsername(null);
	other.setUsername(null);
	assertTrue(emailDTO.equals(other));
	}

	@Test
	public void otherUsernameDifferent() {
	other.setUsername("Bob");
	assertFalse(emailDTO.equals(other));
	}
////////////////////EMAIL/////////////////////////////////////////////////////
	@Test
	public void nullEmail() {
	emailDTO.setEmail(null);
	assertFalse(emailDTO.equals(other));
	}
	
	@Test
	public void nullEmailOnBoth() {
	emailDTO.setEmail(null);
	other.setEmail(null);
	assertTrue(emailDTO.equals(other));
	}
	
	@Test
	public void otherEmailDifferent() {
	other.setEmail("email@different.com");
	assertFalse(emailDTO.equals(other));
	}
///////////////////SUBJECT/////////////////////////////////////////////////
	@Test
	public void nullSubject() {
	emailDTO.setSubject(null);
	assertFalse(emailDTO.equals(other));
	}
	
	@Test
	public void nullSubjectOnBoth() {
	emailDTO.setSubject(null);
	other.setSubject(null);
	assertTrue(emailDTO.equals(other));
	}
	
	@Test
	public void otherSubjectDifferent() {
	other.setSubject("subject2");
	assertFalse(emailDTO.equals(other));
	}
///////////////////BODY/////////////////////////////////////////////////
	@Test
	public void nullBody() {
	emailDTO.setBody(null);
	assertFalse(emailDTO.equals(other));
	}
	
	@Test
	public void nullBodyOnBoth() {
	emailDTO.setBody(null);
	other.setBody(null);
	assertTrue(emailDTO.equals(other));
	}
	
	@Test
	public void otherBodyDifferent() {
	other.setBody("body2");
	assertFalse(emailDTO.equals(other));
	}
////////////////////////////////////////////////////////////////////////////////////
	
	 @Test
	 public void constructorWithoutId() {
		 EmailDTO emailDTO = new EmailDTO("user","email@email.com","subject","body");
		 assertNull(emailDTO.getId());
	     assertEquals("user", emailDTO.getUsername());
	     assertEquals("email@email.com", emailDTO.getEmail());
	     assertEquals("subject", emailDTO.getSubject());
	     assertEquals("body", emailDTO.getBody());
	 }
	 
	 @Test
	  public void hashCodeTest() {
	      assertEquals(emailDTO.hashCode(), other.hashCode());
	    }
	 
	 @Test
	 public void hashCodeTestWithNull() {
		 EmailDTO emailDTO = new EmailDTO(null,null,null,null,null);
		 EmailDTO other = new EmailDTO(null,null,null,null,null);
		 assertEquals(emailDTO.hashCode(), other.hashCode());
	 }

	 

}
