package com.qa.test.controller;

import com.qa.domain.Booking;
import com.qa.repo.BookingRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BookingControllerIntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private BookingRepository repo;

    private long id;

    private Booking testBooking;

    private Booking testBookingWithID;

    @Before
    public void init() {
        this.repo.deleteAll();
        this.testBooking = new Booking(1L, "Shrek 3", "27/05/2020 15:30", BigDecimal.valueOf(13.99),"email@email.com","0044 771234123","Jeff Tester",1,1,0);
        this.testBookingWithID = this.repo.save(this.testBooking);
        this.id = this.testBookingWithID.getId();
    }

    @Test
    public void testCreateBooking() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/createBooking");
        mockRequest.contentType(MediaType.APPLICATION_JSON);
        mockRequest.content(testBookingWithID.toString());
        mockRequest.accept(MediaType.APPLICATION_JSON);
        ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher matchContent = MockMvcResultMatchers.content().json(testBookingWithID.toString());
        this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
    }

//    @Test
//    public void testDeleteBooking() throws Exception {
//        this.mock.perform(request(HttpMethod.DELETE, "/deleteBooking/" + this.id)).andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void testGetAllBookings() throws Exception {
//        List<Booking> bookingList = new ArrayList<>();
//        bookingList.add(this.testBookingWithID);
//
//        String content = this.mock.perform(request(HttpMethod.GET, "/getAllBookings").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//
//        assertEquals(testBookingWithID.listToJsonString(bookingList), content);
//    }
//
//    @Test
//    public void testUpdateBooking() throws Exception {
//        Booking newBooking = new Booking("Tester Two", 2L, "It was worse than he said");
//        newBooking.setId(testBookingWithID.getId());
//        Booking updatedBooking = new Booking(newBooking.getId(), newBooking.getUserName(), newBooking.getRating(), newBooking.getBooking());
//
//        String result = this.mock
//                .perform(request(HttpMethod.PUT, "/updateBooking/" + this.id).accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON).content(newBooking.toString()))
//                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//
//        assertEquals(updatedBooking.toString(), result);
//    }

}