package com.qa.test.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.qa.domain.Response;


public class ResponseTest {
	
	private Response response;
	private Response other;
	
	 @Before
	 public void setUp() {
		 response = new Response(true, "my response");
		 other = new Response(true, "my response");
	    }
	 
	 @Test
	    public void settersTest() {
	        assertNotNull(response.isStatus());
	        assertNotNull(response.getDetails());

	        response.setDetails(null);
	        assertNull(response.getDetails());
	    }
	 
	 @Test
	    public void equalsWithNull() {
	        assertNotEquals(null, response);
	    }

	    @Test
	    public void equalsWithDifferentObject() {
	        assertNotEquals(response, new Object());
	    }
	    
	    
	    @Test
	    public void checkEquality() {
	        assertEquals(response, response);
	    }

	   

	    @Test
	    public void ResponseDetailsNullButOtherDetailsNotNull() {
	        response.setDetails(null);
	        assertNotEquals(response, other);
	    }

	    @Test
	    public void ResponseStatusNotEqual() {
	        other.setStatus(false);
	        assertNotEquals(response, other);
	    }
	    
	    ////////////////////////////STATUS////////////////////
	    @Test
	    public void otherStatusDifferent() {
	        other.setStatus(false);
	        assertNotEquals(response, other);
	    }
	    ///////////////////////////DETAILS////////////////////
	    @Test
	    public void nullDetails() {
	        response.setDetails(null);
	        assertNotEquals(response, other);
	    }


	    @Test
	    public void otherDetailsDifferent() {
	        other.setDetails("my next response");
	        assertNotEquals(response, other);
	    }
	    //////////////////////////////////////////////////////

	   
	 
}
